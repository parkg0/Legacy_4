package com.google.s1.bankbook;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BankBookDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.google.s1.bankbook.BankBookDAO.";
	//어느 매퍼? 
	//변경 금지하기위해 파이널 
	
	//detail 
	public BankBookDTO detail(Long num)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"detail",num);
	}

	//list
	public List<BankBookDTO> list() throws Exception{
		//List<BankBookDTO> 이건 풀패키지명 안쓰는 이유: 같은 패키지 내에 
		//String naem="";  이거 import 안해 왜? 같은 패키지 내에 있는 객체를 사용할때는 임포트 안해 
		//그리고java.lang 패키지 안에 있는 개체를 사용할때는 임포트 안해 
		return sqlSession.selectList(NAMESPACE+"list");
		//어느 매퍼? + id 
	}
	
	//insert 
	public int add(BankBookDTO bankBookDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"add",bankBookDTO);
	}
	
	//delete
	public int delete(BankBookDTO bankBookDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"delete", bankBookDTO);
	}
	
}
