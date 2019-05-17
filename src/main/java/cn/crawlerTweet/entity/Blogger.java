package cn.crawlerTweet.entity;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * ������Ϣ��
 * 
 * @author ����
 *
 */
public class Blogger {

	private int id;
	private String bloggerUrl;	// ��������
	private String bloggerName; //��������
	private String bloggerJob;	//����ְҵ
	private String attentionNumber;//������ע��
	private String fansNumber;	//������˿��
	private String tweetNumber;	//����΢������
	private Set<BloggerTweet> blogerTweetSet = new LinkedHashSet<>(); //����΢��
	
	
	public Set<BloggerTweet> getBlogerTweetSet() {
		return blogerTweetSet;
	}

	public int getId() {
		return id;
	}
	public String getBloggerUrl() {
		return bloggerUrl;
	}

	public void setBloggerUrl(String bloggerUrl) {
		this.bloggerUrl = bloggerUrl;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getBloggerName() {
		return bloggerName;
	}
	public void setBloggerName(String bloggerName) {
		this.bloggerName = bloggerName;
	}
	public String getBloggerJob() {
		return bloggerJob;
	}
	public void setBloggerJob(String bloggerJob) {
		this.bloggerJob = bloggerJob;
	}
	public String getAttentionNumber() {
		return attentionNumber;
	}
	public void setAttentionNumber(String attentionNumber) {
		this.attentionNumber = attentionNumber;
	}
	public String getFansNumber() {
		return fansNumber;
	}
	public void setFansNumber(String fansNumber) {
		this.fansNumber = fansNumber;
	}
	public String getTweetNumber() {
		return tweetNumber;
	}
	public void setTweetNumber(String tweetNumber) {
		this.tweetNumber = tweetNumber;
	}

	
}
