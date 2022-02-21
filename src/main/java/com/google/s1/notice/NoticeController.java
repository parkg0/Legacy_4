package com.google.s1.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/notice/*")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@RequestMapping(value = "list")
	public ModelAndView list(ModelAndView mv) throws Exception {
		List<NoticeDTO> ar = noticeService.list();
		mv.addObject("list",ar);
	
		return mv;
	}
	
	@RequestMapping(value = "detail")
	public NoticeDTO detail(NoticeDTO noticeDTO) throws Exception{
		noticeDTO=noticeService.detail(noticeDTO);
		
		return noticeDTO;
	}
	//form으로 이동 
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() throws Exception{
		
	}
	//입력받은 값을 받아서 DB로 보내 
	@RequestMapping(value = "add",method = RequestMethod.POST)
	public String add(NoticeDTO noticeDTO) throws Exception{
		int result= noticeService.add(noticeDTO);
		
		return "redirect:./list";
	}
}
