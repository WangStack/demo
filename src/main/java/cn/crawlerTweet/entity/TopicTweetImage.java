package cn.crawlerTweet.entity;

/**
 * ����΢��ͼƬ��
 * @author ����
 *
 */
public class TopicTweetImage {
	private int id; //����΢��ͼƬid
	private int ttId;  //����΢��id
	private String topicImageUrl; //����΢��ͼƬurl
	private String topicImageName; //����ͼƬ����
	
	
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
