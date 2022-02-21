package com.google.s1.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {

	@Autowired
	private NoticeDAO noticeDAO;
	
	public List<NoticeDTO> list() throws Exception {
		List<NoticeDTO> ar=noticeDAO.list();
	
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
