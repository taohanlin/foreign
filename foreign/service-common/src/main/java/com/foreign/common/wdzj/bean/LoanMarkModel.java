package com.foreign.common.wdzj.bean;

import java.util.List;

public class LoanMarkModel {
	// 项目主键
	private String projectId;

	// 借款标题
	private String title;

	// 借款金额(若标未满截标，以实际投标总额为准)
	private double amount;

	// 只传进度100的标（若是未满截标，需要改为100）
	private String schedule;

	// 利率* 百分比 例如：24.5%统一转化为年化利率传过来。
	private String interestRate;

	// 借款期限
	private int deadline;

	// 期限单位* 仅限 ‘天’ 或 ‘月’
	private String deadlineUnit;

	// 奖励，
	private double reward;

	// 借款类型
	private String type;

	// 还款方式
	private int repaymentType;
	// private List<?> subscribes;

	// 发标人（借款人）ID
	private String userName;

	// 标的详细页面地址链接
	private String loanUrl;

	// 标的计息时间
	private String successTime;

	// 是否机构借款*0:否,1:是
	private int isAgency;

	private List<SingleLabel> subscribes;

	// borrow_no
	private String borrowNo;

	public String getBorrowNo() {
		return borrowNo;
	}

	public void setBorrowNo(String borrowNo) {
		this.borrowNo = borrowNo;
	}

	public List<SingleLabel> getSubscribes() {
		return subscribes;
	}

	public void setSubscribes(List<SingleLabel> subscribes) {
		this.subscribes = subscribes;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double bigDecimal) {
		this.amount = bigDecimal;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(String interestRate) {
		this.interestRate = interestRate;
	}

	public int getDeadline() {
		return deadline;
	}

	public void setDeadline(int deadline) {
		this.deadline = deadline;
	}

	public String getDeadlineUnit() {
		return deadlineUnit;
	}

	public void setDeadlineUnit(String deadlineUnit) {
		this.deadlineUnit = deadlineUnit;
	}

	public double getReward() {
		return reward;
	}

	public void setReward(double reward) {
		this.reward = reward;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getRepaymentType() {
		return repaymentType;
	}

	public void setRepaymentType(int repaymentType) {
		this.repaymentType = repaymentType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLoanUrl() {
		return loanUrl;
	}

	public void setLoanUrl(String loanUrl) {
		this.loanUrl = loanUrl;
	}

	public String getSuccessTime() {
		return successTime;
	}

	public void setSuccessTime(String successTime) {
		this.successTime = successTime;
	}

	public int getIsAgency() {
		return isAgency;
	}

	public void setIsAgency(int isAgency) {
		this.isAgency = isAgency;
	}

}
