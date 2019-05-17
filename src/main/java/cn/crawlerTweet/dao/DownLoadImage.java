﻿package cn.crawlerTweet.dao;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import cn.crawlerTweet.service.ShareVar;

/**
 * 本类为下载图片
 * 
 * @author 丁丁
 *
 */
public class DownLoadImage implements Runnable {

	private String folderPath;
	private String fileName;
	private String url;

	public DownLoadImage(String folderPath, String fileName, String url) {
		this.folderPath = folderPath;
		this.fileName = fileName;
		this.url = url;
	}

	public void run() {
		downLostImage(url);
	}

	/**
	 * 下载图片
	 * 
	 * @param url
	 */
	public synchronized void downLostImage(String url) {
		try {
			if (ShareVar.strDenoising.strIfNull(url) && url.contains("http") && url.contains("jpg")) {
				Connection.Response document = Jsoup.connect(url).ignoreContentType(true).timeout(10000).execute();
				URL url1 = document.url();
				String a = folderPath + "\\" + "图片" + fileName + ".jpg";
				File file = new File(a);
				FileUtils.copyURLToFile(url1, file, 100000, 100000);
			}
		} catch (IOException e) {
			return;
		}
	}
}
