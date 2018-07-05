package com.foreign.business.bean.result;

import java.math.BigDecimal;
import java.util.Date;

public class WdzjOrderInvestResult {

	private String userCode;// 平台用户号

	private BigDecimal investAmountActual;// 实际投资金额

	private Date createTime; // 创建时间

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public BigDecimal getInvestAmountActual() {
		return investAmountActual;
	}

	public void setInvestAmountActual(BigDecimal investAmountActual) {
		this.investAmountActual = investAmountActual;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
