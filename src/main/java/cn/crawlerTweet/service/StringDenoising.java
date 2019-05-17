package cn.crawlerTweet.service;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringDenoising {

	/**
	 * �ж�һ��ʵ���Ƿ�Ϊ��
	 */
	public boolean objIfNull(Object ob) {
		return ob == null ? false : true;
	}

	/**
	 * �ж�һ���ַ����Ƿ�Ϊ�պ�""
	 * 
	 * @param str
	 * @return
	 */
	public boolean strIfNull(String str) {
		return str != null && !(str.equals("")) ? true : false;
	}

	/**
	 * ȥ���ַ�����һЩ�Ƿ��ַ�
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
	 * ƥ���ַ���
	 * 
	 * @param str
	 * @return
	 */
	private String strMatching(String str) {
		// ������ĸ�����»���֮����ַ�Ϊ�Ƿ��ַ�
		Pattern pattern = Pattern.compile("[^a-zA-Z0-9\\_\u4e00-\u9fa5\\__\\pP]");
		// ָ�����÷Ƿ��ַ�
		// Pattern pattern = Pattern.compile("[@#]");
		Matcher matcher = pattern.matcher(str);
		StringBuffer buffer = new StringBuffer();
		// ����ҵ��Ƿ��ַ�
		while (matcher.find()) {
			// �����������Ƿ��ַ���ð��˫���ŵȣ���ô�Ͱ�������ȥ�����ѷǷ��ַ�ǰ����ַ��ŵ�������
			matcher.appendReplacement(buffer, "");
		}
		// ��ʣ��ĺϷ�������ӵ�������
		matcher.appendTail(buffer);

		return buffer.toString();
	}

	/**
	 * �ַ������ƶȱȽ� DNA���� ƴ�ּ�� ������ʶ ��Ϯ���
	 * 
	 * @createTime 2012-1-12
	 */
	public float levenshtein(String str1, String str2) {
		// ���������ַ����ĳ��ȡ�
		int len1 = str1.length();
		int len2 = str2.length();
		// ��������˵�����飬���ַ����ȴ�һ���ռ�
		int[][] dif = new int[len1 + 1][len2 + 1];
		// ����ֵ������B��
		for (int a = 0; a <= len1; a++) {
			dif[a][0] = a;
		}
		for (int a = 0; a <= len2; a++) {
			dif[0][a] = a;
		}
		// ���������ַ��Ƿ�һ�����������ϵ�ֵ
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
				// ȡ����ֵ����С��
				dif[i][j] = min(dif[i - 1][j - 1] + temp, dif[i][j - 1] + 1, dif[i - 1][j] + 1);
			}
		}
		// System.out.println("�ַ���\"" + str1 + "\"��\"" + str2 + "\"�ıȽ�");
		// ȡ�������½ǵ�ֵ��ͬ����ͬλ�ô���ͬ�ַ����ıȽ�
		// System.out.println("���첽�裺" + dif[len1][len2]);
		// �������ƶ�
		float similarity = 1 - (float) dif[len1][len2] / Math.max(str1.length(), str2.length());
		return similarity;
	}

	// �õ���Сֵ
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
	 * �� url ����ƽ������
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
