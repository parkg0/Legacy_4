package com.google.s1.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.s1.bankbook.BankBookDAO;
import com.google.s1.util.Pager;

@Service
public class NoticeService {

	@Autowired
	private NoticeDAO noticeDAO;
	
	public List<NoticeDTO> list(Pager pager) throws Exception {
		pager.makeRow();
		Long totalCount=noticeDAO.total(pager);
		System.out.println(totalCount);
		pager.makeNum(totalCount);
		List<NoticeDTO> ar=noticeDAO.list(pager);
	
		return ar;
	}
	
	public NoticeDTO detail(NoticeDTO noticeDTO) throws Exception{
		noticeDTO=noticeDAO.detail(noticeDTO);
		return noticeDTO;
	}
	
	public int add(NoticeDTO noticeDTO) throws Exception{
		int result=noticeDAO.add(noticeDTO);
		
		return result;
	}
}
