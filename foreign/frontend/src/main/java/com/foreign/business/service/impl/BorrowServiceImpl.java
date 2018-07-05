package com.foreign.business.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foreign.business.bean.result.WdzjBorrowResult;
import com.foreign.business.dao.BorrowDao;
import com.foreign.business.service.BorrowService;
import com.foreign.common.wdzj.bean.LoanMarkModel;

@Service
public class BorrowServiceImpl implements BorrowService {

	@Autowired
	private BorrowDao borrowDao;

	@Override
	public BigDecimal getSumAmount(String date, Short borrowType) {
		return borrowDao.getSumAmount(date, borrowType);
	}

	@Override
	public List<LoanMarkModel> getLoanBorrowInfos(Short borrowType, String date, Integer page, Integer pageSize) {
		List<WdzjBorrowResult> results = borrowDao.getWdzjBorrowInfos(borrowType, date, page, pageSize);
		for (WdzjBorrowResult result : results) {

		}
		return null;
	}

}
