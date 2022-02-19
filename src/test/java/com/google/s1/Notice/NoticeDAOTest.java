package com.google.s1.Notice;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.s1.MyJunitCase;
import com.google.s1.notice.NoticeDAO;
import com.google.s1.notice.NoticeDTO;

public class NoticeDAOTest extends MyJunitCase{

	@Autowired
	private NoticeDAO noticeDAO;
	private Date sysdate;

//list
//@Test
public void listTest() throws Exception {
	List<NoticeDTO> ar=noticeDAO.list();
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
@Test
public void addTest()throws Exception{
	
	NoticeDTO noticeDTO =new NoticeDTO();
	noticeDTO.setContents("contents4");
	noticeDTO.setHit(10);
	noticeDTO.setRegDate(sysdate);
	noticeDTO.setTitle("title4");
	noticeDTO.setWriter("w4");
	
	int result = noticeDAO.add(noticeDTO);
	assertEquals(1, result);
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