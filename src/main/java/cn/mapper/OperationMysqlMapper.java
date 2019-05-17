package cn.mapper;

import java.util.List;

import cn.crawlerTweet.entity.Article;
import cn.crawlerTweet.entity.Blogger;
import cn.crawlerTweet.entity.BloggerTweet;
import cn.crawlerTweet.entity.BloggerTweetImage;
import cn.crawlerTweet.entity.Keywords;
import cn.crawlerTweet.entity.Topic;
import cn.crawlerTweet.entity.TopicTweet;
import cn.crawlerTweet.entity.TopicTweetImage;
import cn.crawlerTweet.entity.Video;
import cn.crawlerTweet.entity.WebSite;

public interface OperationMysqlMapper {

	/**
	 * ��ȡ����
	 */
	WebSite getWebSite();
	
	/**
	 * ��ȡ�ؼ���
	 */
	List<Keywords> queryKeyWords();
	
	/**
	 * ��ȡ���쳣�Ĺؼ���
	 * @return
	 */
	List<Keywords> getExceptionKeyWords();
	
	/**
	 * ���벩����Ϣ
	 */
	void insertBlogger(Blogger blogger);
	
	/**
	 * ���벩������΢����Ϣ
	 * @param bloggerTweet
	 */
	void insertBloggerTweet(BloggerTweet bloggerTweet);
	
	/**
	 * ���벩������΢����ͼƬ����
	 * @param bloggerTweetImageUrl
	 */
	void insertBloggerTweetImage(BloggerTweetImage bloggerTweetImage);
	
	/**
	 * ����video
	 * @param video
	 */
	void insertVideo(Video video);
	
	/**
	 * ����article(����)
	 * @param article
	 */
	void insertArticle(Article article);
		
	/**
	 * ���뻰��
	 * @param topic
	 */
	void insertTopic(Topic topic);
	
	/**
	 * ���뻰��΢��
	 * @param topicTweet
	 */
	void insertTopicTweet(TopicTweet topicTweet);
	
	/**
	 * ���뻰��΢��ͼƬ
	 * @param topicTweetImage
	 */
	void insertTopicTweetImage(TopicTweetImage topicTweetImage);
	
	/**
	 * �޸�keyword ��ifException
	 */
	void updateKeywords(int id,int value);
	

	
}
