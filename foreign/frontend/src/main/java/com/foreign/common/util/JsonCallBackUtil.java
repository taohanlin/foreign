package com.foreign.common.util;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

public class JsonCallBackUtil {

	public static <T> void jsonCallBack(String jsoncallback, HttpServletResponse httpServletResponse, T response) throws Exception {
		if (StringUtil.isEmpty(jsoncallback)) {
			httpServletResponse.setContentType("application/json; charset=utf-8");
			httpServletResponse.getWriter().write(JSON.toJSONString(response));
		} else {
			httpServletResponse.setContentType("application/x-javascript; charset=utf-8");
			httpServletResponse.getWriter().write(jsoncallback + "(" + JSON.toJSONString(response) + ")");
		}
	}
}
