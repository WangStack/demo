package cn.crawlerTweet.service;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cn.crawlerTweet.dao.DownLoadImage;
import cn.crawlerTweet.dao.DownLoadPdf;
import cn.crawlerTweet.dao.DownLoadVideo;
import cn.crawlerTweet.entity.Article;
import cn.crawlerTweet.entity.Blogger;
import cn.crawlerTweet.entity.BloggerTweet;
import cn.crawlerTweet.entity.BloggerTweetImage;
import cn.crawlerTweet.entity.Topic;
import cn.crawlerTweet.entity.TopicTweet;
import cn.crawlerTweet.entity.TopicTweetImage;
import cn.crawlerTweet.entity.Video;

public class ThreadParse {

	private ExecutorService parseTweet = Executors.newFixedThreadPool(15);

	// ������Ƶ�̳߳�
	private ExecutorService downVideo = Executors.newFixedThreadPool(15);
	// ����pdf�̳߳�
	private ExecutorService downPdf = Executors.newFixedThreadPool(3);
	// ����ͼƬ�̳߳�
	private ExecutorService downImage = Executors.newFixedThreadPool(15);
	// ���������̳߳�
	private ExecutorService createArticle = Executors.newFixedThreadPool(3);

	// driver ����
	private DriverOperate driverOperate = new DriverOperate();

	/**
	 * ���߳̽������
	 */
	public void parse() {
		parseTweet.execute(new Runnable() {
			public void run() {
				if (ShareVar.strDenoising.objIfNull(ShareVar.bloggerSet) && ShareVar.bloggerSet.size() > 0)
					parseBloggerInfo();
			}
		});

		parseTweet.execute(new Runnable() {
			public void run() {
				if (ShareVar.strDenoising.objIfNull(ShareVar.articleSet) && ShareVar.articleSet.size() > 0)
					parseArticle();
			}
		});
		parseTweet.execute(new Runnable() {
			public void run() {
				if (ShareVar.strDenoising.objIfNull(ShareVar.videoSet) && ShareVar.videoSet.size() > 0)
					parsevideo();
			}
		});
		parseTweet.execute(new Runnable() {
			public void run() {
				if (ShareVar.strDenoising.objIfNull(ShareVar.topicSet) && ShareVar.topicSet.size() > 0)
					parseTopic();
			}
		});

	}

	/**
	 * �������˲����
	 */
	private void parseBloggerInfo() {
		for (final Blogger bloggerInfo : ShareVar.bloggerSet) {
			parseTweet.execute(new Runnable() {

				public void run() {
					ShareVar.opMysql.insertBlogger(bloggerInfo);
					ShareVar.opMongoDB.insertBloggerInfo(bloggerInfo);
				}
			});

			for (final BloggerTweet bloggerTweet : bloggerInfo.getBlogerTweetSet()) {
				parseTweet.execute(new Runnable() {
					@Override
					public void run() {
						ShareVar.opMysql.insertBloggerTweet(bloggerTweet);
						ShareVar.opMongoDB.insertBloggerTweet(bloggerTweet);
					}
				});
				if (ShareVar.strDenoising.strIfNull(bloggerTweet.getTweetIVPath())) {

					if (ShareVar.strDenoising.strIfNull(bloggerTweet.getTweetVideoUrl())) {

						downVideo.execute(new DownLoadVideo(bloggerTweet.getTweetIVPath(),
								bloggerTweet.getTweetVideoName(), bloggerTweet.getTweetVideoUrl()));
					}

					for (final BloggerTweetImage bloggerTweetImage : bloggerTweet.getTweetImageUrl()) {
						parseTweet.execute(new Runnable() {
							@Override
							public void run() {
								if (ShareVar.strDenoising.strIfNull(bloggerTweetImage.getImageUrl())
										&& bloggerTweetImage.getId() >= 1) {
									ShareVar.opMysql.insertBloggerTweetImage(bloggerTweetImage);
									ShareVar.opMongoDB.insertBloggerTweetImageUrl(bloggerTweetImage);
								}
							}
						});

						downImage.execute(new Runnable() {
							@Override
							public void run() {
								downImage.execute(new DownLoadImage(bloggerTweet.getTweetIVPath(),
										bloggerTweetImage.getImageName(), bloggerTweetImage.getImageUrl()));
							}
						});
					}
				}
			}
		}
	}

	/**
	 * ��������
	 */
	private void parseArticle() {
		final Set<String> thread1Url = new LinkedHashSet<String>();
		final Set<String> thread2Url = new LinkedHashSet<String>();
		final Set<String> thread3Url = new LinkedHashSet<String>();
		ShareVar.strDenoising.meanUrlSet(thread1Url, thread2Url, thread3Url, ShareVar.articleSet);
		createArticle.execute(new Runnable() {
			@Override
			public void run() {
				crawlerArticle(thread1Url);
			}
		});

		createArticle.execute(new Runnable() {
			@Override
			public void run() {
				crawlerArticle(thread2Url);
			}
		});

		createArticle.execute(new Runnable() {
			@Override
			public void run() {
				crawlerArticle(thread3Url);
			}
		});

	}

