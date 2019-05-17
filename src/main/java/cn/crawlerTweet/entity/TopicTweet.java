package cn.crawlerTweet.entity;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 主题微博类
 * @author 丁丁
 *
 */
public class TopicTweet {

	private int id;  //主题微博id
	private int tId; //主题信息id
	private String topictweetBlogger; // 主题微博博主
	private String topictweetTitle; // 主题微博标题
	private String topicTweetTime;	//主题微博发出时间
	private String topicTweetVideoUrl;	//主题视频url
	private String topicTweetVideoName;	//主题视频名称
	private Set<TopicTweetImage> topicTweetImageUrl = new LinkedHashSet<TopicTweetImage>(); // 主题图片url
	private String topicTranspondNumber;	//主题微博转发数
	private String topicCommentNumber;	//主题微博评论数
	private String topicLikeNumber;		//主题微博点赞数
	
	private String topicTweetIVPath;		//主题微博视频图片存放位置

	
	
	
	public int getId() {
		return id;
	}

	public String getTopictweetBlogger() {
		return topictweetBlogger;
	}

	public void setTopictweetBlogger(String topictweetBlogger) {
		this.topictweetBlogger = topictweetBlogger;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public String getTopictweetTitle() {
		return topictweetTitle;
	}

	public void setTopictweetTitle(String topictweetTitle) {
		this.topictweetTitle = topictweetTitle;
	}

	public String getTopicTweetTime() {
		return topicTweetTime;
	}

	public void setTopicTweetTime(String topicTweetTime) {
		this.topicTweetTime = topicTweetTime;
	}

	public String getTopicTweetVideoUrl() {
		return topicTweetVideoUrl;
	}

	public void setTopicTweetVideoUrl(String topicTweetVideoUrl) {
		this.topicTweetVideoUrl = topicTweetVideoUrl;
	}

	public String getTopicTweetVideoName() {
		return topicTweetVideoName;
	}

	public void setTopicTweetVideoName(String topicTweetVideoName) {
		this.topicTweetVideoName = topicTweetVideoName;
	}

	public Set<TopicTweetImage> getTopicTweetImageUrl() {
		return topicTweetImageUrl;
	}


	public String getTopicTranspondNumber() {
		return topicTranspondNumber;
	}

	public void setTopicTranspondNumber(String topicTranspondNumber) {
		this.topicTranspondNumber = topicTranspondNumber;
	}

	public String getTopicCommentNumber() {
		return topicCommentNumber;
	}

	public void setTopicCommentNumber(String topicCommentNumber) {
		this.topicCommentNumber = topicCommentNumber;
	}

	public String getTopicLikeNumber() {
		return topicLikeNumber;
	}

	public void setTopicLikeNumber(String topicLikeNumber) {
		this.topicLikeNumber = topicLikeNumber;
	}

	public String getTopicTweetIVPath() {
		return topicTweetIVPath;
	}

	public void setTopicTweetIVPath(String topicTweetIVPath) {
		this.topicTweetIVPath = topicTweetIVPath;
	}

		
	
}
