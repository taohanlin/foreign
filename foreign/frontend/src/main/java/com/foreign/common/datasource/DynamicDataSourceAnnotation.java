package com.foreign.common.datasource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: 数据源切换注解
 * @author taohanlin
 * @date 2018年6月11日 下午6:03:01
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
public @interface DynamicDataSourceAnnotation {
	// dataSource 自定义注解的参数
	String dataSource() default DataSourceConst.BASIC_BUSINESS;
}