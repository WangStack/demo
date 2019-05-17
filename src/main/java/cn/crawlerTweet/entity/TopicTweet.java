package cn.crawlerTweet.entity;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * ����΢����
 * @author ����
 *
 */
public class TopicTweet {

	private int id;  //����΢��id
	private int tId; //������Ϣid
	private String topictweetBlogger; // ����΢������
	private String topictweetTitle; // ����΢������
	private String topicTweetTime;	//����΢������ʱ��
	private String topicTweetVideoUrl;	//������Ƶurl
	private String topicTweetVideoName;	//������Ƶ����
	private Set<TopicTweetImage> topicTweetImageUrl = new LinkedHashSet<TopicTweetImage>(); // ����ͼƬurl
	private String topicTranspondNumber;	//����΢��ת����
	private String topicCommentNumber;	//����΢��������
	private String topicLikeNumber;		//����΢��������
	
	private String topicTweetIVPath;		//����΢����ƵͼƬ���λ��

	
	
	
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
