package com.foreign.business.service;

import java.math.BigDecimal;
import java.util.List;

import com.foreign.common.wdzj.bean.LoanMarkModel;


public interface BorrowService {

	/**
	 * @Description 查询当天借款标总额
	 * @action getSumAmount
	 * @return BigDecimal
	 */
	BigDecimal getSumAmount(String date, Short BorrowType);

	/**
	 * @Description 查询当日借款标信息
	 * @action getLoanInfos
	 * @return List<LoanMarkModel>
	 */
	List<LoanMarkModel> getLoanBorrowInfos(Short borrowType, String date, Integer page, Integer pageSize);
}
