package cn.crawlerTweet.dao;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cn.crawlerTweet.entity.Blogger;
import cn.crawlerTweet.entity.BloggerTweet;
import cn.crawlerTweet.entity.BloggerTweetImage;
import cn.crawlerTweet.entity.Topic;
import cn.crawlerTweet.entity.TopicTweet;
import cn.crawlerTweet.entity.TopicTweetImage;
import cn.crawlerTweet.entity.Video;
import cn.crawlerTweet.service.DriverOperate;
import cn.crawlerTweet.service.ShareVar;
import cn.crawlerTweet.service.ThreadParse;

public class ParseTool {

	// 操作webDriver类
	public DriverOperate driverOperate = new DriverOperate();

	/**
	 * 爬取博主
	 * 
	 * @param driver
	 */
	public void crawlerLookPerson(WebDriver driver) {

		try {
			driverOperate.xpathClick(driver, ShareVar.wbs.getClickLookPersonRule()); // 点击找人
		} catch (Exception e) {
			driver.findElement(By.linkText("找人")).click();
		}

		ShareVar.sleep(3000);

		String bloggerUrl = null;
		try {
			bloggerUrl = driverOperate.cssGetTypeVaule(driver, ShareVar.wbs.getCssGetPersonUrlRule(), "href"); // css规则获取博主url
		} catch (Exception e) {
			bloggerUrl = driverOperate.xpathGetTypeValue(driver, ShareVar.wbs.getXpathGetPersonUrlRule(), "href"); // xpath规则获取博主url
		}

		if (ShareVar.strDenoising.strIfNull(bloggerUrl)) {
			driver.get(bloggerUrl); // 打开博主
			ShareVar.sleep(5000);

			Blogger bloggerInfo = getBloggerInfo(driver, bloggerUrl); // 获取博主信息

			if (ShareVar.strDenoising.objIfNull(bloggerInfo))
				ShareVar.bloggerSet.add(bloggerInfo);
		}
	}

