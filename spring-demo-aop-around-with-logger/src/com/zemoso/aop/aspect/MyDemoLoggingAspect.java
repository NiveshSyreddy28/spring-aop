package com.zemoso.aop.aspect;

import com.zemoso.aop.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Around("execution(* com.zemoso.aop.service.*.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        //printout the method we're advising on
        String method = proceedingJoinPoint.getSignature().toShortString();
        logger.info("\n========> Executing @Around on method: " + method);

        //get begin time stamp
        long begin = System.currentTimeMillis();

        //now let's execute the method
        Object result = proceedingJoinPoint.proceed();

        //get en time stamp
        long end = System.currentTimeMillis();

        //compute duration and display
        long duration = end - begin;
        logger.info("\n=====> Duration: " + duration/1000.0 + " seconds");

        return null;
    }

//    @After("execution(* com.zemoso.aop.dao.AccountDAO.findAccounts(..))")
//    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
//
//        //print out which method we are advising on
//        String method = theJoinPoint.getSignature().toShortString();
//        logger.info("\n========> Executing @After on method: " + method);
//
//    }
}

