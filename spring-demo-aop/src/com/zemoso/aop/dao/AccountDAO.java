package com.zemoso.aop.dao;

import com.zemoso.aop.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount(Account account){

        System.out.println(getClass() + ": Doing my db work: adding an account");
    }
    public boolean doWork(){
        System.out.println(getClass() + " : doing work");
        return false;
    }
}
