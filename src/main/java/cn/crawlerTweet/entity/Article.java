package cn.crawlerTweet.entity;

public class Article {

	private int id;
	private String url;
	private String title;  //标题
	private String blogger;//博主
	private String author; //作者
	private String time;   //时间
	private String sourceUrl; //源网址
	private String readNumber;//阅读数
	private String content;	//内容
	private String pdfName; //pdf文件名称
	private String pdfFilePath; //pdf文件保存位置
		
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPdfFilePath() {
		return pdfFilePath;
	}
	public void setPdfFilePath(String pdfFilePath) {
		this.pdfFilePath = pdfFilePath;
	}
	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public String getBlogger() {
		return blogger;
	}
	public void setBlogger(String blogger) {
		this.blogger = blogger;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getSourceUrl() {
		return sourceUrl;
	}
	public void setArticleSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}
	public String getReadNumber() {
		return readNumber;
	}
	public void setReadNumber(String readNumber) {
		this.readNumber = readNumber;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPdfName() {
		return pdfName;
	}
	public void setPdfName(String pdfName) {
		this.pdfName = pdfName;
	}

	
}