	/**
	 * 获取博主信息
	 * 
	 * @param driver
	 */
	private Blogger getBloggerInfo(WebDriver driver, String bloggerUrl) {

		Blogger blogger = new Blogger(); // 实例化一个博主信息实例
		blogger.setId(ShareVar.getBloggerId()); // 博主id
		blogger.setBloggerUrl(bloggerUrl); // 博主url

		driverOperate.javaScriptDrop(driver, 0, 300);

		try {
			driverOperate.cssClick(driver, ShareVar.wbs.getClickAllTweetRule()); // 点击全部微博
		} catch (Exception e) {
			driver.findElement(By.linkText("全部")).click();
		}
		ShareVar.sleep(2000);

		String bloggerName = driverOperate.cssGetTextValue(driver, ShareVar.wbs.getBloggerNameRule());
		if (ShareVar.strDenoising.strIfNull(bloggerName)) {
			sysout("博主名称：" + bloggerName);
			blogger.setBloggerName(bloggerName);
		}

		String job = driverOperate.cssGetTextValue(driver, ShareVar.wbs.getBloggerJobRule());
		if (ShareVar.strDenoising.strIfNull(job)) {
			sysout("博主工作：" + job);
			blogger.setBloggerJob(job);
		}

		String attentionNumbe = driverOperate.xpathGetTextValue(driver, ShareVar.wbs.getBloggerAttentionNumberRule());
		String fansNumber = driverOperate.xpathGetTextValue(driver, ShareVar.wbs.getBloggerFansNumberRule());
		String tweetNumber = driverOperate.xpathGetTextValue(driver, ShareVar.wbs.getBloggerTweetNumber());

		if (ShareVar.strDenoising.strIfNull(attentionNumbe)) {
			blogger.setAttentionNumber(attentionNumbe);
			sysout("博主关注数：" + attentionNumbe);
		}

		if (ShareVar.strDenoising.strIfNull(fansNumber)) {
			blogger.setFansNumber(fansNumber);
			sysout("博主粉丝数：" + fansNumber);
		}

		if (ShareVar.strDenoising.strIfNull(tweetNumber)) {
			blogger.setTweetNumber(tweetNumber);
			sysout("博主发出微博数：" + tweetNumber);
		}

		driverOperate.javaScriptDrop(driver, 0, 600);
		ShareVar.sleep(1500);
		for (int number = 1; number <= ShareVar.wbs.getPagenumber(); number++) {

			int count = 10; // 给一个初始值

			for (int i = 0; i < count; i++) {
				BloggerTweet bloggerTweet = new BloggerTweet(); // 实例化一个博主微博类

				// 获取微博模块
				List<WebElement> elements = driver.findElements(By.cssSelector(ShareVar.wbs.getTweetModuleRule()));
				count = elements.size();

				WebElement element = elements.get(i);

				driverOperate.javaScriptLocatiom(driver, element); // 移到element的最顶部
				if (i == 12 || i == 25)
					ShareVar.sleep(3000);

				bloggerTweet.setId(ShareVar.getBloggetTweetId());
				bloggerTweet.setBId(blogger.getId());
				String tweetTitle = ""; // 微博标题

				try {
					driverOperate.elementCssClick(element, ShareVar.wbs.getTweetClickFullTitleRule());// 点击展开全文规则
					ShareVar.sleep(1000);
					tweetTitle = element.findElements(By.cssSelector(ShareVar.wbs.getTweetTitleRule())).get(1).getText();
				} catch (Exception e) {
					tweetTitle = driverOperate.elementCssGetTextValue(element, ShareVar.wbs.getTweetTitleRule());
				}

				if (!(ShareVar.strDenoising.strIfNull(tweetTitle)))
					bloggerTweet.setTweetTitle("混杂");
				else
					bloggerTweet.setTweetTitle(ShareVar.strDenoising.strIllegalCharacter(tweetTitle));
				sysout("微博标题：" + bloggerTweet.getTweetTitle());

				String time = driverOperate.elementCssGetTextValue(element, ShareVar.wbs.getTweetTimeRule()); // 微博发出时间
				if (ShareVar.strDenoising.strIfNull(time)) {
					bloggerTweet.setTweetTime(time);
					sysout("发出时间：" + time);
				}

				String videoUrl = driverOperate.elementCssGetTypeValue(element, ShareVar.wbs.getTweetVideoUrlRule(),
						"src"); // 视频url
				if (ShareVar.strDenoising.strIfNull(videoUrl)) {
					sysout("视频url:" + videoUrl);
					bloggerTweet.setTweetVideoUrl(videoUrl);
				}

				List<WebElement> imageUrlList = driverOperate.elementCssGetElements(element,
						ShareVar.wbs.getTweetImageUrlRule()); // 图片List集合
				if (ShareVar.strDenoising.objIfNull(imageUrlList) && imageUrlList.size() > 0) {
					int imageNumber = 1; // 图片名后名
					for (WebElement imageInfo : imageUrlList) {
						BloggerTweetImage tweetImage = new BloggerTweetImage();
						String imageUrl = imageInfo.getAttribute("src");

						if (ShareVar.strDenoising.strIfNull(imageUrl)) {
							tweetImage.setId(ShareVar.getImageId());
							tweetImage.setBtid(bloggerTweet.getId());
							tweetImage.setImageUrl(imageUrl);

							sysout(tweetImage.getImageUrl());

							if (bloggerTweet.getTweetTitle().length() > 15) {
								tweetImage.setImageName(bloggerTweet.getTweetTitle().substring(0, 15) + "...(" + imageNumber++ + ")");
								if (ShareVar.strDenoising.strIfNull(bloggerTweet.getTweetVideoUrl())) {
									bloggerTweet.setTweetVideoName(bloggerTweet.getTweetTitle().substring(0, 15) + "...");
								}
							} else {
								tweetImage.setImageName(bloggerTweet.getTweetTitle() + "(" + imageNumber++ + ")");
								if (ShareVar.strDenoising.strIfNull(bloggerTweet.getTweetVideoUrl())) {
									bloggerTweet.setTweetVideoName(bloggerTweet.getTweetTitle());
								}
							}
						}
						bloggerTweet.getTweetImageUrl().add(tweetImage);
					}
				}

				if (ShareVar.strDenoising.strIfNull(bloggerTweet.getTweetVideoUrl()) || bloggerTweet.getTweetImageUrl().size() > 0) {
					if (bloggerTweet.getTweetTitle().length() > 20) {
						bloggerTweet.setTweetIVPath(ShareVar.wbs.getTweetIVPath() + blogger.getBloggerName() + "\\"+ bloggerTweet.getTweetTitle().substring(0, 20));
					} else {
						bloggerTweet.setTweetIVPath(ShareVar.wbs.getTweetIVPath() + blogger.getBloggerName() + "\\"+ bloggerTweet.getTweetTitle());
					}
				}

				String transpond = driverOperate.elementCssGetTextValue(element,ShareVar.wbs.getTweetTranspondNumberRule()); // 转发
				if (ShareVar.strDenoising.strIfNull(transpond)) {
					bloggerTweet.setTranspondNumber(transpond);
					sysout("转发：" + transpond);
				}

				String comment = driverOperate.elementCssGetTextValue(element,ShareVar.wbs.getTweetCommentNumberRule()); // 评论
				if (ShareVar.strDenoising.strIfNull(comment)) {
					bloggerTweet.setCommentNumber(comment);
					sysout("评论：" + comment);
				}

				String like = driverOperate.elementCssGetTextValue(element, ShareVar.wbs.getTweetLikeNumberRule()); // 点赞
				if (ShareVar.strDenoising.strIfNull(like)) {
					bloggerTweet.setLikeNumber(like);
					sysout("点赞：" + like);
				}
				sysout("保存位置：" + bloggerTweet.getTweetIVPath());

				blogger.getBlogerTweetSet().add(bloggerTweet);
				sysout("共有：" + bloggerTweet.getTweetImageUrl().size() + "图片");
				sysout("");
				sysout("");
				sysout("");
				sysout("");
				sysout("");

			}

			if (number != ShareVar.wbs.getPagenumber()) {
				driverOperate.javaScriptDownmost(driver);
				try {
					driverOperate.xpathClick(driver, ShareVar.wbs.getTweetNextRule());
				} catch (Exception e) {
					driver.findElement(By.linkText("下一页")).click();
				}
				ShareVar.sleep(5000);
			}
		}

		return blogger;
	}

