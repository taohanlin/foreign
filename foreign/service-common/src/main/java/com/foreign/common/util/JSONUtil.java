package com.foreign.common.util;

import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * @Description: JSON工具类
 * @author taohanlin
 * @date 2018年6月11日 下午2:15:03
 */
public class JSONUtil {

	public static String toJSONString(Object object) {
		return JSON.toJSONString(object);
	}

	public static String toJSONString(Object object, boolean prettyFormat) {
		return JSON.toJSONString(object, prettyFormat);
	}

	public static <T> T parseObject(String text, Class<T> cls) {
		return JSON.parseObject(text, cls);
	}

	public static <T> List<T> parseListObject(String text, Class<T> cls) {
		return JSON.parseArray(text, cls);
	}

}
