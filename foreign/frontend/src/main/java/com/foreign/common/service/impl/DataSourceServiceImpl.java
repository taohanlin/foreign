package com.foreign.common.service.impl;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.foreign.common.datasource.DataSourceConst;
import com.foreign.common.datasource.DataSourceContextHolder;
import com.foreign.common.datasource.DynamicDataSourceAnnotation;
import com.foreign.common.service.DataSourceService;

@Service
public class DataSourceServiceImpl implements DataSourceService {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<DataSource> list() {
		dataSourceDefault();
		dataSourceBasic();
		dataSourcePublic();
		dataSourceFrom();
		dataSourceDefault();
		return Collections.emptyList();
	}

	public DataSource dataSourceDefault() {
		String dataSourceType = DataSourceContextHolder.getDataSourceType();
		System.out.println(dataSourceType);
		return jdbcTemplate.getDataSource();
	}

	@DynamicDataSourceAnnotation(dataSource = DataSourceConst.PUBLIC)
	public DataSource dataSourcePublic() {
		String dataSourceType = DataSourceContextHolder.getDataSourceType();
		System.out.println(dataSourceType);
		return jdbcTemplate.getDataSource();
	}

	@DynamicDataSourceAnnotation(dataSource = DataSourceConst.FROM)
	public DataSource dataSourceFrom() {
		String dataSourceType = DataSourceContextHolder.getDataSourceType();
		System.out.println(dataSourceType);
		return jdbcTemplate.getDataSource();
	}

	@DynamicDataSourceAnnotation(dataSource = DataSourceConst.BASIC_BUSINESS)
	public DataSource dataSourceBasic() {
		String dataSourceType = DataSourceContextHolder.getDataSourceType();
		System.out.println(dataSourceType);
		return jdbcTemplate.getDataSource();
	}

}
