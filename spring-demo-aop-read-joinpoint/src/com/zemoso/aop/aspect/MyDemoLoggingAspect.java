package com.zemoso.aop.aspect;

import com.zemoso.aop.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Before("com.zemoso.aop.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint){

        System.out.println("\n==========>Executing @Before advice on addAccount()");

        //display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        //display method arguments

        //get the args
        Object[] args = theJoinPoint.getArgs();

        //loop through args
        for (Object object: args) {
            System.out.println(object);

            if (object instanceof Account){
                //downcast and print Account specific stuff
                Account theAccount = (Account) object;

                System.out.println("Account name: " + theAccount.getName());
                System.out.println("Account level: " + theAccount.getLevel());
            }
        }
    }


}
