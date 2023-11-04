package com.spring.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class AccountController extends MultiActionController{

	private AccountService accountService;
	
	public void setAccountService(AccountService accountService) {
		System.out.println("컨트롤러주입");
		this.accountService = accountService;
	}

	public ModelAndView sendMoney(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("센드머니");
		accountService.sendMoney();
		ModelAndView mav=new ModelAndView();
		
		mav.setViewName("sendMoney");
		return mav;
	}
	
}
