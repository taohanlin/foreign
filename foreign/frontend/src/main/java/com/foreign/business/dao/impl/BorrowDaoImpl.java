package com.foreign.business.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.foreign.business.bean.result.WdzjBorrowResult;
import com.foreign.business.dao.BorrowDao;
import com.foreign.common.datasource.DataSourceConst;
import com.foreign.common.datasource.DynamicDataSourceAnnotation;
import com.foreign.common.datasource.MyBatisDaoSupport;
import com.foreign.common.util.MapUtils;

@Repository
public class BorrowDaoImpl extends MyBatisDaoSupport implements BorrowDao {

	private static final String NAMESPACE = "com.foreign.business.bean.Borrow";

	@Override
	@DynamicDataSourceAnnotation(dataSource = DataSourceConst.BASIC_BUSINESS)
	public BigDecimal getSumAmount(String interestStartDate, Short borrowType) {
		BigDecimal sumAmount = getSqlSession().selectOne(NAMESPACE + ".getSumAmount",
				MapUtils.build("interestStartDate", interestStartDate, "borrowType", borrowType));
		return sumAmount == null ? new BigDecimal(0) : sumAmount;
	}

	@Override
	@DynamicDataSourceAnnotation(dataSource = DataSourceConst.BASIC_BUSINESS)
	public List<WdzjBorrowResult> getWdzjBorrowInfos(Short borrowType, String interestStartDate, Integer page, Integer pageSize) {
		return getSqlSession().selectList(NAMESPACE + ".getWdzjBorrowInfos",
				MapUtils.build("borrowType", borrowType, "interestStartDate", interestStartDate, "page", page, "pageSize", pageSize));
	}

}
