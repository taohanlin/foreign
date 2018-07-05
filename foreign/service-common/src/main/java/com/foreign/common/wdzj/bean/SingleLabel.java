package com.foreign.common.wdzj.bean;

public class SingleLabel {

	// 投标人ID
	private String subscribeUserName;

	// 投标金额
	private double amount;

	// 有效金额
	private double validAmount;

	// 投标时间
	private String addDate;

	// 投标状态*1：全部通过 2：部分通过 注意：平台没有这个字段的默认为1
	private int status;

	// 标识手动或自动投标0：手动 1：自动 注意:平台没有这个字段的默认为0
	private int type;

	public String getSubscribeUserName() {
		return subscribeUserName;
	}

	public void setSubscribeUserName(String subscribeUserName) {
		this.subscribeUserName = subscribeUserName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getValidAmount() {
		return validAmount;
	}

	public void setValidAmount(double validAmount) {
		this.validAmount = validAmount;
	}

	public String getAddDate() {
		return addDate;
	}

	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
