package cn.crawlerTweet.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 下载pdf文件
 * @author 丁丁
 *
 */
public class DownLoadPdf implements Runnable {
	private static String projectPath = System.getProperty("user.dir");
	private static String jsPath = projectPath + File.separator + "\\js\\getpdf.js";
	private static String exePath = projectPath + File.separator + "phantomjs" + File.separator + "bin" + File.separator + "phantomjs.exe";

	private String url;
	private String filepath;

	public DownLoadPdf(String url, String filepath) {
		this.url = url;
		this.filepath = filepath;
	}


	public void run() {
		getHtmlByPhantomjs();
	}

	/**
	 * 通过Phantomjs得到html页面
	 * 
	 * @param url
	 * @return
	 */
	private boolean getHtmlByPhantomjs() {

		try {
			Runtime rt = Runtime.getRuntime();
			Process p = rt.exec(exePath + " " + jsPath + " " + url + " " + filepath);
			return streamToString(p);
		} catch (IOException e) {
			return false;
		}

	}

	private static boolean streamToString(Process p) {
		InputStream is = p.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		StringBuffer sbf = new StringBuffer();
		String tmp = "";
		try {
			while ((tmp = br.readLine()) != null) {
				sbf.append(tmp);
			}
			return true;
		} catch (IOException e) {
			return false;
		}

	}

}
