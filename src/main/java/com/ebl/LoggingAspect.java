package com.ebl;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @Before("execution(public * com.ebl.rest.*RestService.*(..))")
    public void logBeforeRestCall(JoinPoint jointPoint) throws Throwable {
    	log.info("REST Service call--->" + jointPoint);
        
    }
}
