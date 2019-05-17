package cn.crawlerTweet.service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 对webDriver的操作
 * 
 * @author 丁丁
 *
 */
public class DriverOperate {

	/**
	 * WebDriver 登录微博
	 */
	public void registTweet(WebDriver driver, String username, String password) {
		// 把浏览器最大化
		driver.manage().window().maximize();

		ShareVar.sleep(1000);

		// css规则清空
		cssClear(driver, ShareVar.wbs.getClickAccountNumberRule());

		// css规则进行输入
		cssSendKeys(driver, ShareVar.wbs.getClickAccountNumberRule(), username);

		ShareVar.sleep(2000);

		// css规则清空
		cssClear(driver, ShareVar.wbs.getClickPasswordRule());

		// css规则进行输入
		cssSendKeys(driver, ShareVar.wbs.getClickPasswordRule(), password);

		ShareVar.sleep(2000);

		// css规则单击事件
		cssClick(driver, ShareVar.wbs.getClickRegisterRule());

		ShareVar.sleep(5000);
	}

	/**
	 * WebDriver 在搜索框输入关键字进行搜索
	 * 
	 * @param driver
	 * @param bloggerName
	 *            要搜索的关键字
	 */
	public void searchBloggerName(WebDriver driver, String bloggerName) {

		// css规则清空
		cssClear(driver, ShareVar.wbs.getSearchInputRule());

		// css规则输入关键字
		cssSendKeys(driver, ShareVar.wbs.getSearchInputRule(), bloggerName);

		// css规则单击事件
		cssClick(driver, ShareVar.wbs.getClickSearchRule());

		// 睡眠
		ShareVar.sleep(2000);
	}

