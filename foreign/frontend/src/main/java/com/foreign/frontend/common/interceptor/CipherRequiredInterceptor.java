package com.foreign.frontend.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.foreign.common.service.EnviromentService;
import com.foreign.common.util.StringUtil;
import com.foreign.frontend.common.util.ResponseUtil;

public class CipherRequiredInterceptor implements HandlerInterceptor {

	@Autowired
	private EnviromentService enviromentService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		if (!enviromentService.isDevMode()) {
			return true;
		}

		String contentType = request.getHeader(HttpHeaders.CONTENT_TYPE);
		if (StringUtil.isEmpty(contentType) || !contentType.contains("application/encrypted-json")) {
			ResponseUtil.setCodeAndMsg(response, HttpStatus.UNSUPPORTED_MEDIA_TYPE, "Content-Type必须为application/encrypted-json!");
			return false;
		}

		String acceptType = request.getHeader(HttpHeaders.ACCEPT);
		if (StringUtil.isEmpty(acceptType) || !acceptType.contains("application/encrypted-json")) {
			ResponseUtil.setCodeAndMsg(response, HttpStatus.UNSUPPORTED_MEDIA_TYPE, "Accept必须为application/encrypted-json!");
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
	}

}
