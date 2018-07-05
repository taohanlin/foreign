package com.foreign.business.service;

import java.util.List;

import com.foreign.common.wdzj.bean.SingleLabel;


public interface OrderInvestService {

	/**
	 * @Description 根据标号查询投资人信息
	 * @action getInvesterInfos
	 * @return List<SingleLabel>
	 */
	List<SingleLabel> getInvesterInfos(String borrowNo);
}
