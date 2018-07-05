package com.foreign.common.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description: List工具类
 * @author taohanlin
 * @date 2018年6月21日 下午5:43:34
 */
public class ListUtil {
	@SuppressWarnings("unchecked")
	public static <K, V> List<K> keyList(List<V> inputList, String keyProp) {
		List<K> result = new ArrayList<K>();
		try {
			if (inputList != null) {
				String methodName = "get" + keyProp.substring(0, 1).toUpperCase() + keyProp.substring(1);
				for (V obj : inputList) {
					result.add((K) obj.getClass().getMethod(methodName).invoke(obj));
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public static <K, V> List<K> filterByKey(List<K> sourceList, List<V> inputKeys, String keyProp) {
		try {
			if (sourceList == null || sourceList.size() == 0) {
				return new ArrayList<K>();
			}
			if (inputKeys != null && inputKeys.size() != 0) {
				String methodName = "get" + keyProp.substring(0, 1).toUpperCase() + keyProp.substring(1);
				Iterator<K> iterator = sourceList.iterator();
				while (iterator.hasNext()) {
					K object = iterator.next();
					for (V key : inputKeys) {
						if (((V) object.getClass().getMethod(methodName).invoke(object)).equals(key)) {
							iterator.remove();
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return sourceList;
	}

	public static <K> boolean isEmpty(List<K> list) {
		if (list == null || list.isEmpty()) {
			return true;
		}
		return false;
	}
}
