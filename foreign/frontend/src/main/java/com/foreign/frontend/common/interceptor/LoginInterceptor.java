package com.foreign.frontend.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.foreign.common.util.JSONUtil;
import com.foreign.common.util.StringUtil;
import com.foreign.frontend.common.util.ResponseUtil;

public class LoginInterceptor implements HandlerInterceptor {

	private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		if (logger.isDebugEnabled()) {
			logger.info("uri is :{}", request.getRequestURI());
			logger.info("headers content-type : {}", request.getHeader(HttpHeaders.CONTENT_TYPE));
			logger.info("headers accept : {}", request.getHeader(HttpHeaders.ACCEPT));
			logger.info("login interceptor params :{}", JSONUtil.toJSONString(request.getParameterMap()));
		}

		String userIdStr = request.getParameter("userId");
		String loginId = request.getParameter("loginId");
		if (StringUtil.isEmpty(userIdStr) || StringUtil.isEmpty(loginId)) {
			logger.error("uri is :{}", request.getRequestURI());
			logger.error("headers content-type : {}", request.getHeader(HttpHeaders.CONTENT_TYPE));
			logger.error("headers accept : {}", request.getHeader(HttpHeaders.ACCEPT));
			logger.error("login interceptor params :{}", JSONUtil.toJSONString(request.getParameterMap()));
			ResponseUtil.setCodeAndMsg(response, HttpStatus.UNAUTHORIZED, "对不起，您的登录已失效，请重新登录!");
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