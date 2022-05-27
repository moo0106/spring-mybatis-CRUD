package com.spring.db.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopLogger {
	
private static final Logger logger = LoggerFactory.getLogger(AopLogger.class);
	
	@Around("execution(* com.spring.db.jdbc.board.service.I*.*(..))")
	public Object timeLog(ProceedingJoinPoint jp) throws Throwable{
		long startTime = System.currentTimeMillis();
		logger.info(Arrays.toString(jp.getArgs()));
		
		Object result = jp.proceed();
		
		long endTime = System.currentTimeMillis();
		logger.info(jp.getSignature().getName() + " : " + (endTime - startTime));
		logger.info("===========================");
		
		return result;
		}

}
