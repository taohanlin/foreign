package com.foreign.common.util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description: String 工具类
 * @author taohanlin
 * @date 2018年6月11日 下午1:50:10
 */
public class StringUtil {

	public static boolean isEmpty(String str) {
		return (str == null || str.trim().equals(""));
	}

	public static boolean isValidPhone(String phone) {
		if (!isEmpty(phone)) {
			Pattern pattern = Pattern.compile("^((1[0-9]))\\d{9}$");
			Matcher matcher = pattern.matcher(phone);
			return matcher.find();
		}
		return false;
	}

	public static boolean isValidEmail(String email) {
		if (!isEmpty(email)) {
			Pattern pattern = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
			Matcher matcher = pattern.matcher(email);
			return matcher.find();
		}
		return false;
	}

	public static String join(List<?> strList, String separator) {
		if (strList == null || strList.isEmpty()) {
			return null;
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < strList.size(); i++) {
			if (i == strList.size() - 1) {
				sb.append(strList.get(i));
			} else {
				sb.append(strList.get(i)).append(separator);
			}
		}
		return sb.toString();
	}

	public static List<String> split(String str, String separator) {
		if (isEmpty(str)) {
			return null;
		}
		String[] parts = str.split(separator);
		return Arrays.asList(parts);
	}

	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}
}
