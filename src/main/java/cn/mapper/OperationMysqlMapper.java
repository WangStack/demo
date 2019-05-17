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
	 * 获取规则
	 */
	WebSite getWebSite();
	
	/**
	 * 获取关键字
	 */
	List<Keywords> queryKeyWords();
	
	/**
	 * 获取有异常的关键字
	 * @return
	 */
	List<Keywords> getExceptionKeyWords();
	
	/**
	 * 插入博主信息
	 */
	void insertBlogger(Blogger blogger);
	
	/**
	 * 插入博主发出微博信息
	 * @param bloggerTweet
	 */
	void insertBloggerTweet(BloggerTweet bloggerTweet);
	
	/**
	 * 插入博主发出微博的图片链接
	 * @param bloggerTweetImageUrl
	 */
	void insertBloggerTweetImage(BloggerTweetImage bloggerTweetImage);
	
	/**
	 * 插入video
	 * @param video
	 */
	void insertVideo(Video video);
	
	/**
	 * 插入article(文章)
	 * @param article
	 */
	void insertArticle(Article article);
		
	/**
	 * 插入话题
	 * @param topic
	 */
	void insertTopic(Topic topic);
	
	/**
	 * 插入话题微博
	 * @param topicTweet
	 */
	void insertTopicTweet(TopicTweet topicTweet);
	
	/**
	 * 插入话题微博图片
	 * @param topicTweetImage
	 */
	void insertTopicTweetImage(TopicTweetImage topicTweetImage);
	
	/**
	 * 修改keyword 的ifException
	 */
	void updateKeywords(int id,int value);
	

	
}
