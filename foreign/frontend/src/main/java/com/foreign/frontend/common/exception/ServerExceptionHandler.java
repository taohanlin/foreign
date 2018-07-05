package com.foreign.frontend.common.exception;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONException;
import com.foreign.frontend.common.util.ResponseUtil;

public class ServerExceptionHandler implements HandlerExceptionResolver {

	private Logger logger = LoggerFactory.getLogger(ServerExceptionHandler.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

		if (ex instanceof JSONException && ex.getCause() instanceof InvocationTargetException) {
			Throwable throwable = ((InvocationTargetException) ex.getCause()).getTargetException();
			if (throwable != null && throwable instanceof HttpCodeExceptiopn) {
				ex = (HttpCodeExceptiopn) throwable;
			}
		}
		logger.error("", ex);
		try {
			if (ex instanceof HttpCodeExceptiopn) {
				ResponseUtil.setCodeAndMsg(response, ((HttpCodeExceptiopn) ex).getStatus(), ex.getMessage());
			} else {
				ResponseUtil.setCodeAndMsg(response, HttpStatus.INTERNAL_SERVER_ERROR, "服务器异常，请稍后再试!");
			}
		} catch (Throwable e) {
		}
		return new ModelAndView();
	}

}
