package com.zemoso.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    //this is where we add all of our related advices for logging

    //let's start with a @Before advice

    //@Before("execution(* add*(com.zemoso.aop.Account))")
    @Before("execution(* com.zemoso.aop.dao.*.*(..))")
    public void beforeAddAccountAdvice(){

        System.out.println("\n==========>Executing @Before advice on addAccount()");
    }
}
