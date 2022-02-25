package com.google.s1.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.s1.util.Pager;

@Controller
@RequestMapping(value = "/notice/*")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView list(ModelAndView mv,Pager pager) throws Exception {
		List<NoticeDTO> ar = noticeService.list(pager);
		mv.addObject("list",ar);
		mv.addObject("pager",pager);
		mv.setViewName("notice/list");
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
