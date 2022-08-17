package com.infy.utility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.infy.Exception.CustomException;


@Aspect
@Component
public class LoggingCls {
	public static final Log logger=LogFactory.getLog(LoggingCls.class);
	
	@Before("execution(void com.infy.service.MovieExpressService.Search*(..))")
	public void searchlogbefore() {
		logger.info("Searching in the database please wait.....");
	}

    @AfterReturning(pointcut="execution(void com.infy.service.MovieExpressService.Search*(..))",returning="retVal")
	public void searchlogafterreturning(JoinPoint jp, Object retVal)
    {
		logger.info("Success meassage return...!!!");
	}
 
    @AfterThrowing(pointcut="execution(void com.infy.service.MovieExpressService.Search*(..))",throwing="ex")
   	public void searchlogafterthrowing( JoinPoint joinPoint, CustomException ex)
       {
   		logger.error("error meassage throw...!!!"+ex.getMessage());
     	}
}
