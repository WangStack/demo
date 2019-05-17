package Test;


import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import cn.crawlerTweet.service.ShareVar;

/**
 * 本类作为下载视频
 * 
 * @author 丁丁
 *
 */
//public class DownLoadVideo implements Runnable {
public class aa {

	private String folderPath;
	private String fileName;
	private String url;

	public aa(String folderPath, String fileName, String url) {
		this.folderPath = folderPath;
		this.fileName = fileName;
		this.url = url;
	}

	/**
	 * 下载视频
	 * 
	 * @param url
	 */
	public void downLostVideo(){
		
		try {

				Connection.Response document = Jsoup.connect(url).ignoreContentType(true).timeout(10000).execute();
				URL url1 = document.url();
				String a = folderPath + "\\" + "视频" + fileName + ".mp3";
				File file = new File(a);
				FileUtils.copyURLToFile(url1, file);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}


	public static void main(String[] args) {	
		aa dv = new aa("D:\\","asdsada","");
	}
}

