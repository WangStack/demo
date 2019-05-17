package cn.crawlerTweet.entity;

public class Keywords {

	private int id;	// 编号
	private String keyword; //关键字
	private int serchWhere;	//根据什么条件查找
	private int state; //采集状态
	
	private int ifException; //运行时是否异常 为 1 时表示运行异常
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getSerchWhere() {
		return serchWhere;
	}
	public void setSerchWhere(int serchWhere) {
		this.serchWhere = serchWhere;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getIfException() {
		return ifException;
	}
	public void setIfException(int ifException) {
		this.ifException = ifException;
	}
	
	
}
