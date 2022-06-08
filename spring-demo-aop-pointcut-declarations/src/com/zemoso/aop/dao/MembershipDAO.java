package com.zemoso.aop.dao;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
    public void addAccount(){
        System.out.println(getClass() + "Doing stuff adding a membership account");
    }
    public void goToSleep(){
        System.out.println(getClass() + " I'm going to sleep ");
    }
}
