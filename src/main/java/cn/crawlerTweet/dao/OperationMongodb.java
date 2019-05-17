package cn.crawlerTweet.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

import cn.crawlerTweet.entity.Article;
import cn.crawlerTweet.entity.Blogger;
import cn.crawlerTweet.entity.BloggerTweet;
import cn.crawlerTweet.entity.BloggerTweetImage;
import cn.crawlerTweet.entity.Topic;
import cn.crawlerTweet.entity.TopicTweet;
import cn.crawlerTweet.entity.TopicTweetImage;
import cn.crawlerTweet.entity.Video;

public class OperationMongodb {

	private Mongo mg = null;
	private DB db;
	private DBCollection bloggerinfoDatabase; // ������Ϣ���ݿ�
	private DBCollection bloggertweetDatabase; // ����΢�����ݿ�
	private DBCollection bloggertweetimageurlDatabase; // ����ͼƬ���ݿ�
	private DBCollection articleDatabase; // �������ݿ�
	private DBCollection videoDatabase; // ��Ƶ���ݿ�
	private DBCollection topicDatabase; // �������ݿ�
	private DBCollection topicTweetDatabase; // ����΢�����ݿ�
	private DBCollection topicTweetImageDatabase; // ����΢��ͼƬ���ݿ�

	public OperationMongodb() {
		init();
	}

	@SuppressWarnings("deprecation")
	private void init() {
		try {
			mg = new Mongo("localhost", 27017);
		} catch (MongoException e) {
			e.printStackTrace();
		}
		// ��ȡtemp DB�����Ĭ��û�д�����mongodb���Զ�����
		db = mg.getDB("crawlerTweet");

		bloggerinfoDatabase = db.getCollection("bloggerinfo");
		bloggertweetDatabase = db.getCollection("bloggertweet");
		bloggertweetimageurlDatabase = db.getCollection("bloggertweetimageurl");
		articleDatabase = db.getCollection("article");
		videoDatabase = db.getCollection("video");
		topicDatabase = db.getCollection("topic");
		topicTweetDatabase = db.getCollection("topicTweet");
		topicTweetImageDatabase = db.getCollection("topicTweetImage");
	}

	/**
	 * ���벩����Ϣ
	 * 
	 * @param mation
	 */
	public void insertBloggerInfo(Blogger bloggerInfo) {
		DBObject bloggerDB = new BasicDBObject();
		bloggerDB.put("id", bloggerInfo.getId());
		bloggerDB.put("bloggerUrl", bloggerInfo.getBloggerUrl());
		bloggerDB.put("bloggerName", bloggerInfo.getBloggerName());
		bloggerDB.put("bloggerJob", bloggerInfo.getBloggerJob());
		bloggerDB.put("attentionNumber", bloggerInfo.getAttentionNumber());
		bloggerDB.put("fansNumber", bloggerInfo.getFansNumber());
		bloggerDB.put("tweetNumber", bloggerInfo.getTweetNumber());

		bloggerinfoDatabase.save(bloggerDB);
	}

	/**
	 * ���벩��΢����Ϣ
	 * 
	 * @param mation
	 */
	public void insertBloggerTweet(BloggerTweet bloggerTweet) {
		DBObject bloggerTweetDB = new BasicDBObject();
		bloggerTweetDB.put("id", bloggerTweet.getId());
		bloggerTweetDB.put("bId", bloggerTweet.getBId());
		bloggerTweetDB.put("tweetTitle", bloggerTweet.getTweetTitle());
		bloggerTweetDB.put("tweetTime", bloggerTweet.getTweetTime());
		bloggerTweetDB.put("tweetVideoUrl", bloggerTweet.getTweetVideoUrl());
		bloggerTweetDB.put("tweetVideoName", bloggerTweet.getTweetVideoName());
		bloggerTweetDB.put("transpondNumber", bloggerTweet.getTranspondNumber());
		bloggerTweetDB.put("commentNumber", bloggerTweet.getCommentNumber());
		bloggerTweetDB.put("likeNumber", bloggerTweet.getLikeNumber());
		bloggerTweetDB.put("tweetIVPath", bloggerTweet.getTweetIVPath());
		bloggertweetDatabase.save(bloggerTweetDB);
	}

