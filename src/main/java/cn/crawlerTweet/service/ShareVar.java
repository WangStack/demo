package cn.crawlerTweet.service;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import cn.crawlerTweet.dao.OperationMongodb;
import cn.crawlerTweet.dao.OperationMysql;
import cn.crawlerTweet.entity.Blogger;
import cn.crawlerTweet.entity.BloggerTweetImage;
import cn.crawlerTweet.entity.Topic;
import cn.crawlerTweet.entity.Video;
import cn.crawlerTweet.entity.WebSite;
import sun.misc.BASE64Decoder;

/**
 * 本类提供一些公用变量和公共方法
 * 
 * @author 丁丁
 *
 */
public class ShareVar {

	static {
		readUserInfo();
		readDriverInfo();
	}

	public static String username;
	public static String password;
	private static final String CHROME = "Chrome";
	private static final String FIRFOX = "Firefox";
	private static final String IE = "IE";
	private static final String DRIVERKEY = "webdriver.chrome.driver";
	private static String driverValue;

	// 字符操作类
	public static StringDenoising strDenoising = new StringDenoising();

	// 操作MySQL数据库
	public static OperationMysql opMysql = new OperationMysql();

	// 操作Mongodb数据库
	public static OperationMongodb opMongoDB = new OperationMongodb();

	public static Set<Blogger> bloggerSet = new LinkedHashSet<Blogger>();// 博主信息集合
	private static int bloggerId = 1; // 博主id
	public synchronized static int getBloggerId() {
		int id = bloggerId;
		++bloggerId;
		return id;
	}

	
	private static int bloggetTweetId = 1; // 博主微博id
	public synchronized static int getBloggetTweetId() {
		int id = bloggetTweetId;
		++bloggetTweetId;
		return id;
	}
	

	// 视频集合
	public static Set<Video> videoSet = new LinkedHashSet<Video>();
	private static int videoId = 1; // 视频id
	public synchronized static int getVideoId() {
		int id = videoId;
		++videoId;
		return id;
	}
	

	public static Set<BloggerTweetImage> imageSet = new LinkedHashSet<BloggerTweetImage>(); // 图片集合
	private static int imageId = 1; // 图片id
	public synchronized static int getImageId() {
		int id = imageId;
		++imageId;
		return id;
	}
	

	// 文章集合
	public static Set<String> articleSet = new LinkedHashSet<String>();
	private static int articleId = 1; // 文章Id

	public synchronized static int getArticleId() {
		int id = articleId;
		++articleId;
		return id;
	}

	// 话题集合
	public static Set<Topic> topicSet = new LinkedHashSet<Topic>();
	private static int topicId = 1; // 话题id

	public synchronized static int getTopicId() { // 获取话题id
		int tId = topicId;
		++topicId;
		return tId;
	}

	private static int topicTweetId = 1; // 话题微博id

	public static synchronized int getTopicTweetId() { //获取话题微博Id
		int ttid = topicTweetId;
		++topicTweetId;
		return ttid;
	}

	private static int topicTweetImageId = 1; // 话题微博图片id

	public synchronized static int getTopicTweetImageId() { // 获取话题微博图片id
		int ttiId = topicTweetImageId;
		++topicTweetImageId;

		return ttiId;
	}

	// 规则
	public static WebSite wbs = opMysql.getWebSite(); // 获取规则

	/**
	 * 解码
	 * 
	 * @param str
	 * @return string
	 */
	public static String decode(String str) {
		byte[] bt = null;
		try {
			BASE64Decoder decoder = new BASE64Decoder();
			bt = decoder.decodeBuffer(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new String(bt);
	}

	private static void readDriverInfo() {
		//  设置浏览器驱动的位置，很重要，不然打开的话可能是空白页
		 driverValue = System.getProperty("user.dir");
		 driverValue += "\\driver\\chromedriver.exe";

	}

	/**
	 * 读取用户信息
	 * 
	 * @throws ParserConfigurationException
	 */
	private static void readUserInfo() {
		DocumentBuilderFactory bdf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try {
			db = bdf.newDocumentBuilder();
			Document document = db.parse(new File("user.xml"));
			NodeList list = document.getElementsByTagName("user1");

			for (int i = 0; i < list.getLength(); i++) {
				Element element = (Element) list.item(i);
				username = element.getElementsByTagName("username").item(0).getFirstChild().getNodeValue();
				password = element.getElementsByTagName("password").item(0).getFirstChild().getNodeValue();
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 让线程睡眠
	 * 
	 * @param time
	 *            需要睡眠的时间
	 */
	public static void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 加载一个浏览器
	 * 
	 * @param browserName
	 * @return
	 */
	public static WebDriver toLoadbrowser(String browserName) {

		// System.setProperty(DRIVERKEY, driverValue);

		WebDriver driver = null;

		if (CHROME.equalsIgnoreCase(browserName) || ShareVar.strDenoising.levenshtein(CHROME, browserName) > 0.5) {
		//	System.setProperty(DRIVERKEY, driverValue);
			System.setProperty(DRIVERKEY, "driver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (FIRFOX.equalsIgnoreCase(browserName) || ShareVar.strDenoising.levenshtein(FIRFOX, browserName) > 0.5) {
			System.setProperty("webdriver.firefox.bin", "E:\\huoHu\\firefox.exe");
			System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		} else if (IE.equalsIgnoreCase(browserName) || ShareVar.strDenoising.levenshtein(IE, browserName) > 0.5) {

			// 设置系统变量,并设置iedriver的路径为系统属性值
			System.setProperty("webdriver.ie.driver", "driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			
		} else {

			// 指定MicrosoftWebDriver路径
			System.setProperty("webdriver.edge.driver", "driver\\MicrosoftWebDriver.exe");
			// 实例化 InternetExplorerDriver
			driver = new EdgeDriver();

		}

		return driver;
	}

	public static void main(String[] args) {
		toLoadbrowser("ie");
	}
}
