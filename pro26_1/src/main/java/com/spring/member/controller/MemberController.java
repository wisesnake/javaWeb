package com.spring.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.member.vo.MemberVO;

public interface MemberController {
//	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception ;
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception ;
	public String memberForm();
}
