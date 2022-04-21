package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class bankaccountcontrol {
       @Autowired
       Bankaccservice service;
       public void setService(Bankaccservice service) {
    	   this.service=service;
    	   
       }
	public bankaccountcontrol() {
		super();
	}
    public void withdrawofbal(long accountid,double balance) {
    	System.out.println(service.withdraw(accountid, balance));
    	
    }
    public void Depositofamount(long accountid,double balance) {
    	System.out.println(service.deposit(accountid,balance));
    	
    }
    public void GetBalance(long accountid) {
    	System.out.println(service.getBalance(accountid));
    }
    public void Fundtransfer(long fromacc,long toacc,double amount) {
    	System.out.println(service.fundtransfer(fromacc,toacc,amount));
    	
    }
    public static void main(String[]args) {
    	ApplicationContext ctx=new ClassPathXmlApplicationContext("bankbean.xml");
        bankaccountcontrol con=(bankaccountcontrol) ctx.getBean("control");
        Bankaccount acco=(Bankaccount)ctx.getBean("acc");
        con.Depositofamount(acco.getAccountid(), 1000);
    
    }
    
    
    
    
    
    
}
