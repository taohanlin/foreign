package com.foreign.business.dao;

import java.util.List;

import com.foreign.business.bean.result.WdzjOrderInvestResult;

public interface OrderInvestDao {

	List<WdzjOrderInvestResult> getWdzjInvesterInfos(String borrowNo);

}
