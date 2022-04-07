package com.epam.demo.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.epam.demo.aop.AopExampleService.*(..))")
    public void publicMethodsPointCut() {

    }

//    @Before("publicMethodsPointCut()")
//    public void beforPublicMethodAdvice(JoinPoint joinPoint) {
//        logger.info("from aspect: entering into {} method", joinPoint.getSignature().getName());
//    }

    @Around("publicMethodsPointCut()")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("from aspect: entering into {} method", joinPoint.getSignature().getName());

        // before method
        joinPoint.proceed();
        // after method

        logger.info("from aspect: Leaving {} method", joinPoint.getSignature().getName());
    }
}
