package com.google.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.s1.util.FileManager;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private FileManager fileManager;
	
	//
	public MemberFileDTO detailFile(MemberFileDTO memberFileDTO)throws Exception{
		return memberDAO.detailFile(memberFileDTO);
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
	public int join(MemberDTO memberDTO, MultipartFile photo) throws Exception {
		int result= memberDAO.join(memberDTO);
		//member table에 id가 있어야 memberFileDTO에 아이디를 넣을 수 있음 
		//memberfile의 id가 member의 id를 참조하고있음 
		//그래서 먼저 id넣어주는겨 
		
		//1. 파일을 HDD에 저장 (fileManger가)
		//cilent가 올린 파일을 resources/upload/member/ 이 경로(Tomcat기준)에 담기위해 
		//fileManager.save 메서드 실행 
		//fileManager.save 가 경로를 톰캣기준에서 OS기준 경로로 바꿔줌 
		String fileName=fileManager.save(photo, "resources/upload/member/");
		
		//2. 정보를 DB에 저장 (id ,filename, oriname 저장해야됨)
		MemberFileDTO memberFileDTO = new MemberFileDTO();
		memberFileDTO.setId(memberDTO.getId());
		memberFileDTO.setFileName(fileName);
		memberFileDTO.setOriName(photo.getOriginalFilename());
		memberDAO.addFile(memberFileDTO);
		
		return result;//memberDAO.join(memberDTO);
		//!!!!!!!!!!!!!!!!!!!!!!!!!수정해라 
	}
	
	
}
