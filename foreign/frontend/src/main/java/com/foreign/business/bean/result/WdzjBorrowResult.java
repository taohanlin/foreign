package com.foreign.business.bean.result;

import java.math.BigDecimal;

public class WdzjBorrowResult {

	private String borrowNo;// 标的编号

	private String borrowName;// 标的名称

	private String fromBorrowContractNo;// 借款项目合同号 （资产端）

	private BigDecimal contractAmount;// 合同金额

	private BigDecimal annualizedRate;// 预期年化收益率

	private short periodLength;// 投资周期长度

	private short periodUnit;// 投资周期单位 1:天 2:周 3:月 4:年

	private BigDecimal appendRate;// 附加利率

	private String accountOrgId;// 作业账户（借款人）（冗余）

	private short profitPlan;// borrowDetail 收益处理方式 01：等额本息 02：等额本金 03：按期付息，到期还本
								// 04：一次性还款
								// 99：其他

	public String getBorrowNo() {
		return borrowNo;
	}

	public void setBorrowNo(String borrowNo) {
		this.borrowNo = borrowNo;
	}

	public String getBorrowName() {
		return borrowName;
	}

	public void setBorrowName(String borrowName) {
		this.borrowName = borrowName;
	}

	public String getFromBorrowContractNo() {
		return fromBorrowContractNo;
	}

	public void setFromBorrowContractNo(String fromBorrowContractNo) {
		this.fromBorrowContractNo = fromBorrowContractNo;
	}

	public BigDecimal getContractAmount() {
		return contractAmount;
	}

	public void setContractAmount(BigDecimal contractAmount) {
		this.contractAmount = contractAmount;
	}

	public BigDecimal getAnnualizedRate() {
		return annualizedRate;
	}

	public void setAnnualizedRate(BigDecimal annualizedRate) {
		this.annualizedRate = annualizedRate;
	}

	public short getPeriodLength() {
		return periodLength;
	}

	public void setPeriodLength(short periodLength) {
		this.periodLength = periodLength;
	}

	public short getPeriodUnit() {
		return periodUnit;
	}

	public void setPeriodUnit(short periodUnit) {
		this.periodUnit = periodUnit;
	}

	public BigDecimal getAppendRate() {
		return appendRate;
	}

	public void setAppendRate(BigDecimal appendRate) {
		this.appendRate = appendRate;
	}

	public String getAccountOrgId() {
		return accountOrgId;
	}

	public void setAccountOrgId(String accountOrgId) {
		this.accountOrgId = accountOrgId;
	}

	public short getProfitPlan() {
		return profitPlan;
	}

	public void setProfitPlan(short profitPlan) {
		this.profitPlan = profitPlan;
	}

}
