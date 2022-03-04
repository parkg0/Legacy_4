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
@RequestMapping(value = "/bankbook/*")
public class BankBookController {

	@Autowired
	private BankBookService bankBookService;

	// db에 update 처리
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(BankBookDTO bankBookDTO) throws Exception {
		int result = bankBookService.update(bankBookDTO);
		return "redirect:./list";
	}

	// update form
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void update(BankBookDTO bankBookDTO, Model model) throws Exception {
		System.out.println(bankBookDTO.getBookNumber());

		// 위 bankbookDTO에 bookNumber담겨있음
		bankBookDTO = bankBookService.detail(bankBookDTO);
		// 위 bankbookDTO에 모든 정보 담겨 있음
		model.addAttribute("dto", bankBookDTO);
	}

	// DB에 insert
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(BankBookDTO bankBookDTO) throws Exception {
		int result = bankBookService.add(bankBookDTO);

		return "redirect:./list";
	}

	// insert form 이동
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() throws Exception {

	}

	// detail
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String detail(BankBookDTO bankBookDTO, Model model) throws Exception {
		// bankBookDTO에 bookNumber 담겨있음
		bankBookDTO = bankBookService.detail(bankBookDTO);

		// 조회 성공하면 출력
		// 실패하면 메시지 alert으로 없는 번호입니다.
		// 그리고 다시 list로 이동시키기
		// common/result.jsp이용
		String view = "common/result";

		if (bankBookDTO != null) {
			view = "bankbook/detail";
			model.addAttribute("dto", bankBookDTO);
		} else {
			model.addAttribute("message", "없는 번호입니다. ");
			model.addAttribute("path", "./list");
		}
		return view;

	}

	// list
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView list(ModelAndView mv, Pager pager) throws Exception {
		// ModelAndView쓰는 방식 2개
		// 매개변수 선언하는 방법 √
		// 메서드 내에서 객체 생성하는 방법
		// ModelAndView modelAndView = new ModelAndView();

		// 검색시 kind,search 파라미터 넘어와
		// kind는 선택한것 search는 입력한 값

		List<BankBookDTO> ar = bankBookService.list(pager);
		mv.addObject("list", ar);
		mv.addObject("pager", pager); // startnum=1 lastnum=208 jsp로 보내
		mv.setViewName("bankbook/list");
		return mv;

	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(BankBookDTO bankBookDTO, Model model) throws Exception {
		int result = bankBookService.delete(bankBookDTO);
		
		String message="";
		
		if(result !=0) {
			message= "delete success";
			
		}else {
			message="delete fail";
		}
		
		model.addAttribute("path", "./list");
		model.addAttribute("message", message);
		String path="common/result";
		return path;
		
	}

}
