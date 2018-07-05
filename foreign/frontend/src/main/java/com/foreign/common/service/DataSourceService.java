package com.foreign.common.service;

import java.util.List;

import javax.sql.DataSource;

public interface DataSourceService {
	/**
	 * 已配置数据源
	 * @return
	 */
	List<DataSource> list();
}
