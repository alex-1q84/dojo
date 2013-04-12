package com.best.demo.staff.aid;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class PerformanceMonitor {

	private static Log log = LogFactory.getLog(PerformanceMonitor.class);
	
	@Around("execution(* com.best.demo.staff.service.*.*(..))")
	public Object logExcuteTime(ProceedingJoinPoint pjp) {
		try {
			long begin = System.currentTimeMillis();
			log.info(String.format("����%s ��ʼʱ��%s", pjp.getSignature().toString(), new Date(begin)));
			Object result = pjp.proceed();
			long end = System.currentTimeMillis();
			log.info(String.format("����%s ����ʱ�� %s ʱ�� %d����", pjp.getSignature().toString(), new Date(end), end-begin));
			
			return result;
		} catch (Throwable e) {
			log.warn("AOP �쳣", e);
		}
		return null;
	}

}
