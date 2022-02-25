package com.google.s1.Notice;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.s1.MyJunitCase;
import com.google.s1.notice.NoticeDAO;
import com.google.s1.notice.NoticeDTO;
import com.google.s1.util.Pager;

public class NoticeDAOTest extends MyJunitCase{

	@Autowired
	private NoticeDAO noticeDAO;
	private Date sysdate;

//list
@Test
public void listTest() throws Exception {
	Pager pager= new Pager();
	pager.setPage(1L);
	pager.makeRow();
	pager.makeNum(200L);
	List<NoticeDTO> ar=noticeDAO.list(pager);
	assertNotEquals(0, ar.size());
}
//detail
//@Test
public void detailTest() throws Exception{
	NoticeDTO noticeDTO =new NoticeDTO();
	noticeDTO.setNum(1);
	noticeDTO=noticeDAO.detail(noticeDTO);
	assertNotNull(noticeDTO);
}
//add
//@Test
public void addTest()throws Exception{
	
	for(int i=0;i<200;i++) {
	NoticeDTO noticeDTO =new NoticeDTO();
	noticeDTO.setContents("contents"+i);
	noticeDTO.setRegDate(sysdate);
	noticeDTO.setTitle("title"+i);
	noticeDTO.setWriter("writer"+i);
	
	int result = noticeDAO.add(noticeDTO);
	}
	System.out.println("finish");
}
//delete
//@Test
public void deleteTest() throws Exception{
	NoticeDTO noticeDTO=new NoticeDTO();
	noticeDTO.setNum(21);
	
	int result=noticeDAO.delete(noticeDTO);
	assertEquals(1, result);
}

}
