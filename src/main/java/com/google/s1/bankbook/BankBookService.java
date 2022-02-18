package com.google.s1.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankBookService {
	// Controller - Service - DAO
	// DAO로 데이터를 보내기 전에 전처리 작업
	// parameter를 서비스로 보내주면 전처리해서 가공된 데이터를 DAO에 보냄
	// DAO에서 리턴받은 데이터를 Controller로 보내기 전 후처리 작업

	@Autowired
	private BankBookDAO bankBookDAO;
	

	// 메서드는 DAO의 메서드와 거의 동일
	
	//insert 
	public int add(BankBookDTO bankBookDTO)throws Exception{
		return bankBookDAO.add(bankBookDTO);
	}
	
	//detail
	public BankBookDTO detail(BankBookDTO bankBookDTO)throws Exception{
		return bankBookDAO.detail(bankBookDTO);
	}

	// list
	public List<BankBookDTO> list() throws Exception {
		// DAO메서드 호출 전 전처리 작업
		// 호출 후 후처리 작업
		List<BankBookDTO> ar = bankBookDAO.list();
		return ar;
	}
}
