package cn.crawlerTweet.entity;

/**
 * 主题微博图片类
 * @author 丁丁
 *
 */
public class TopicTweetImage {
	private int id; //主题微博图片id
	private int ttId;  //主题微博id
	private String topicImageUrl; //主题微博图片url
	private String topicImageName; //主题图片名称
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTtId() {
		return ttId;
	}
	public void setTtId(int ttId) {
		this.ttId = ttId;
	}
	public String getTopicImageUrl() {
		return topicImageUrl;
	}
	public void setTopicImageUrl(String topicImageUrl) {
		this.topicImageUrl = topicImageUrl;
	}
	public String getTopicImageName() {
		return topicImageName;
	}
	public void setTopicImageName(String topicImageName) {
		this.topicImageName = topicImageName;
	}
	
	
	
}
