package com.google.s1.bankbook;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.s1.util.Pager;

@Controller
@RequestMapping(value="/bankbook/*")
public class BankBookController {

	@Autowired
	private BankBookService bankBookService;

	//db에 update 처리
	@RequestMapping(value = "update",method = RequestMethod.POST)
	public String update(BankBookDTO bankBookDTO) throws Exception{
		int result=bankBookService.update(bankBookDTO);
		return "redirect:./list";
	}
	
	
	//update form 
	@RequestMapping(value = "update",method = RequestMethod.GET)
	public void update(BankBookDTO bankBookDTO, Model model)throws Exception{
		System.out.println(bankBookDTO.getBookNumber());
		
		//위 bankbookDTO에 bookNumber담겨있음 
		bankBookDTO=bankBookService.detail(bankBookDTO);
		//위 bankbookDTO에 모든 정보 담겨 있음 
		model.addAttribute("dto", bankBookDTO);
	}
	

	
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
	public ModelAndView list(ModelAndView mv, Pager pager) throws Exception{
		//ModelAndView쓰는 방식 2개
		//매개변수 선언하는 방법 √
		//메서드 내에서 객체 생성하는 방법 
		//ModelAndView modelAndView = new ModelAndView();
		List<BankBookDTO> ar =bankBookService.list(pager); 
		mv.addObject("list",ar);
		mv.addObject("pager", pager); //startnum=1 lastnum=208 jsp로 보내 
		mv.setViewName("bankbook/list");
		return mv;
		
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(BankBookDTO bankBookDTO) throws Exception{
		int result=bankBookService.delete(bankBookDTO);
		return "redirect:./list";
	}


	
}