	/**
	 * 爬取文章
	 * 
	 * @param driver
	 */
	public void crawlerArticle(WebDriver driver) {

		try {
			driverOperate.xpathClick(driver, ShareVar.wbs.getClickArticleRule()); // 单击文章
		} catch (Exception e) {
			driverOperate.linkTextClick(driver, "文章");
		}

		for (int number = 1; number <= ShareVar.wbs.getPagenumber(); number++) {
			Set<String> articleSet = driverOperate.xpathGetTypesValue(driver, ShareVar.wbs.getGetArticleUrlRule(),"href");

			if (ShareVar.strDenoising.objIfNull(articleSet) && articleSet.size() > 0)
				ShareVar.articleSet.addAll(articleSet);

			if (number != ShareVar.wbs.getPagenumber()) {
				driverOperate.javaScriptDownmost(driver);
				driverOperate.xpathClick(driver, ShareVar.wbs.getNextArticleRule());
			}
		}

	}

	/**
	 * 爬取视频
	 */
	public void crawlerVideo(WebDriver driver, String keyword) {
		try {
			driverOperate.xpathClick(driver, ShareVar.wbs.getClickVideoRule()); // 点击视频
		} catch (Exception e) {
			driverOperate.linkTextClick(driver, "视频");
		}
		ShareVar.sleep(2000);

		for (int number = 1; number <= ShareVar.wbs.getPagenumber(); number++) {
			Set<Video> videoSet = xpathGetVideoInfo(driver, keyword);

			if (ShareVar.strDenoising.objIfNull(videoSet) && videoSet.size() > 0)
				ShareVar.videoSet.addAll(videoSet);

			if (number != ShareVar.wbs.getPagenumber()) {
				driverOperate.javaScriptDownmost(driver);
				driverOperate.xpathClick(driver, ShareVar.wbs.getNextVideoRule());
			}
		}
	}

