package com.foreign.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foreign.business.bean.result.WdzjOrderInvestResult;
import com.foreign.business.dao.OrderInvestDao;
import com.foreign.business.service.OrderInvestService;
import com.foreign.common.wdzj.bean.SingleLabel;

@Service
public class OrderInvestServiceImpl implements OrderInvestService {

	@Autowired
	private OrderInvestDao orderInvestDao;

	@Override
	public List<SingleLabel> getInvesterInfos(String borrowNo) {
		List<WdzjOrderInvestResult> results = orderInvestDao.getWdzjInvesterInfos(borrowNo);
		for (WdzjOrderInvestResult result : results) {
		}
		return null;
	}

}
