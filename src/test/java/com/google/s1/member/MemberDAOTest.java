package com.google.s1.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.s1.MyJunitCase;

public class MemberDAOTest extends MyJunitCase{

	@Autowired
	private MemberDAO memberDAO;

	@Test
	public void mypageTest() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("id1");
		
		memberDTO=memberDAO.mypage(memberDTO);
		assertNotNull(memberDTO);
	}
	
	
	
	//@Test
	public void loginTest() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("id1");
		memberDTO.setPw("pwfdsaf1");
		
		memberDTO=memberDAO.login(memberDTO);
		assertNotNull(memberDTO);
		
	}
	
	//@Test
	public void memberDAO() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("id5");
		memberDTO.setPw("pw5");
		memberDTO.setEmail("dd@dsfsa");
		memberDTO.setPhone("010-0100-8338");
		memberDTO.setName("name5");
	int result=memberDAO.join(memberDTO);
	assertEquals(1, result);
	}

}
