package com.foreign.business.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.foreign.business.bean.result.WdzjOrderInvestResult;
import com.foreign.business.dao.OrderInvestDao;
import com.foreign.common.datasource.DataSourceConst;
import com.foreign.common.datasource.DynamicDataSourceAnnotation;
import com.foreign.common.datasource.MyBatisDaoSupport;
import com.foreign.common.util.MapUtils;

@Repository
public class OrderInvestDaoImpl extends MyBatisDaoSupport implements OrderInvestDao {

	private static final String NAMESPACE = "com.foreign.business.bean.OrderInvest";

	@Override
	@DynamicDataSourceAnnotation(dataSource = DataSourceConst.BASIC_BUSINESS)
	public List<WdzjOrderInvestResult> getWdzjInvesterInfos(String borrowNo) {
		return getSqlSession().selectList(NAMESPACE + ".getWdzjInvesterInfos", MapUtils.build("borrowNo", borrowNo));
	}

}
