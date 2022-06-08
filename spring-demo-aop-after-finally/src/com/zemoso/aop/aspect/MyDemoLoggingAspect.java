package com.zemoso.aop.aspect;

import com.zemoso.aop.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @After("execution(* com.zemoso.aop.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {

        //print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n========> Executing @After on method: " + method);

    }
}

