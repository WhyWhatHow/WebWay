package learn.util;

import javax.servlet.http.Cookie;

import jdk.dynalink.beans.StaticClass;

public class CookieUtils {

	/**
	 * @Description: 通过姓名查找cookie，并返回cookie
	 * @param cookies
	 * @param name
	 * @return：cookie
	 * @version: v1.0.0
	 * @author: WhyWhatHow
	 * @date: 2018年10月23日 Modification History: Date Author Version Description
	 *        ---------------------------------------------------------* 2018年10月23日
	 *        John Nash v1.0.0 修改原因
	 */
	public static Cookie findCookieByName(Cookie[] cookies, String name) {
		for (Cookie cookie : cookies) {
			if (name.equals(cookie.getName())) {
				return cookie;
			}
		}
		return null;

	}
}
