package com.spring.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service("memberService")
@Transactional(propagation = Propagation.REQUIRED)
public interface MemberService {
	public List listMembers() throws DataAccessException;

}