	/**
	 * ��ȡ���²����
	 * 
	 * @param url
	 */
	private void crawlerArticle(Set<String> articleSet) {
		WebDriver driver = ShareVar.toLoadbrowser("chrome");
		driver.get(ShareVar.wbs.getCrawerUrl());
		ShareVar.sleep(5000);
		driverOperate.registTweet(driver, ShareVar.username, ShareVar.decode(ShareVar.password)); // ��¼΢��
		ShareVar.sleep(5000);

		for (String url : articleSet) {
			if (ShareVar.strDenoising.strIfNull(url)) {

				driver.get(url);
				ShareVar.sleep(5000);
				Article article = new Article();
				article.setId(ShareVar.getArticleId());
				article.setUrl(url);

				String title = driverOperate.cssGetTextValue(driver, ShareVar.wbs.getArticleTitleRule());
				if (ShareVar.strDenoising.strIfNull(title)) {
					article.setTitle(title);
					System.out.println(title);
				}
				String blogger = driverOperate.xpathGetTextValue(driver, ShareVar.wbs.getArticleBloggerRule());
				if (ShareVar.strDenoising.strIfNull(blogger)) {
					article.setBlogger(blogger);
					System.out.println("������" + blogger);
				}

				String author = driverOperate.xpathGetTextValue(driver, ShareVar.wbs.getArticleAuthorRule());
				if (ShareVar.strDenoising.strIfNull(author)) {
					article.setBlogger(author);
					System.out.println("���ߣ�" + author);
				}

				String time = driverOperate.cssGetTextValue(driver, ShareVar.wbs.getArticleTimeRule());
				if (ShareVar.strDenoising.strIfNull(time)) {
					article.setTime(time);
					System.out.println(time);
				}
				String sourceUrl = null;
				try {
					sourceUrl = driver.findElements(By.xpath(ShareVar.wbs.getArticleSourceUrlRule())).get(1)
							.getAttribute("href");
				} catch (Exception e) {
					sourceUrl = driverOperate.xpathGetTypeValue(driver, ShareVar.wbs.getArticleSourceUrlRule(), "href");
				}
				if (ShareVar.strDenoising.strIfNull(sourceUrl) && !(sourceUrl.contains("javascript"))) {
					article.setArticleSourceUrl(sourceUrl);
					System.out.println("ԭ��ַ��" + sourceUrl);
				}

				String readNumber = driverOperate.xpathGetTextValue(driver, ShareVar.wbs.getArticleReadNumberRule());
				if (ShareVar.strDenoising.strIfNull(sourceUrl)) {
					article.setReadNumber(readNumber);
					System.out.println("�Ķ�����" + readNumber);
				}

				String content = driverOperate.cssGetTextValue(driver, ShareVar.wbs.getArticleContenrRule());
				if (ShareVar.strDenoising.strIfNull(content)) {
					article.setContent(content);
					System.out.println("���ݣ�" + content);
				}

				if (!(ShareVar.strDenoising.strIfNull(article.getTitle())
						&& ShareVar.strDenoising.strIfNull(article.getContent())
						&& ShareVar.strDenoising.strIfNull(article.getTime()))) {

					article.setPdfFilePath(ShareVar.wbs.getArticlePath() + article.getId() + ".pdf");
					downPdf.execute(new DownLoadPdf(url, article.getPdfFilePath()));
				}

				ShareVar.opMysql.insertArticle(article);
				ShareVar.opMongoDB.insertArticle(article);
			}
		}
		driver.quit();
	}

	/**
	 * ������Ƶ,�����
	 */
	private void parsevideo() {
		for (final Video video : ShareVar.videoSet) {

			parseTweet.execute(new Runnable() {
				@Override
				public void run() {
					ShareVar.opMysql.insertVideo(video);
				}
			});

			if (ShareVar.strDenoising.strIfNull(video.getVideoPath())) {

				if (ShareVar.strDenoising.strIfNull(video.getVideoUrl())) {
					downVideo.execute(
							new DownLoadVideo(video.getVideoPath(), video.getVideoName(), video.getVideoUrl()));
				}

				if (ShareVar.strDenoising.strIfNull(video.getVideoImageUrl())) {
					downImage.execute(
							new DownLoadImage(video.getVideoPath(), video.getVideoName(), video.getVideoImageUrl()));
				}
			}

		}
	}

	/**
	 * �������Ⲣ���
	 */
	private void parseTopic() {
		// ��������
		for (final Topic topic : ShareVar.topicSet) {

			parseTweet.execute(new Runnable() {
				@Override
				public void run() {
					ShareVar.opMysql.insertTopic(topic);
					ShareVar.opMongoDB.insertTopic(topic);
				}
			});

			// ����΢��
			for (final TopicTweet topicTweet : topic.getTopicTweetSet()) {
				parseTweet.execute(new Runnable() {
					@Override
					public void run() {
						ShareVar.opMysql.insertTopicTweet(topicTweet);
						ShareVar.opMongoDB.insertTopicTweet(topicTweet);
					}
				});

				if (ShareVar.strDenoising.strIfNull(topicTweet.getTopicTweetIVPath())) {
					if (ShareVar.strDenoising.strIfNull(topicTweet.getTopicTweetVideoUrl()))
						downVideo.execute(new DownLoadVideo(topicTweet.getTopicTweetIVPath(),
								topicTweet.getTopicTweetVideoName(), topicTweet.getTopicTweetVideoUrl()));
				}

				for (final TopicTweetImage topicTweetImage : topicTweet.getTopicTweetImageUrl()) {
					parseTweet.execute(new Runnable() {
						@Override
						public void run() {
							ShareVar.opMysql.insertTopicTweetImage(topicTweetImage);
							ShareVar.opMongoDB.insertTopicTweetImage(topicTweetImage);
						}
					});

					downImage.execute(new Runnable() {
						@Override
						public void run() {
							downImage.execute(new DownLoadImage(topicTweet.getTopicTweetIVPath(),
									topicTweetImage.getTopicImageName(), topicTweetImage.getTopicImageUrl()));
						}
					});
				}

			}

		}
	}

}
