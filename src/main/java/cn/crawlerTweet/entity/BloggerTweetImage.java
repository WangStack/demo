package cn.crawlerTweet.entity;


/**
 * ��������΢����ͼƬurl��
 * @author ����
 *
 */
public class BloggerTweetImage {

	private int id;
	private int btId; 
	private String imageUrl;
	private String imageName;
	
	
	public int getBtId() {
		return btId;
	}
	public void setBtid(int tId) {
		this.btId = tId;
	}
	
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
