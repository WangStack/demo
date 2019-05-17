package cn.crawlerTweet.entity;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 主题信息类
 * @author 丁丁
 *
 */
public class Topic {

	private int id; // 编号
	private String url; // 主题url
	private String topicName; //标题
	private String readNumber; //阅读数
	private String discussNumbaer; // 讨论数
	private String lead; // 导语
	private Set<TopicTweet> topicTweet = new LinkedHashSet<TopicTweet>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public String getReadNumber() {
		return readNumber;
	}
	public void setReadNumber(String readNumber) {
		this.readNumber = readNumber;
	}
	public String getDiscussNumbaer() {
		return discussNumbaer;
	}
	public Set<TopicTweet> getTopicTweetSet() {
		return topicTweet;
	}
	public void setDiscussNumbaer(String discussNumbaer) {
		this.discussNumbaer = discussNumbaer;
	}
	public String getLead() {
		return lead;
	}
	public void setLead(String lead) {
		this.lead = lead;
	}

	
	
}
