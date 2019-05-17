package cn.crawlerTweet.service;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import cn.crawlerTweet.dao.ParseTool;
import cn.crawlerTweet.entity.Keywords;

public class HtmlParseTool {

	private ExecutorService parseTweet = Executors.newFixedThreadPool(15); // 线程池
	private List<Keywords> keywords = ShareVar.opMysql.queryKeyWord(); // 获取关键字
	private ParseTool parsetool = new ParseTool(); // 解析类
	private boolean isend = false; // 判断是否等待通知

	private void ifExceptionKeywords() {
		boolean isend = true;
		while (isend) {
			List<Keywords> keywords = ShareVar.opMysql.getExceptionKeyWords();
			if (ShareVar.strDenoising.objIfNull(keywords) && keywords.size() > 0) {
				for (final Keywords keyword : keywords) {

					boolean ifUpdate = true;
					WebDriver driver = null;
					try {

						driver = ShareVar.toLoadbrowser("chrome"); // 加载谷歌浏览器
						driver.get(ShareVar.wbs.getCrawerUrl()); // 打开微博主页
						ShareVar.sleep(6000);

						parsetool.driverOperate.registTweet(driver, ShareVar.username,
								ShareVar.decode(ShareVar.password)); // 登录微博
						parsetool.driverOperate.searchBloggerName(driver, keyword.getKeyword()); // 搜索框输入对应的关键字并搜索

						judgeSerchWhere(driver, keyword); // 用作判断是找人、文章、视频、话题

						if (ifUpdate)
							ShareVar.opMysql.updateKeywords(keyword.getId(), 0);

					} catch (Exception e) {
						ifUpdate = false;
					} finally {
						if (driver != null)
							driver.quit();
					}

				}
			} else {
				isend = false;
				return;
			}
		}
	}

	/**
	 * 用作判断是找人、文章、视频、话题
	 * 
	 * @param driver
	 * @param keywords
	 */
	private void judgeSerchWhere(WebDriver driver, Keywords keywords) {
		int type = keywords.getSerchWhere();
		switch (type) {
		// 找人
		case 1:
			parsetool.crawlerLookPerson(driver);
			break;
		// 文章
		case 2:
			parsetool.crawlerArticle(driver);
			break;
		// 视频
		case 3:
			parsetool.crawlerVideo(driver, keywords.getKeyword());
			break;
		// 图片
		case 4:
			break;
		// 话题
		case 5:
			parsetool.crawlerTopic(driver);
			break;
		}
	}

	private void startParseHtml() {

		final CountDownLatch latch = new CountDownLatch(keywords.size());
		if (ShareVar.strDenoising.objIfNull(ShareVar.wbs)) {

			for (final Keywords keyword : keywords) {
				ShareVar.sleep(10000);
				if (ShareVar.strDenoising.strIfNull(keyword.getKeyword())) {
					parseTweet.execute(new Runnable() {
						@Override
						public void run() {

							WebDriver driver = null;
							try {
								driver = ShareVar.toLoadbrowser("chrome"); // 加载谷歌浏览器
								driver.get(ShareVar.wbs.getCrawerUrl()); // 打开微博主页
								ShareVar.sleep(6000);

								parsetool.driverOperate.registTweet(driver, ShareVar.username,
										ShareVar.decode(ShareVar.password)); // 登录微博

								parsetool.driverOperate.searchBloggerName(driver, keyword.getKeyword()); // 搜索框输入对应的关键字并搜索

								judgeSerchWhere(driver, keyword); // 用作判断是找人、文章、视频、话题

								latch.countDown();
							} catch (Exception e) {
								ShareVar.opMysql.updateKeywords(keyword.getId(), 1);
							} finally {
								if (ShareVar.strDenoising.objIfNull(driver))
									driver.quit();
							}
						}
					});
				}
			}
		}

		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		ifExceptionKeywords();

		synchronized (parsetool) {
			isend = true;
			System.out.println("采集规则完毕，发出通知");
			parsetool.notify();
		}

	}

	/**
	 * 读取WebDriver位置
	 */
	public void readDriverInfo() {

		final CountDownLatch latch = new CountDownLatch(1);
		parseTweet.execute(new Runnable() {

			@Override
			public void run() {

				System.out.println("解析入库进行等待。。。。");
				synchronized (parsetool) {
					while (!isend) {
						try {
							parsetool.wait();
							System.out.println("解析入库开始执行");
							parsetool.parseTweetInfo();
							latch.countDown();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}

				try {
					latch.await(30, TimeUnit.MINUTES);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("解析执行结束");

			}
		});

	}

	public static void start() {

		HtmlParseTool hpt = new HtmlParseTool();
		hpt.readDriverInfo();
		hpt.startParseHtml();

	}
}