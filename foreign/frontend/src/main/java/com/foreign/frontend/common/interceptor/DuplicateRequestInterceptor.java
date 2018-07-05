package com.foreign.frontend.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.foreign.common.constant.CacheKeyConstant;
import com.foreign.common.util.RedisLock;
import com.foreign.common.util.StringUtil;
import com.foreign.frontend.common.util.IPUtil;
import com.foreign.frontend.common.util.ResponseUtil;

public class DuplicateRequestInterceptor implements HandlerInterceptor {

	private static Logger logger = LoggerFactory.getLogger(DuplicateRequestInterceptor.class);

	@Autowired
	private RedisLock redisLock;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String memcacheKey = createKey(request);
		if (!redisLock.lock(memcacheKey, LOCK_SECOND)) {
			logger.error("memcache key {} is duplicate", memcacheKey);
			ResponseUtil.setCodeAndMsg(response, HttpStatus.TOO_MANY_REQUESTS, "请求太频繁，请稍后再试!");
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		String memcacheKey = createKey(request);
		redisLock.unlock(memcacheKey);
	}

	private String createKey(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		if (StringUtil.isEmpty(userId)) {
			userId = IPUtil.getIpAddress(request);
		}
		String requestURI = request.getRequestURI();
		return CacheKeyConstant.DUPLICATE_REQUEST_PREFIX + ":" + requestURI + ":" + userId;
	}

	private static final int LOCK_SECOND = 40;
}
