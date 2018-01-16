package com.in28minutes.spring.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//AOP
//Configuration
@Aspect  //The combination between Pointcut and Advice is called Aspect
@Configuration
public class UseAccessAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//Pointcut is What kind of method calls I would intercept --->
	//execution(* PACKAGE.*.*(..))
	//weaver [AspectJ or Spring AOP] is the framework witch does the entire logic of making sure that the aspect is in work at the right point.
	//weaving is the process of doing that 
	//@Before("execution(* com.in28minutes.spring.aop.springaop..*.*(..))")
	@Before("com.in28minutes.spring.aop.springaop.aspect.CommonJoinPointConfig.dataLayerExecution()")
	public void before(JoinPoint joinPoint){  //JoinPoint is a specific interception (execution instance) of a method called. It contain the data of the method called
		//Advice is what to do when you intercept a method
		logger.info(" Check for user access ");
		logger.info(" Allowed execution for {}", joinPoint);
	}
}