	/**
	 * ���벩��΢��ͼƬ
	 * 
	 * @param mation
	 */
	public void insertBloggerTweetImageUrl(BloggerTweetImage bloggerTweetImageUrl) {
		DBObject bloggerTweetImageUrlDB = new BasicDBObject();
		bloggerTweetImageUrlDB.put("id", bloggerTweetImageUrl.getId());
		bloggerTweetImageUrlDB.put("bloggerUrl", bloggerTweetImageUrl.getBtId());
		bloggerTweetImageUrlDB.put("bloggerName", bloggerTweetImageUrl.getImageUrl());
		bloggerTweetImageUrlDB.put("bloggerJob", bloggerTweetImageUrl.getImageName());

		bloggertweetimageurlDatabase.save(bloggerTweetImageUrlDB);
	}

	/**
	 * ��������
	 * 
	 * @param article
	 */
	public void insertArticle(Article article) {
		DBObject articleDB = new BasicDBObject();
		articleDB.put("id", article.getId());
		articleDB.put("url", article.getUrl());
		articleDB.put("title", article.getTitle());
		articleDB.put("blogger", article.getBlogger());
		articleDB.put("author", article.getAuthor());
		articleDB.put("time", article.getTime());
		articleDB.put("sourceUrl", article.getSourceUrl());
		articleDB.put("readNumber", article.getReadNumber());
		articleDB.put("content", article.getContent());
		articleDB.put("pdfName", article.getPdfName());
		articleDB.put("pdfFilePath", article.getPdfFilePath());

		articleDatabase.save(articleDB);
	}

	/**
	 * ������Ƶ
	 */
	public void insertVideo(Video video) {

		DBObject videoDB = new BasicDBObject();
		videoDB.put("id", video.getId());
		videoDB.put("videoName", video.getVideoName());
		videoDB.put("videoImageUrl", video.getVideoImageUrl());
		videoDB.put("videoUrl", video.getVideoUrl());
		videoDB.put("videoPath", video.getVideoPath());
		videoDB.put("videoTranspondNumber", video.getVideoTranspondNumber());
		videoDB.put("videoCommentNumber", video.getVideoCommentNumber());
		videoDB.put("videoLikeNumber", video.getVideoLikeNumber());

		videoDatabase.save(videoDB);

	}

	/**
	 * ���뻰��
	 */
	public void insertTopic(Topic topic) {

		DBObject topicoDB = new BasicDBObject();
		topicoDB.put("id", topic.getId());
		topicoDB.put("url", topic.getUrl());
		topicoDB.put("topicName", topic.getTopicName());
		topicoDB.put("readNumber", topic.getReadNumber());
		topicoDB.put("discussNumbaer", topic.getDiscussNumbaer());
		topicoDB.put("lead", topic.getLead());
		topicDatabase.save(topicoDB);

	}

	/**
	 * ���뻰��΢��
	 * 
	 * @param topicTweet
	 */
	public void insertTopicTweet(TopicTweet topicTweet) {

		DBObject topicTweetDB = new BasicDBObject();
		topicTweetDB.put("id", topicTweet.getId());
		topicTweetDB.put("tId", topicTweet.gettId());
		topicTweetDB.put("topictweetBlogger", topicTweet.getTopictweetBlogger());
		topicTweetDB.put("topictweetTitle", topicTweet.getTopictweetTitle());
		topicTweetDB.put("topicTweetTime", topicTweet.getTopicTweetTime());
		topicTweetDB.put("topicTweetVideoUrl", topicTweet.getTopicTweetVideoUrl());
		topicTweetDB.put("topicTweetVideoName", topicTweet.getTopicTweetVideoName());
		topicTweetDB.put("topicTranspondNumber", topicTweet.getTopicTranspondNumber());
		topicTweetDB.put("topicCommentNumber", topicTweet.getTopicCommentNumber());
		topicTweetDB.put("topicLikeNumber", topicTweet.getTopicLikeNumber());
		topicTweetDB.put("topicTweetIVPath", topicTweet.getTopicTweetIVPath());
		topicTweetDatabase.save(topicTweetDB);

	}

	/**
	 * ���뻰��΢��ͼƬ
	 * 
	 * @param topicTweet
	 */
	public void insertTopicTweetImage(TopicTweetImage topicTweetImage) {

		DBObject topicTweetImageDB = new BasicDBObject();
		topicTweetImageDB.put("id", topicTweetImage.getId());
		topicTweetImageDB.put("ttId", topicTweetImage.getTtId());
		topicTweetImageDB.put("topicImageUrl", topicTweetImage.getTopicImageUrl());
		topicTweetImageDB.put("topicImageName", topicTweetImage.getTopicImageName());
		topicTweetImageDatabase.save(topicTweetImageDB);

	}

}
