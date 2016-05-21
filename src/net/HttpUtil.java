package net;

import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;

/**
 * 
 * @author Leo
 * @date 2016年3月26日下午6:29:04
 * @description 常用get,post请求封装
 * @usage
 */
public class HttpUtil {
	public static Content get(String url) {
		Content content = null;
		try {
			content = Request.Get(url).execute().returnContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return content;
	}

	/**
	 * 
	 * @param url
	 * @param params
	 *            The imp of NameValuePair: BasicNameValuePair
	 * @return
	 */
	public static Content post(String url, List<NameValuePair> params) {
		Content content = null;
		try {
			content = Request.Post(url).bodyForm(params).execute()
					.returnContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return content;
	}
}
