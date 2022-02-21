package com.google.s1.bankbook;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/bankbook/*")
public class BankBookController {

	@Autowired
	private BankBookService bankBookService;
	
	//DB에 insert
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(BankBookDTO bankBookDTO)throws Exception{
		int result= bankBookService.add(bankBookDTO);
		
		return "redirect:./list";
	}
	
	//insert form 이동
	@RequestMapping(value = "add",method = RequestMethod.GET)
	public void add()throws Exception{
		
	}
	
	//detail
	@RequestMapping(value = "detail",method =RequestMethod.GET )
	public void detail(BankBookDTO bankBookDTO,Model model) throws Exception{
		//bankBookDTO에 bookNumber 담겨있음 
		bankBookDTO=bankBookService.detail(bankBookDTO);
		model.addAttribute("dto",bankBookDTO);
		
	}
	
	//list
	@RequestMapping(value = "list", method =RequestMethod.GET)
	public ModelAndView list(ModelAndView mv) throws Exception{
		//ModelAndView쓰는 방식 2개
		//매개변수 선언하는 방법 √
		//메서드 내에서 객체 생성하는 방법 
		//ModelAndView modelAndView = new ModelAndView();
		List<BankBookDTO> ar =bankBookService.list();
		mv.addObject("list",ar);
		mv.setViewName("bankbook/list");
		return mv;
		
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(BankBookDTO bankBookDTO) throws Exception{
		int result=bankBookService.delete(bankBookDTO);
		return "redirect:./list";
	}


	
}
