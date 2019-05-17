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
 * �����ṩһЩ���ñ����͹�������
 * 
 * @author ����
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

	// �ַ�������
	public static StringDenoising strDenoising = new StringDenoising();

	// ����MySQL���ݿ�
	public static OperationMysql opMysql = new OperationMysql();

	// ����Mongodb���ݿ�
	public static OperationMongodb opMongoDB = new OperationMongodb();

	public static Set<Blogger> bloggerSet = new LinkedHashSet<Blogger>();// ������Ϣ����
	private static int bloggerId = 1; // ����id
	public synchronized static int getBloggerId() {
		int id = bloggerId;
		++bloggerId;
		return id;
	}

	
	private static int bloggetTweetId = 1; // ����΢��id
	public synchronized static int getBloggetTweetId() {
		int id = bloggetTweetId;
		++bloggetTweetId;
		return id;
	}
	

	// ��Ƶ����
	public static Set<Video> videoSet = new LinkedHashSet<Video>();
	private static int videoId = 1; // ��Ƶid
	public synchronized static int getVideoId() {
		int id = videoId;
		++videoId;
		return id;
	}
	

	public static Set<BloggerTweetImage> imageSet = new LinkedHashSet<BloggerTweetImage>(); // ͼƬ����
	private static int imageId = 1; // ͼƬid
	public synchronized static int getImageId() {
		int id = imageId;
		++imageId;
		return id;
	}
	

	// ���¼���
	public static Set<String> articleSet = new LinkedHashSet<String>();
	private static int articleId = 1; // ����Id

	public synchronized static int getArticleId() {
		int id = articleId;
		++articleId;
		return id;
	}

	// ���⼯��
	public static Set<Topic> topicSet = new LinkedHashSet<Topic>();
	private static int topicId = 1; // ����id

	public synchronized static int getTopicId() { // ��ȡ����id
		int tId = topicId;
		++topicId;
		return tId;
	}

	private static int topicTweetId = 1; // ����΢��id

	public static synchronized int getTopicTweetId() { //��ȡ����΢��Id
		int ttid = topicTweetId;
		++topicTweetId;
		return ttid;
	}

	private static int topicTweetImageId = 1; // ����΢��ͼƬid

	public synchronized static int getTopicTweetImageId() { // ��ȡ����΢��ͼƬid
		int ttiId = topicTweetImageId;
		++topicTweetImageId;

		return ttiId;
	}

	// ����
	public static WebSite wbs = opMysql.getWebSite(); // ��ȡ����

	/**
	 * ����
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
		//  ���������������λ�ã�����Ҫ����Ȼ�򿪵Ļ������ǿհ�ҳ
		 driverValue = System.getProperty("user.dir");
		 driverValue += "\\driver\\chromedriver.exe";

	}

	/**
	 * ��ȡ�û���Ϣ
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
	 * ���߳�˯��
	 * 
	 * @param time
	 *            ��Ҫ˯�ߵ�ʱ��
	 */
	public static void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ����һ�������
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

			// ����ϵͳ����,������iedriver��·��Ϊϵͳ����ֵ
			System.setProperty("webdriver.ie.driver", "driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			
		} else {

			// ָ��MicrosoftWebDriver·��
			System.setProperty("webdriver.edge.driver", "driver\\MicrosoftWebDriver.exe");
			// ʵ���� InternetExplorerDriver
			driver = new EdgeDriver();

		}

		return driver;
	}

	public static void main(String[] args) {
		toLoadbrowser("ie");
	}
}
