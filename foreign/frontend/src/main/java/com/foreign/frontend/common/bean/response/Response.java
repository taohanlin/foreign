package com.foreign.frontend.common.bean.response;

public class Response {

	private int statusCode;

	private String msg;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public static Response build(int statusCode, String msg) {
		Response response = new Response();
		response.setMsg(msg);
		response.setStatusCode(statusCode);
		return response;
	}

	public static final int PARAM_INVALID = -10;

	public static final int FAILED = -50;

	public static final int SUCCESS = 200;

	public static final int FUTHER_DEAL = 250;
}
