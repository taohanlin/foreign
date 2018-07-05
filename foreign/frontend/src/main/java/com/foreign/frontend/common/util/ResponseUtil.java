package com.foreign.frontend.common.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

public class ResponseUtil {

	public static void setCodeAndMsg(HttpServletResponse response, HttpStatus status, String msg) throws IOException {
		response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE + ";charset=UTF-8");
		response.setStatus(status.value());
		response.getWriter().write(msg);
	}
}
