package cn.crawlerTweet.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.crawlerTweet.entity.Article;
import cn.crawlerTweet.entity.Blogger;
import cn.crawlerTweet.entity.BloggerTweet;
import cn.crawlerTweet.entity.BloggerTweetImage;
import cn.crawlerTweet.entity.Keywords;
import cn.crawlerTweet.entity.Topic;
import cn.crawlerTweet.entity.TopicTweet;
import cn.crawlerTweet.entity.TopicTweetImage;
import cn.crawlerTweet.entity.Video;
import cn.crawlerTweet.entity.WebSite;
import cn.mapper.OperationMysqlMapper;


public class OperationMysql {

	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession;
	private OperationMysqlMapper mysqlMappe;
	// private Jedis jedis = new Jedis("localhost",6380);
	
	public OperationMysql() {
		// ����SqlSessionFactoryBuilder
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		// ����SqlMapConfig.xml�����ļ�
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		// ����SqlsessionFactory
		this.sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
		// ��ȡsqlSession����spring���Ϻ���spring����
		sqlSession = this.sqlSessionFactory.openSession();
		// ��sqlSession�л�ȡMapper�ӿڵĴ������
		mysqlMappe = sqlSession.getMapper(OperationMysqlMapper.class);
	}

	/**
	 * ��ѯWebSite��������й���
	 * 
	 * @return WebSite �������й���
	 */
	public WebSite getWebSite() {
		// ִ�в�ѯ����
		WebSite wbs = mysqlMappe.getWebSite();
		return wbs;
	}

	/**
	 * ��ȡ�ؼ���
	 * 
	 * @return �ؼ��� List ����
	 */
	public List<Keywords> queryKeyWord() {
		List<Keywords> keywords = mysqlMappe.queryKeyWords();
		return keywords;
	}

	
	/**
	 * ��ȡ�����쳣ʱ��Keywords
	 * @return
	 */
	public List<Keywords> getExceptionKeyWords(){
		List<Keywords> keywords = mysqlMappe.getExceptionKeyWords();
		return keywords;
	}
	

	/**
	 * ���벩����Ϣ
	 * 
	 * @param blgggerInfo
	 */
	public  void insertBlogger(Blogger blgggerInfo) {
		mysqlMappe.insertBlogger(blgggerInfo);
		sqlSession.commit();
	}

	
	/**
	 * ���벩������΢��
	 */
	public  void insertBloggerTweet(BloggerTweet bloggerTweet) {
		mysqlMappe.insertBloggerTweet(bloggerTweet);
		sqlSession.commit();
	}
	
	/**
	 * ���벩��������Ϣ��ͼƬ
	 */
	public  void insertBloggerTweetImage(BloggerTweetImage bloggerTweetImageUrl) {
		mysqlMappe.insertBloggerTweetImage(bloggerTweetImageUrl);
		sqlSession.commit();
	}
	
	/**
	 * ����video
	 * @param video
	 */
	public void insertVideo(Video video) {
		mysqlMappe.insertVideo(video);
		sqlSession.commit();
	}
	
	/**
	 * ��������
	 * @param article
	 */
	public void insertArticle(Article article) {
		mysqlMappe.insertArticle(article);
		sqlSession.commit();
	}
	
	/**
	 * ��������
	 */
	public void insertTopic(Topic topic) {
		mysqlMappe.insertTopic(topic);
		sqlSession.commit();
	}
	
	
	
	
	/**
	 * ��������΢��
	 */
	public void insertTopicTweet(TopicTweet topicTweet) {
		mysqlMappe.insertTopicTweet(topicTweet);
		sqlSession.commit();
	}
	
	/**
	 * ��������΢��ͼƬ
	 * @param topicTweetImage
	 */
	public void insertTopicTweetImage(TopicTweetImage topicTweetImage) {
		mysqlMappe.insertTopicTweetImage(topicTweetImage);
		sqlSession.commit();
	}
	
	/**
	 * �ر�mysql������
	 */
	public void closeMySQL() {
		if (sqlSession != null) {
			sqlSession.close();
		}
	}

	public void updateKeywords(int id,int value) {
		mysqlMappe.updateKeywords(id,value);
		sqlSession.commit();
	}
	
//	/**
//	 * ��ȡ Redis ���ݿ����������Url
//	 * 
//	 * @return
//	 */
//	public Jedis setUrlList() {
//		Set<String> hkeys = jedis.hkeys("urls");
//		for (String string : hkeys) {
//			jedis.set(string, "urlList");
//		}
//		return jedis;
//	}
	
//	public void insertUrlList() {
//		
//	}
	
}
