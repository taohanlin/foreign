package com.foreign.frontend.common.support;

import com.alibaba.fastjson.serializer.ValueFilter;

public class LongValueFilter implements ValueFilter {

	@Override
	public Object process(Object object, String name, Object value) {
		if (value instanceof Long) {
			if ((Long) value > 999999999999999L) {
				return value + "";
			}
		}
		return value;

	}

}