package com.zemoso.aop.demo;

import com.zemoso.aop.Account;
import com.zemoso.aop.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemo {
    public static void main(String[] args) {

        //read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        //get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        //call method to find the accounts
        List<Account> theAccounts = theAccountDAO.findAccounts();

        //display the accounts
        System.out.println("\n\nMain Program: AfterReturningDemoApp");
        System.out.println("-----------");

        System.out.println(theAccounts);
        System.out.println("\n");

        //close the context
        context.close();
    }
}
