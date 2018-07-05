package com.foreign.frontend.common.bean.request;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.foreign.common.util.StringUtil;
import com.foreign.frontend.common.exception.HttpCodeExceptiopn;

public class Request {

	private String userCode;

	private short platform;

	private int versionCode;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		if (userCode != null && requestAttributes != null) {
			HttpServletRequest servletRequest = ((ServletRequestAttributes) requestAttributes).getRequest();
			String userIdStr = servletRequest.getParameter("userCode");
			if (StringUtil.isEmpty(userIdStr) || !userIdStr.equals(userCode)) {
				throw new HttpCodeExceptiopn(HttpStatus.CONFLICT, "用户信息不一致，存在篡改风险!");
			}
		}
	}

	public short getPlatform() {
		return platform;
	}

	public void setPlatform(short platform) {
		this.platform = platform;
	}

	public int getVersionCode() {
		return versionCode;
	}

	public void setVersionCode(int versionCode) {
		this.versionCode = versionCode;
	}

}
