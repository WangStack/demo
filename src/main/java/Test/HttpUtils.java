package Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

public class HttpUtils {

	// get
	public static String getRequest(CloseableHttpClient httpClient, String url, String cookie) {
		String body = null;
		CloseableHttpResponse httpResponse = null;
		// try {

		RequestBuilder requestBuilder = RequestBuilder.get().setUri(url);
		requestBuilder.addHeader("Cookie", cookie);
		HttpUriRequest httpUriRequest = requestBuilder.build();
		try {
			try {

				httpResponse = httpClient.execute(httpUriRequest);

				HttpEntity entity = httpResponse.getEntity();
				// 服务端返回的状态码
				int statusCode = httpResponse.getStatusLine().getStatusCode();
				System.out.println(statusCode);
				if (entity != null) {
					body = EntityUtils.toString(entity);
					System.out.println(body);
				}
			} finally {
				if (httpResponse != null) {
					// ensure the connection is released back to pool
					EntityUtils.consume(httpResponse.getEntity());
					httpResponse.close();
				}
			}

		} catch (ParseException | IOException e) {
			e.printStackTrace();
		}
		return body;
	}

	// post
	public static String postRequest(CloseableHttpClient httpClient, String url, List<NameValuePair> parms) {
		String content = "";
		HttpPost post = new HttpPost(url);
		RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(10000).setConnectTimeout(10000)
				.setSocketTimeout(10000).build();
		CloseableHttpResponse response = null;

		try {
			post.setEntity(new UrlEncodedFormEntity(parms, "UTF-8"));
			try {
				post.setConfig(config);
				response = httpClient.execute(post);
				HttpEntity entity = response.getEntity();
				content = EntityUtils.toString(entity);
				System.out.println("content:" + content);
				EntityUtils.consume(entity);
			} finally {
				response.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return content;
	}

}