	/**
	 * WebDriver xpath规则获取多个WebElement
	 * 
	 * @param driver
	 * @param value
	 * @return
	 */
	public List<WebElement> xpathGetElements(WebDriver driver, String Rule) {
		List<WebElement> findElements = null;
		try {
			findElements = driver.findElements(By.xpath(Rule));
			return findElements;
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * WebDriver css获取属性值
	 * 
	 * @param typeRule
	 *            规则
	 * @param typeName
	 *            属性名称
	 */
	public String cssGetTypeVaule(WebDriver driver, String typeRule, String typeName) {
		try {
			String typeValue = driver.findElement(By.cssSelector(typeRule)).getAttribute(typeName);
			return typeValue;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * WebDriver 获取属性里面的多个属性值
	 * 
	 * @param typeRule
	 *            规则
	 * @param typeName
	 *            属性名称
	 * @return
	 */
	public Set<String> xpathGetTypesValue(WebDriver driver, String typeRule, String typeName) {

		Set<String> typeValueSet = new LinkedHashSet<String>();
		List<WebElement> elements = driver.findElements(By.xpath(typeRule));
		if (ShareVar.strDenoising.objIfNull(elements) && elements.size() > 1) {
			for (WebElement element : elements) {
				String value = element.getAttribute(typeName);
				if (value != null && !(value.equals("")))
					typeValueSet.add(value);
			}
			return typeValueSet;
		}
		return null;

	}


	/**
	 * WebDriver css 规则获取文本值
	 * 
	 * @param driver
	 * @param textRule
	 * @return
	 */
	public String cssGetTextValue(WebDriver driver, String textRule) {
		String value;
		try {
			value = driver.findElement(By.cssSelector(textRule)).getText();
		} catch (Exception e) {
			return null;
		}
		return value;
	}

	/**
	 * WebDriver js单次下拉操作
	 */
	public void javaScriptDrop(WebDriver driver, int start, int spacin) {

		JavascriptExecutor jsDriver = (JavascriptExecutor) driver;

		jsDriver.executeScript("window.scrollTo(" + start + "," + spacin + ")");

		ShareVar.sleep(1500);

	}

	/**
	 * WebDriver 拉到页面最底部
	 */
	public void javaScriptDownmost(WebDriver driver) {
		JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
		jsDriver.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		ShareVar.sleep(1000);
	}

	/**
	 * WebDriver 拉到页面指定位置
	 */
	public void javaScriptLocatiom(WebDriver driver, WebElement element) {

		JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
//		try {
//			jsDriver.executeScript("arguments[0].scrollIntoView(false);", element);
//		} catch (Exception e) {
			jsDriver.executeScript("arguments[0].scrollIntoView(true);", element);
//		}
		ShareVar.sleep(1500);
	}

	/**
	 * WebDriver css规则清空
	 * 
	 * @param rule
	 *            规则
	 */
	public void cssClear(WebDriver driver, String cssRule) {
		driver.findElement(By.cssSelector(cssRule)).clear();
	}

	/**
	 * WebDriver css规则输入关键字
	 * 
	 * @param rule
	 *            规则
	 * @param keyword
	 *            关键字
	 */
	public void cssSendKeys(WebDriver driver, String cssRule, String keyword) {
		driver.findElement(By.cssSelector(cssRule)).sendKeys(keyword);
	}

	/**
	 * WebDriver css规则单击事件
	 * 
	 * @param cssRule
	 */
	public void cssClick(WebDriver driver, String cssRule) {
		try {
			driver.findElement(By.cssSelector(cssRule)).click();
			ShareVar.sleep(3000);
		} catch (Exception e) {
			return;
		}
	}

	/**
	 * WebDriver xpath单击事件
	 */
	public void xpathClick(WebDriver driver, String xpathRule) {
		try {
			driver.findElement(By.xpath(xpathRule)).click();
			ShareVar.sleep(3000);
		} catch (Exception e) {
			return;
		}
	}

	/**
	 * WebDriver linkedText 单击事件
	 */
	public void linkTextClick(WebDriver driver, String linkText) {
		try {
			driver.findElement(By.linkText(linkText)).click();
			ShareVar.sleep(3000);
		} catch (Exception e) {
			return;
		}
	}

	/**
	 * WebDriver xpath获取属性值
	 * 
	 * @param typeRule
	 *            规则
	 * @param typeName
	 *            属性名称
	 */
	public String xpathGetTypeValue(WebDriver driver, String typeRule, String typeName) {
		try {
			String typeValue = driver.findElement(By.xpath(typeRule)).getAttribute(typeName);
			return typeValue;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * WebDriver xpath规则获取文本值
	 * 
	 * @return
	 */
	public String xpathGetTextValue(WebDriver driver, String typeRule) {
		try {
			String value = driver.findElement(By.xpath(typeRule)).getText();
			return value;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * element css 规则单击事件
	 */
	public void elementCssClick(WebElement element, String cssRule) {
		element.findElement(By.cssSelector(cssRule)).click();
	}

	/**
	 * element css获取文本值
	 */
	public String elementCssGetTextValue(WebElement element, String cssRule) {

		String value = null;
		try {
			value = element.findElement(By.cssSelector(cssRule)).getText();
		} catch (Exception e) {
			return null;
		}
		return value;
	}


	/**
	 * element css获取多个element
	 */
	public List<WebElement> elementCssGetElements(WebElement element, String cssRule) {

		try {
			List<WebElement> elements = element.findElements(By.cssSelector(cssRule));
			return elements;
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * element 获取属性值
	 * 
	 * @param element
	 * @param cssRule
	 * @param typeName
	 * @return
	 */
	public String elementCssGetTypeValue(WebElement element, String cssRule, String typeName) {
		String value = null;
		try {
			value = element.findElement(By.cssSelector(cssRule)).getAttribute(typeName);
		} catch (Exception e) {
			return null;
		}
		return value;
	}

	/**
	 * WebDriver css 规则获取多个WebElement
	 * 
	 * @param driver
	 * @param cssRule
	 * @return
	 */
	public List<WebElement> cssGetElements(WebDriver driver, String cssRule) {
		try {
			List<WebElement> findElements = driver.findElements(By.cssSelector(cssRule));
			return findElements;
		} catch (Exception e) {
			return null;
		}
	}

}
