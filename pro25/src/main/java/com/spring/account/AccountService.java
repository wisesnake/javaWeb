package com.spring.account;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED)
public class AccountService {


	AccountDAO accountDAO;
	
	public void setAccountDAO(AccountDAO accountDAO) {
		System.out.println("DAO주입");
		this.accountDAO = accountDAO;
	}

	public void sendMoney() {
		accountDAO.updateBalance1();
		
		accountDAO.updateBalance2();
	}
}
