package com.zemoso.aop.demo;

import com.zemoso.aop.Account;
import com.zemoso.aop.dao.AccountDAO;
import com.zemoso.aop.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemo {
    public static void main(String[] args) {

        //read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        //get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        //
        MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        Account account = new Account();
        //call the business method
        theAccountDAO.addAccount(account);

        theAccountDAO.doWork();

        theMembershipDAO.goToSleep();
        theMembershipDAO.addAccount();

        //close the context
        context.close();
    }
}
