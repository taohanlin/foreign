package com.foreign.frontend.common.converter;

import java.io.IOException;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

/**
 * @Description:数据加密解密可以在这里做
 * @author taohanlin
 * @date 2018年6月22日 下午1:40:57
 */
public class CipherFastJsonHttpMessageConverter extends AbstractHttpMessageConverter<Object> {

	@Override
	protected boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	protected Object readInternal(Class<? extends Object> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
		return null;
	}

	@Override
	protected void writeInternal(Object t, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
	}

}
