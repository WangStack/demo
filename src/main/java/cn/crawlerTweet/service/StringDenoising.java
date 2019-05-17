package cn.crawlerTweet.service;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringDenoising {

	/**
	 * 判断一个实例是否为空
	 */
	public boolean objIfNull(Object ob) {
		return ob == null ? false : true;
	}

	/**
	 * 判断一个字符串是否为空和""
	 * 
	 * @param str
	 * @return
	 */
	public boolean strIfNull(String str) {
		return str != null && !(str.equals("")) ? true : false;
	}

	/**
	 * 去除字符串的一些非法字符
	 */
	public String strIllegalCharacter(String str) {
		str = strMatching(str);
		try {
			str = str.replaceAll("/", "");
		} catch (Exception e) {
		}
		try {
			str = str.replaceAll("#", "");
		} catch (Exception e) {

		}
		try {
			str = str.replaceAll("\\", "");
		} catch (Exception e) {
		}
		try {
			str = str.replaceAll(":", "");
		} catch (Exception e) {
		}
		try {
			str = str.replaceAll("\"", "");
		} catch (Exception e) {
		}
		try {
			str = str.replaceAll("|", "");
		} catch (Exception e) {
		}
		try {
			str = str.replaceAll("*", "");
		} catch (Exception e) {
		}
		try {
			str = str.replaceAll("<", "");
		} catch (Exception e) {
		}
		try {
			str = str.replaceAll("<", "");
		} catch (Exception e) {
		}
		try {
			str = str.replaceAll(">", "");
		} catch (Exception e) {
		}
		try {
			str = str.replaceAll("'", "");
		} catch (Exception e) {
		}
		try {
			str = str.replaceAll("\r\n", "");
		} catch (Exception e) {
		}
		try {
			str = str.replace("\n", "");
		} catch (Exception e) {

		}
		return str;
	}

	/**
	 * 匹配字符串
	 * 
	 * @param str
	 * @return
	 */
	private String strMatching(String str) {
		// 除了字母数字下划线之外的字符为非法字符
		Pattern pattern = Pattern.compile("[^a-zA-Z0-9\\_\u4e00-\u9fa5\\__\\pP]");
		// 指定设置非法字符
		// Pattern pattern = Pattern.compile("[@#]");
		Matcher matcher = pattern.matcher(str);
		StringBuffer buffer = new StringBuffer();
		// 如果找到非法字符
		while (matcher.find()) {
			// 如果里面包含非法字符如冒号双引号等，那么就把他们消去，并把非法字符前面的字符放到缓冲区
			matcher.appendReplacement(buffer, "");
		}
		// 将剩余的合法部分添加到缓冲区
		matcher.appendTail(buffer);

		return buffer.toString();
	}

	/**
	 * 字符串相似度比较 DNA分析 拼字检查 语音辨识 抄袭侦测
	 * 
	 * @createTime 2012-1-12
	 */
	public float levenshtein(String str1, String str2) {
		// 计算两个字符串的长度。
		int len1 = str1.length();
		int len2 = str2.length();
		// 建立上面说的数组，比字符长度大一个空间
		int[][] dif = new int[len1 + 1][len2 + 1];
		// 赋初值，步骤B。
		for (int a = 0; a <= len1; a++) {
			dif[a][0] = a;
		}
		for (int a = 0; a <= len2; a++) {
			dif[0][a] = a;
		}
		// 计算两个字符是否一样，计算左上的值
		int temp;
		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				char a = str1.charAt(i - 1);
				char b = str2.charAt(j - 1);
				if (a == b) {
					temp = 0;
				} else {
					temp = 1;
				}
				// 取三个值中最小的
				dif[i][j] = min(dif[i - 1][j - 1] + temp, dif[i][j - 1] + 1, dif[i - 1][j] + 1);
			}
		}
		// System.out.println("字符串\"" + str1 + "\"与\"" + str2 + "\"的比较");
		// 取数组右下角的值，同样不同位置代表不同字符串的比较
		// System.out.println("差异步骤：" + dif[len1][len2]);
		// 计算相似度
		float similarity = 1 - (float) dif[len1][len2] / Math.max(str1.length(), str2.length());
		return similarity;
	}

	// 得到最小值
	private static int min(int... is) {
		int min = Integer.MAX_VALUE;
		for (int i : is) {
			if (min > i) {
				min = i;
			}
		}
		return min;
	}

	/**
	 * 把 url 进行平均分配
	 * @param thread1
	 * @param thread2
	 * @param thread3
	 * @param urlSet
	 */
	public void meanUrlSet(Set<String> thread1, Set<String> thread2, Set<String> thread3, Set<String> urlSet) {

		for (String url : urlSet) {
			if (url.hashCode() % 3 == -1) {
				thread1.add(url);
			} else if (url.hashCode() % 3 == 0) {
				thread2.add(url);
			} else
				thread3.add(url);
		}
	}
}
