package cn.crawlerTweet.entity;

import java.util.LinkedHashSet;
import java.util.Set;


/**
 * ����Ϊ��������΢����Ϣ��
 * @author ����
 *
 */
public class BloggerTweet {

	private int id;
	private int bId; // ����id��bolger���id���Ӧ
	private String tweetTitle;	//΢������
	private String tweetTime;	//΢������ʱ��
	private String tweetVideoUrl;	//��Ƶurl
	private String tweetVideoName;	//��Ƶ����
	private Set<BloggerTweetImage> tweetImageUrl = new LinkedHashSet<BloggerTweetImage>(); // ͼƬurl
	private String transpondNumber;	//΢��ת����
	private String commentNumber;	//΢��������
	private String likeNumber;		//΢��������
	
	private String tweetIVPath;		//΢����ƵͼƬ���λ��
	
	
	
	public String getTweetVideoName() {
		return tweetVideoName;
	}
	public void setTweetVideoName(String tweetVideoName) {
		this.tweetVideoName = tweetVideoName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBId() {
		return bId;
	}
	public void setBId(int bId) {
		this.bId = bId;
	}
	public String getTweetTitle() {
		return tweetTitle;
	}
	public void setTweetTitle(String tweetTitle) {
		this.tweetTitle = tweetTitle;
	}
	public String getTweetTime() {
		return tweetTime;
	}
	public void setTweetTime(String tweetTime) {
		this.tweetTime = tweetTime;
	}
	
	public Set<BloggerTweetImage> getTweetImageUrl() {
		return tweetImageUrl;
	}
	public String getTweetVideoUrl() {
		return tweetVideoUrl;
	}
	public void setTweetVideoUrl(String tweetVideoUrl) {
		this.tweetVideoUrl = tweetVideoUrl;
	}
	public String getTranspondNumber() {
		return transpondNumber;
	}
	public void setTranspondNumber(String transpondNumber) {
		this.transpondNumber = transpondNumber;
	}
	public String getCommentNumber() {
		return commentNumber;
	}
	public void setCommentNumber(String commentNumber) {
		this.commentNumber = commentNumber;
	}
	public String getLikeNumber() {
		return likeNumber;
	}
	public void setLikeNumber(String likeNumber) {
		this.likeNumber = likeNumber;
	}
	public String getTweetIVPath() {
		return tweetIVPath;
	}
	public void setTweetIVPath(String tweetIVPath) {
		this.tweetIVPath = tweetIVPath;
	}
	
	
}
