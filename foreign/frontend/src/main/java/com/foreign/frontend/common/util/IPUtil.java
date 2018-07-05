package com.foreign.frontend.common.util;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 获取请求主机IP地址
 * @author taohanlin
 * @date 2018年6月11日 下午2:29:02
 */
public class IPUtil {

	public final static String getIpAddress(HttpServletRequest request) {

		String ip = null;

		Enumeration<String> enumeration = request.getHeaders("X-Forwarded-For");

		while (enumeration.hasMoreElements()) {
			ip = enumeration.nextElement();
		}

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			return request.getRemoteAddr();

		} else if (ip.contains(",")) {

			String[] ips = ip.split(",");

			for (int index = 0; index < ips.length; index++) {
				String strIp = (String) ips[index].trim();
				if (!("unknown".equalsIgnoreCase(strIp))) {
					ip = strIp;
				}
			}
		}
		return ip;

	}
}
