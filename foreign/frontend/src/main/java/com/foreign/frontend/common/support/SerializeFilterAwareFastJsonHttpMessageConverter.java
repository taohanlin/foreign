package com.foreign.frontend.common.support;

import java.io.IOException;
import java.io.OutputStream;

import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

public class SerializeFilterAwareFastJsonHttpMessageConverter extends FastJsonHttpMessageConverter {

	private SerializeFilter[] filters = new SerializeFilter[0];

	public SerializeFilter[] getFilters() {
		return filters;
	}

	public void setFilters(SerializeFilter[] filters) {
		this.filters = filters;
	}

	@Override
	protected void writeInternal(Object obj, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
		OutputStream out = outputMessage.getBody();
		String text = JSON.toJSONString(obj, filters, getFeatures());
		byte[] bytes = text.getBytes(getCharset());
		out.write(bytes);

	}

}