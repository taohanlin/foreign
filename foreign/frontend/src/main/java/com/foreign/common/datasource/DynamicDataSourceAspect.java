package com.foreign.common.datasource;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @Description: 数据源切面
 * @author taohanlin
 * @date 2018年6月11日 下午6:03:44
 */
@Aspect
@Component
public class DynamicDataSourceAspect {

	@Pointcut("@annotation(com.foreign.common.datasource.DynamicDataSourceAnnotation)")
	public void pointCut() {
	}

	@Before("pointCut()")
	public void testBefore(JoinPoint point) {
		// 获得当前访问的class
		Class<?> className = point.getTarget().getClass();
		DynamicDataSourceAnnotation dataSourceAnnotation = className.getAnnotation(DynamicDataSourceAnnotation.class);
		String dataSource = DataSourceConst.BASIC_BUSINESS;
		// 优先级: 方法 > 类 > BASIC_BUSINESS
		if (dataSourceAnnotation != null) {
			dataSource = dataSourceAnnotation.dataSource();
		}
		String methodName = point.getSignature().getName();
		// 得到方法的参数的类型
		Class<?>[] argClass = ((MethodSignature) point.getSignature()).getParameterTypes();
		try {
			Method method = className.getMethod(methodName, argClass);
			if (method.isAnnotationPresent(DynamicDataSourceAnnotation.class)) {
				DynamicDataSourceAnnotation annotation = method.getAnnotation(DynamicDataSourceAnnotation.class);
				dataSource = annotation.dataSource();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		DataSourceContextHolder.setDataSourceType(dataSource);

	}

	@After("pointCut()")
	public void testAfter(JoinPoint point) {
		// 获得当前访问的class
		Class<?> className = point.getTarget().getClass();
		DynamicDataSourceAnnotation dataSourceAnnotation = className.getAnnotation(DynamicDataSourceAnnotation.class);
		if (dataSourceAnnotation != null) {
			// 获得访问的方法名
			String methodName = point.getSignature().getName();
			// 得到方法的参数的类型
			Class<?>[] argClass = ((MethodSignature) point.getSignature()).getParameterTypes();
			String dataSource = DataSourceConst.BASIC_BUSINESS;
			try {
				Method method = className.getMethod(methodName, argClass);
				if (method.isAnnotationPresent(DynamicDataSourceAnnotation.class)) {
					DynamicDataSourceAnnotation annotation = method.getAnnotation(DynamicDataSourceAnnotation.class);
					dataSource = annotation.dataSource();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (dataSource != null && !DataSourceConst.BASIC_BUSINESS.equals(dataSource)) {
				DataSourceContextHolder.clearDataSourceType();
			}
		}
	}
}