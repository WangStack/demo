package cn.crawlerTweet.dao;

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
public class DownLoadVideo implements Runnable {

	private String folderPath;
	private String fileName;
	private String url;

	public DownLoadVideo(String folderPath, String fileName, String url) {
		this.folderPath = folderPath;
		this.fileName = fileName;
		this.url = url;
	}

	public void run() {
		downLostVideo();
	}

	/**
	 * 下载视频
	 * 
	 * @param url
	 */
	public void downLostVideo() {
		try {
			if (ShareVar.strDenoising.strIfNull(url)) {
				Connection.Response document = Jsoup.connect(url).ignoreContentType(true).timeout(10000).execute();
				URL url1 = document.url();
				String a = folderPath + "\\" + "视频" + fileName + ".mp4";
				File file = new File(a);
				FileUtils.copyURLToFile(url1, file, 200000, 200000);
			}
		} catch (IOException e) {
			return;
		}
	}
}
