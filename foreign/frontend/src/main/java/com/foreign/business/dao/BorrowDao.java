package com.foreign.business.dao;

import java.math.BigDecimal;
import java.util.List;

import com.foreign.business.bean.result.WdzjBorrowResult;

public interface BorrowDao {

	BigDecimal getSumAmount(String interestStartDate, Short borrowType);

	List<WdzjBorrowResult> getWdzjBorrowInfos(Short borrowType, String interestStartDate, Integer page, Integer pageSize);

}