	/**
	 * 爬取video信息
	 */
	private Set<Video> xpathGetVideoInfo(WebDriver driver, String keyword) {

		Set<Video> videoSet = new LinkedHashSet<Video>();

		// 获取视频模块
		List<WebElement> elements = driverOperate.xpathGetElements(driver, ShareVar.wbs.getVideoModuleRule());
		if (ShareVar.strDenoising.objIfNull(elements) && elements.size() > 0) {
			for (WebElement element : elements) {

				driverOperate.javaScriptLocatiom(driver, element);

				Video video = new Video();
				video.setId(ShareVar.getVideoId());
				sysout("");
				sysout("");

				// 视频标题
				String videoTitle = null;
				try {
					driverOperate.elementCssClick(element, ShareVar.wbs.getVideoClickFullTitleRule());
					ShareVar.sleep(1000);
					videoTitle = element.findElements(By.cssSelector(ShareVar.wbs.getVideoTitleRule())).get(1)
							.getText();
				} catch (Exception e) {
					videoTitle = driverOperate.elementCssGetTextValue(element, ShareVar.wbs.getVideoTitleRule());
				}
				if (ShareVar.strDenoising.strIfNull(videoTitle)) {
					video.setVideoName(ShareVar.strDenoising.strIllegalCharacter(videoTitle));
					sysout(video.getVideoName());
				} else
					video.setVideoName("混杂");

				// 视频图片url
				String videoImageUrl = driverOperate.elementCssGetTypeValue(element,
						ShareVar.wbs.getVideoImageUrlRule(), "src");
				if (ShareVar.strDenoising.strIfNull(videoImageUrl)) {
					video.setVideoImageUrl(videoImageUrl);
					sysout(videoImageUrl);
				}

				// 视频url
				String videoUrl = driverOperate.elementCssGetTypeValue(element, ShareVar.wbs.getVideoUrlRule(), "src");
				if (ShareVar.strDenoising.strIfNull(videoUrl)) {
					video.setVideoUrl(videoUrl);
					sysout(videoUrl);
				}

				// 视频转发数量
				String transpond = driverOperate.elementCssGetTextValue(element,
						ShareVar.wbs.getVideoTranspondNumberRrule());
				if (ShareVar.strDenoising.strIfNull(transpond)) {
					video.setVideoTranspondNumber(transpond);
					sysout("视频转发数：" + transpond);
				}

				// 视频评论数
				String comment = driverOperate.elementCssGetTextValue(element,
						ShareVar.wbs.getVideoCommentNumberRrule());
				if (ShareVar.strDenoising.strIfNull(comment)) {
					video.setVideoCommentNumber(comment);
					sysout("视频评论数：" + comment);
				}

				// 视频点赞数
				String like = driverOperate.elementCssGetTextValue(element, ShareVar.wbs.getVideoLikeNumberRrule());
				if (ShareVar.strDenoising.strIfNull(like)) {
					video.setVideoLikeNumber(like);
					sysout("视频点赞数：" + like);
				}

				videoSet.add(video);

				if (ShareVar.strDenoising.strIfNull(video.getVideoUrl())
						|| ShareVar.strDenoising.strIfNull(video.getVideoImageUrl())) {

					if (video.getVideoName().length() > 20)
						video.setVideoPath(
								(ShareVar.wbs.getVideoPath() + keyword + "\\" + video.getVideoName().substring(0, 20)));
					else
						video.setVideoPath((ShareVar.wbs.getVideoPath() + keyword + "\\" + video.getVideoName()));
				}

				sysout(video.getVideoPath());

				sysout("");
				sysout("");
				sysout("");
				sysout("");
			}
		}
		return videoSet;

	}

	/**
	 * 爬取话题
	 */
	public void crawlerTopic(WebDriver driver) {
		System.out.println();
		try {
			driverOperate.xpathClick(driver, ShareVar.wbs.getClickTopicRule()); // 点击话题
		} catch (Exception e) {
			driverOperate.linkTextClick(driver, "话题");
		}
		String topicUrl = driverOperate.xpathGetTypeValue(driver, ShareVar.wbs.getTopicUrlRule(), "href");

		driver.get(topicUrl);
		ShareVar.sleep(5000);

		Topic topicInfo = crawlerTopic(driver, topicUrl);

		if (ShareVar.strDenoising.objIfNull(topicInfo))
			ShareVar.topicSet.add(topicInfo);

	}

