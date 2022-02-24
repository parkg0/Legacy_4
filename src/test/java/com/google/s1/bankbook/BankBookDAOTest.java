package com.google.s1.bankbook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.s1.MyJunitCase;
import com.google.s1.util.Pager;

@Repository
public class BankBookDAOTest extends MyJunitCase{

	@Autowired
	private BankBookDAO bankBookDAO;
	
	
	//@Test
	public void check() {
		assertNotNull(bankBookDAO);
	}
	//list
	@Test
	public void listTest() throws Exception {
		Pager pager =new Pager();
		pager.setPerPage(5L);
		pager.makeRow();
		List<BankBookDTO> ar =bankBookDAO.list(pager);
		System.out.println(ar.get(0).getBookNumber());
		System.out.println(ar.get(4).getBookNumber());
		assertEquals(5, ar.size());
	}
	
	//insert
	//@Test
	public void addTest()throws Exception{
		
		for(int i=0;i<200;i++) {
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookName("bookName"+i);
		bankBookDTO.setBookContents("Contents"+i);
		
		double rate= Math.random();
		// 0.0~1.0 미만의 double type retrun 
		//0.12345678
		rate= rate*1000;//123.45678
		int r= (int)rate;//123
		rate = r/100.0;
		bankBookDTO.setBookRate(rate);// 총3자리, 소숫점2자리 
		bankBookDTO.setBookSale(1);
		int result=bankBookDAO.add(bankBookDTO);
		
		if(i%10==0) { //i가 0또는 10의 배수가 오면 1초동안 멈추기 
		Thread.sleep(1000);
		// 1/1000초(밀리세컨즈)단위  *1000 :1초동안 멈추세요~
		}
		
		}
		System.out.println("Insert Finish");
		//assertEquals(1, result);
		
	}
	
	//detail
	//@Test
	public void detailTest()throws Exception{
		BankBookDTO bankBookDTO= new BankBookDTO();
		bankBookDTO.setBookNumber(2L);
		bankBookDTO=bankBookDAO.detail(bankBookDTO);
		
		assertNotNull(bankBookDTO);
	}
	
	//delete
//	//@Test
	public void deleteTest()throws Exception{
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(2L);
		int result = bankBookDAO.delete(bankBookDTO);
		assertEquals(1, result);
	}
}
