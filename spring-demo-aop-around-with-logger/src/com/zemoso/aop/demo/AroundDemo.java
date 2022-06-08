package com.zemoso.aop.demo;

import com.zemoso.aop.Account;
import com.zemoso.aop.dao.AccountDAO;
import com.zemoso.aop.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AroundDemo {
    public static void main(String[] args) {

        //read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        //get the bean from spring container
        TrafficFortuneService trafficFortuneService =
                context.getBean("trafficFortuneService", TrafficFortuneService.class);

        System.out.println("\nMain program: AroundDemo");

        System.out.println("Calling getFortune");

        String data = trafficFortuneService.getFortune();

        System.out.println("\nMy fortune is: " + data);

        System.out.println("Finished");
        //close the context
        context.close();
    }
}