	/**
	 * 获取话题微博规则
	 */
	private Topic crawlerTopic(WebDriver driver, String url) {

		Topic topicInfo = new Topic();
		topicInfo.setId(ShareVar.getTopicId());
		topicInfo.setUrl(url);

		String topicTitle = driverOperate.cssGetTextValue(driver, ShareVar.wbs.getTopicTitleRule());
		if (ShareVar.strDenoising.strIfNull(topicTitle)) {
			topicInfo.setTopicName(ShareVar.strDenoising.strIllegalCharacter(topicTitle));
			sysout("话题标题：" + topicTitle);
		}

		String readerNumber = driverOperate.xpathGetTextValue(driver, ShareVar.wbs.getTopicReadNumberRule());
		if (ShareVar.strDenoising.strIfNull(readerNumber)) {
			topicInfo.setReadNumber(readerNumber);
			sysout("阅读数：" + readerNumber);
		}

		String discussNumbaer = driverOperate.xpathGetTextValue(driver, ShareVar.wbs.getTopicDiscussNumbaerRule());
		if (ShareVar.strDenoising.strIfNull(discussNumbaer)) {
			topicInfo.setDiscussNumbaer(discussNumbaer);
			sysout("阅读数：" + discussNumbaer);
		}

		String lead = driverOperate.xpathGetTextValue(driver, ShareVar.wbs.getTopicLeadRule());
		if (ShareVar.strDenoising.strIfNull(lead)) {
			topicInfo.setLead(lead);
			sysout("导语	：" + lead);
		}
		for (int i = 1; i <= ShareVar.wbs.getPagenumber(); i++) {

			List<WebElement> topicTweetList = driverOperate.cssGetElements(driver, ShareVar.wbs.getTopicTweetRule());
			topicTweetList.remove((topicTweetList.size() - 1));
			for (WebElement tweetElement : topicTweetList) {
				TopicTweet topicTweet = new TopicTweet();
				topicTweet.setId(ShareVar.getTopicTweetId());
				topicTweet.settId(topicInfo.getId());

				driverOperate.javaScriptLocatiom(driver, tweetElement);

				String blogger = driverOperate.elementCssGetTextValue(tweetElement,ShareVar.wbs.getTopicTweetBloggerRule());
				if (ShareVar.strDenoising.strIfNull(blogger)) {
					topicTweet.setTopictweetBlogger(blogger);
					sysout("博主：" + blogger);
				}

				String tweetTitle = null;

				try {
					driverOperate.elementCssClick(tweetElement, ShareVar.wbs.getClickFullTopicTitleRule());
					ShareVar.sleep(1000);
					tweetTitle = tweetElement.findElements(By.cssSelector(ShareVar.wbs.getTopictweetTitleRule())).get(1).getText();
				} catch (Exception e) {
					tweetTitle = driverOperate.elementCssGetTextValue(tweetElement, ShareVar.wbs.getTopictweetTitleRule());

				}

				if (ShareVar.strDenoising.strIfNull(tweetTitle)) {
					topicTweet.setTopictweetTitle(ShareVar.strDenoising.strIllegalCharacter(tweetTitle));
					sysout("标题：" + topicTweet.getTopictweetTitle());
				} else
					topicTweet.setTopictweetTitle("混杂");

				String videoUrl = driverOperate.elementCssGetTypeValue(tweetElement,ShareVar.wbs.getTopicTweetVideoUrlRule(), "src");
				if (ShareVar.strDenoising.strIfNull(videoUrl)) {
					topicTweet.setTopicTweetVideoUrl(videoUrl);
					sysout("视频：" + videoUrl);
				}

				// 图片
				List<WebElement> imageUrlList = driverOperate.elementCssGetElements(tweetElement,ShareVar.wbs.getTopicTweetImageUrlRule());
				int imageNumber = 1; // 图片名后名
				if (ShareVar.strDenoising.objIfNull(imageUrlList) && imageUrlList.size() > 0) {
					for (WebElement image : imageUrlList) {

						TopicTweetImage topicTweetImage = new TopicTweetImage();
						topicTweetImage.setId(ShareVar.getTopicTweetImageId());
						topicTweetImage.setTtId(topicTweet.getId());

						String imageUrl = image.getAttribute("src");
						if (ShareVar.strDenoising.strIfNull(imageUrl)) {
							topicTweetImage.setTopicImageUrl(imageUrl);

							sysout(topicTweetImage.getTopicImageUrl());

							if (topicTweet.getTopictweetTitle().length() > 15) {
							
								topicTweetImage.setTopicImageName(topicTweet.getTopictweetTitle().substring(0, 15)+ "...(" + imageNumber++ + "))");
							
								if (ShareVar.strDenoising.strIfNull(topicTweet.getTopicTweetVideoUrl())) {
									topicTweet.setTopicTweetVideoName(topicTweet.getTopictweetTitle().substring(0, 15) + "...");
								}
							} else {
								topicTweetImage.setTopicImageName(topicTweet.getTopictweetTitle() + "(" + imageNumber++ + ")");
								
								if (ShareVar.strDenoising.strIfNull(topicTweet.getTopicTweetVideoUrl())) {
									topicTweet.setTopicTweetVideoName(topicTweet.getTopictweetTitle() + "...");
								}
							}
						}
						topicTweet.getTopicTweetImageUrl().add(topicTweetImage);
					}
				}

				if (ShareVar.strDenoising.strIfNull(topicTweet.getTopicTweetVideoUrl()) || topicTweet.getTopicTweetImageUrl().size() > 0) {
					if (topicTweet.getTopictweetTitle().length() > 20) {
						topicTweet.setTopicTweetIVPath(ShareVar.wbs.getTopicTweetIVPath() + topicTweet.getTopictweetBlogger() + "\\"+ topicTweet.getTopictweetTitle().substring(0, 20));
					} else {
						topicTweet.setTopicTweetIVPath(ShareVar.wbs.getTweetIVPath() + topicTweet.getTopictweetBlogger()+ "\\" + topicTweet.getTopictweetTitle());
					}
				}

				String time = driverOperate.elementCssGetTypeValue(tweetElement, ShareVar.wbs.getTopicTweetTimeRule(), "title");
				if (ShareVar.strDenoising.strIfNull(time)) {
					topicTweet.setTopicTweetTime(time);;
					sysout("时间：" + time);
				}
				
				String transpond = driverOperate.elementCssGetTextValue(tweetElement, ShareVar.wbs.getTopicTranspondNumberRule()); // 转发
				if (ShareVar.strDenoising.strIfNull(transpond)) {
					topicTweet.setTopicTranspondNumber(transpond);
					sysout("转发：" + transpond);
				}

				String comment = driverOperate.elementCssGetTextValue(tweetElement, ShareVar.wbs.getTopicCommentNumberRule()); // 评论
				if (ShareVar.strDenoising.strIfNull(comment)) {
					topicTweet.setTopicCommentNumber(comment);
					sysout("评论：" + comment);
				}

				String like = driverOperate.elementCssGetTextValue(tweetElement, ShareVar.wbs.getTopicLikeNumberRule()); // 点赞
				if (ShareVar.strDenoising.strIfNull(like)) {
					topicTweet.setTopicLikeNumber(like);
					sysout("点赞：" + like);
				}
				sysout("保存位置：" + topicTweet.getTopicTweetIVPath());

				topicInfo.getTopicTweetSet().add(topicTweet);
				sysout("共有：" + topicTweet.getTopicTweetImageUrl().size() + "图片");
				sysout("");
				sysout("");
				sysout("");
				sysout("");
				sysout("");

			}

			if (i != ShareVar.wbs.getPagenumber()) {
				driverOperate.javaScriptDownmost(driver);
				try {
					driverOperate.xpathClick(driver, ShareVar.wbs.getTweetNextRule());
				} catch (Exception e) {
					driver.findElement(By.linkText("下一页")).click();
				}
				ShareVar.sleep(5000);
			}
		}
		return topicInfo;
	}

	/**
	 * 打印
	 * 
	 * @param strings
	 */
	public void sysout(String... strings) {
		for (String string : strings) {
			System.out.println(string);
		}
	}

	/**
	 * 开始解析
	 */
	public void parseTweetInfo() {

		ThreadParse threadParse = new ThreadParse();
		threadParse.parse();

	}

}
