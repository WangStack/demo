package cn.crawlerTweet.entity;

public class Video {
	
	
	private int id;	//���
	private String videoName; 	  //��Ƶ����
	private String videoImageUrl; //��ƵͼƬ����
	private String videoUrl;	//��Ƶ����
	private String videoPath;	// ��Ƶ�洢λ��
	private String videoTranspondNumber;	// ��Ƶת����
	private String videoCommentNumber;		// ��Ƶ������
	private String videoLikeNumber;		// ��Ƶ������
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVideoName() {
		return videoName;
	}
	
	public String getVideoTranspondNumber() {
		return videoTranspondNumber;
	}
	public void setVideoTranspondNumber(String videoTranspondNumber) {
		this.videoTranspondNumber = videoTranspondNumber;
	}
	public String getVideoCommentNumber() {
		return videoCommentNumber;
	}
	public void setVideoCommentNumber(String videoCommentNumber) {
		this.videoCommentNumber = videoCommentNumber;
	}
	public String getVideoLikeNumber() {
		return videoLikeNumber;
	}
	public void setVideoLikeNumber(String videoLikeNumber) {
		this.videoLikeNumber = videoLikeNumber;
	}
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	public String getVideoImageUrl() {
		return videoImageUrl;
	}
	public void setVideoImageUrl(String videoImageUrl) {
		this.videoImageUrl = videoImageUrl;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public String getVideoPath() {
		return videoPath;
	}
	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}
	
	
}
