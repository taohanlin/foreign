package com.foreign.common.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: map构建工具类
 * @author taohanlin
 * @date 2018年4月19日 下午4:41:46
 */
public class MapUtils {

	public static Map<Object, Object> build(Object... keyValues) {
		Map<Object, Object> resultMap = new HashMap<Object, Object>();
		for (int i = 0; i < keyValues.length; i += 2) {
			resultMap.put(keyValues[i], keyValues[i + 1]);
		}
		return resultMap;
	}

	public static Map<String, String> build(String... keyValues) {
		Map<String, String> resultMap = new HashMap<String, String>();
		for (int i = 0; i < keyValues.length; i += 2) {
			resultMap.put(keyValues[i], keyValues[i + 1]);
		}
		return resultMap;
	}

	public static void build(Map<String, String> resultMap, String... keyValues) {
		for (int i = 0; i < keyValues.length; i += 2) {
			resultMap.put(keyValues[i], keyValues[i + 1]);
		}
	}

	public static void build(Map<Object, Object> resultMap, Object... keyValues) {
		for (int i = 0; i < keyValues.length; i += 2) {
			resultMap.put(keyValues[i], keyValues[i + 1]);
		}
	}
}
