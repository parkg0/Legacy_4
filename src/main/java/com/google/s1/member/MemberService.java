package com.google.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	//update
	public int update(MemberDTO memberDTO)throws Exception{
		return memberDAO.update(memberDTO);
	}
	
	//mypage
	public MemberDTO mypage(MemberDTO memberDTO)throws Exception{
		return memberDAO.mypage(memberDTO);
	}
	//login
	public MemberDTO login(MemberDTO memberDTO)throws Exception{
		return memberDAO.login(memberDTO);
	}
	//join
	public int join(MemberDTO memberDTO) throws Exception {
		return memberDAO.join(memberDTO);
	}
	
	
}
