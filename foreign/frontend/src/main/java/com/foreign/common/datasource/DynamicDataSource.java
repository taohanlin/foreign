package com.foreign.common.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Description: 建立动态数据源
 * @author taohanlin
 * @date 2018年6月11日 下午6:02:49
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

	protected Object determineCurrentLookupKey() {
		// 在进行DAO操作前，通过上下文环境变量，获得数据源的类型
		return DataSourceContextHolder.getDataSourceType();
	}

}