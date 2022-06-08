package com.zemoso.aop.dao;

import com.zemoso.aop.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    //add a new method findAccounts()
    public List<Account> findAccounts() {

         List<Account> myAccounts = new ArrayList<>();

         //create sample Accounts
        Account account1 = new Account("Shyam","Silver");
        Account account2 = new Account("Ram","Platinum");
        Account account3 = new Account("Gopal","Gold");

        //add them to our accounts List
        myAccounts.add(account1);
        myAccounts.add(account2);
        myAccounts.add(account3);

        return myAccounts;
    }
    public String getName() {
        System.out.println(getClass() + ": in getName");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in setName");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": in getServiceCode");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": in setServiceCode");
        this.serviceCode = serviceCode;
    }

    public void addAccount(Account account){

        System.out.println(getClass() + ": Doing my db work: adding an account");
    }
    public boolean doWork(){
        System.out.println(getClass() + " : doing work");
        return false;
    }
}
