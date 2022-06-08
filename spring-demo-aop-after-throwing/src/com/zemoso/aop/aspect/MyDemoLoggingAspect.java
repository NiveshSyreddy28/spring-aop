package com.zemoso.aop.aspect;

import com.zemoso.aop.Account;
import org.aspectj.lang.JoinPoint;
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

    @AfterThrowing(
            pointcut = "execution(* com.zemoso.aop.dao.AccountDAO.findAccounts(..))",
            throwing = "exc")
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable exc){

        //print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n========> Executing @AfterReturning on method: " + method);

        //log the exception
        System.out.println("\n========> The exception is: " + exc);

    }
    // add new advice for @AfterReturning on the findAccounts method
    @AfterReturning(
            pointcut = "execution(* com.zemoso.aop.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result){

        //print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n========> Executing @AfterReturning on method: " + method);

        //print out the results of the method call
        System.out.println("\n========> result is: " + result);

        // post-process the data before calling into the main

        //convert the accounts name to upper case
        convertAccountnamesToUpperCase(result);

        System.out.println("\n========> result is: " + result);

    }

    private void convertAccountnamesToUpperCase(List<Account> result) {

        //loop through accounts
        for (Account account:result) {

            //get the uppercase version of name
            String upperCaseName = account.getName().toUpperCase();

            //update the name on the account
            account.setName(upperCaseName);
        }
    }

}
