package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

interface Bankaccservice{
	public double withdraw(long accountid,double balance);
	public double deposit(long accountid,double balance);
	public double getBalance(long accountid);
	public boolean fundtransfer(long fromacc,long toacc,double amount);
	
}
public class Bankaccserviceimpl implements Bankaccservice {
	@Autowired 
	BankaccRepository repo;
	public void setRepo(BankaccRepository repo) {
		this.repo=repo;
		
	}
	@Override
	public double withdraw(long accountid,double balance) {
		var currentbalance=repo.getBalance(accountid);
		if(currentbalance>balance)
		{
			repo.updateBalance(accountid, currentbalance-balance);
		}
		return repo.getBalance(accountid);
	}
	@Override
	public double deposit(long accountid,double balance) {
		var currentbalance=repo.getBalance(accountid);
		repo.updateBalance(accountid, currentbalance+balance);
	    return repo.getBalance(accountid);
	}
	@Override
	public double getBalance(long accountid) {
		return repo.getBalance(accountid);
	}
	@Override
	public boolean fundtransfer(long fromacc,long toacc,double amount) {
		try {
			var currentbalance=repo.getBalance(fromacc);
		     if(currentbalance>amount) {
		    	 repo.updateBalance(fromacc, currentbalance-amount);
		    	 var currentbalance1=repo.getBalance(toacc);
		    	 repo.updateBalance(toacc, currentbalance-amount);
		    	 return true;
		     }
		
		
		}
		catch(Exception e) {
			return false;
		}
		return false;
	}
}
