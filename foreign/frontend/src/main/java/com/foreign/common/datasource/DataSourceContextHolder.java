package com.foreign.common.datasource;

/**
 * @Description: 获得和设置上下文环境 主要负责改变上下文数据源的名称
 * @author taohanlin
 * @date 2018年6月11日 下午6:02:34
 */
public class DataSourceContextHolder {

	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>(); // 线程本地环境

	// 设置数据源类型
	public static void setDataSourceType(String dataSourceType) {
		contextHolder.set(dataSourceType);
	}

	// 获取数据源类型
	public static String getDataSourceType() {
		return contextHolder.get();
	}

	// 清除数据源类型
	public static void clearDataSourceType() {
		contextHolder.remove();
	}

}