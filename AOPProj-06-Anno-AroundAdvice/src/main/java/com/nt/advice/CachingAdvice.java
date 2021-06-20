package com.nt.advice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("cacheAdvice")
@Aspect
@Order(1)

public class CachingAdvice {
	private Map<String, Object> cachMap = new HashMap<String, Object>();
	
	@Around(value ="execution(double com.nt.service.BamkService.cal*(..))")
	public Object caching(ProceedingJoinPoint pjp) throws Throwable {
		String key = pjp.getSignature() + Arrays.deepToString(pjp.getArgs());
		Object retVal = null;
		if (!cachMap.containsKey(key)) {
			retVal = pjp.proceed();
			cachMap.put(key, retVal);
			System.out.println("from target method");
		} // if
		else {
			retVal = cachMap.get(key);
			System.out.println("From Cache");
		}
		return retVal;
		
	}
}
