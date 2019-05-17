package Test;

import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.xml.dtm.ref.DTMNodeList;
import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.DomSerializer;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 * weibo.cn
 */
public class SinaWeibo {

	private static CloseableHttpClient httpClient=HttpClients.createDefault();
	public static String url = "https://weibo.cn/search/mblog?hideSearchFrame=&keyword=%E5%AD%99%E4%BF%AA&page=2";
	//public static String cookie="MLOGIN=1; SUB=_2A252JATNDeRhGeBM7lUW8y7EyzSIHXVV5qyFrDV6PUJbkdAKLUndkW1NRMmXEJhqmjQxL-91zDRNvIoEzJv8zL8-; SCF=AkynbTbon9p_GePznZmup90EO4wmFccQZpTMqTbDT5Se0rlpmSX1aNaLRX6AbVzL7eJZn1Pvgwo4uzP4LbR7Y8A.; SUHB=0V5V_aFKbOr0Lf; M_WEIBOCN_PARAMS=uicode%3D20000174%26featurecode%3D20000320%26fid%3Dhotword; SSOLoginState=1528853661; _T_WM=0558bd8a4092a65540dd71602751f916;";
	public static String cookie="SINAGLOBAL=6824698979800.343.1528857146512; ALF=1532482043; SUB=_2A252NDSrDeRhGeBM7lUW8y7EyzSIHXVV11zjrDV8PUJbkNAKLUfjkW1NRMmXEItqX9R-9DgmSbuTxWjnTH3y1G4Q; SUBP=0033WrSXqPxfM725Ws9jqgMF55529P9D9W5Cfn-Lb7d3s5_5DH7L7TYV5JpX5oz75NHD95Qceo-NS0e71h5RWs4DqcjidGS_S0-71h2X; WBStorage=5548c0baa42e6f3d|undefined; _s_tentry=-; Apache=2618970729610.137.1529890207125; ULV=1529890207134:3:3:1:2618970729610.137.1529890207125:15288574617986";  
	 // public static String cookie="WBSSL=usrmdinst_14; WBStorage=5548c0baa42e6f3d|undefined; _s_tentry=s.weibo.com; Apache=6824698979800.343.1528857146512; SINAGLOBAL=6824698979800.343.1528857146512; ULV=1528857146525:1:1:1:6824698979800.343.1528857146512:";
	public static void main(String[] args) {
		SinaWeibo weibo=new SinaWeibo();
		weibo.run();
		//weibo.runByXpath();//xpath解析
	}
	  
	public void run(){
		String html = HttpUtils.getRequest(httpClient, url, cookie);
		Document document = Jsoup.parse(html);
		String blockCSSQuery ="div.c";
		Elements blockElements = document.select(blockCSSQuery);
		for(Element element : blockElements){
			String author = element.select("div a.nk").text();
			String content = element.select("div span.ctt").text();
			String ct = element.select("div span.ct").text();
			if(author!=null && !"".equals(author)){
				System.out.println("作者："+author);
				System.out.println("内容："+content);
				System.out.println("来源及时间："+ct);
			}
			
		}
		//System.out.println(content);
		
	}
	
	////http://www.jb51.net/article/48374.htm
	public void runByXpath() {
		 String htmlPage = HttpUtils.getRequest(httpClient, url, cookie);
		 try {
			HtmlCleaner hcCleaner = new HtmlCleaner();  
			 TagNode tagNode = hcCleaner.clean(htmlPage);  
			 org.w3c.dom.Document dom = new DomSerializer(new CleanerProperties()).createDOM(tagNode);  
			 XPath xPath = XPathFactory.newInstance().newXPath();  
			 NodeList  blockList = (NodeList) xPath.evaluate("//div[@class=\"c\"]/div", dom, XPathConstants.NODESET);
			  for (int i = 0; i < blockList.getLength(); i++) {
				   Node node = blockList.item(i);
				   System.out.println("作者："+xPath.evaluate("a[@class=\"nk\"]", node,XPathConstants.STRING));
				   System.out.println("内容："+xPath.evaluate("span[@class=\"ctt\"]", node,XPathConstants.STRING));
				   System.out.println("时间和来源："+xPath.evaluate("span[@class=\"ct\"]", node,XPathConstants.STRING));
			  }
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
         
		
	}
	
	
}
