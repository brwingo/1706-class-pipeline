package com.revature.dao;

//import com.revature.model.BankAccount;
import com.revature.model.BankUser;

public interface BankUserDao {
	
	//crud ops
	
	public BankUser getUserByUsername(BankUser user);
	//public BankAccount getBankAccountByUserId(BankUser user);

}
