package com.google.s1.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.s1.util.Pager;

@Service
public class BankBookService {
	// Controller - Service - DAO
	// DAO로 데이터를 보내기 전에 전처리 작업
	// parameter를 서비스로 보내주면 전처리해서 가공된 데이터를 DAO에 보냄
	// DAO에서 리턴받은 데이터를 Controller로 보내기 전 후처리 작업

	@Autowired
	private BankBookDAO bankBookDAO;
	
	//update
	public int update(BankBookDTO bankBookDTO)throws Exception{
		return bankBookDAO.update(bankBookDTO);
	}


	//delete
	public int delete(BankBookDTO bankBookDTO)throws Exception{
		return bankBookDAO.delete(bankBookDTO);
	}
	
	//insert 
	public int add(BankBookDTO bankBookDTO)throws Exception{
		return bankBookDAO.add(bankBookDTO);
	}
	
	//detail
	public BankBookDTO detail(BankBookDTO bankBookDTO)throws Exception{
		return bankBookDAO.detail(bankBookDTO);
	}

	// list
	public List<BankBookDTO> list(Pager pager) throws Exception {
		// DAO메서드 호출 전 전처리 작업
		pager.makeRow(); 
		
		Long totalCount =bankBookDAO.total(pager);
		pager.makeNum(totalCount); //startnum=1 lastnum=208 
		// 호출 후 후처리 작업
		List<BankBookDTO> ar = bankBookDAO.list(pager);
		return ar;
	}
}
