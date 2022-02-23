package com.google.s1.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/notice/*")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@RequestMapping(value="update", method = RequestMethod.POST)
	public String update(NoticeDTO noticeDTO) throws Exception{
		int result=noticeService.update(noticeDTO);
		return "redirect:./list";
		
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void update(NoticeDTO noticeDTO,Model model) throws Exception{
		//위 noticeDTO에는 num 담겨있음 
		noticeDTO=noticeService.detail(noticeDTO);
		System.out.println(noticeDTO.getNum());
		// DB 갔다와 
		// 위noticeDTO에 모든 정보 담김 
		model.addAttribute("dto",noticeDTO);
	
	}
	
	@RequestMapping(value = "list")
	public ModelAndView list(ModelAndView mv) throws Exception {
		List<NoticeDTO> ar = noticeService.list();
		mv.addObject("list",ar); 
	
		return mv;
	}
	
	@RequestMapping(value = "detail")
	public void detail(NoticeDTO noticeDTO,Model model ) throws Exception{
		noticeDTO=noticeService.detail(noticeDTO);
		model.addAttribute("dto", noticeDTO);
		
		
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
