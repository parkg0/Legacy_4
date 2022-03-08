package com.google.s1.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.s1.board.BoardDTO;
import com.google.s1.board.notice.NoticeDTO;
import com.google.s1.util.Pager;

@Controller
@RequestMapping(value="/qna/**")
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	//model에 board라는 속성명으로 qna를 담겠다 메서드 호출할때마다 실행됨 
	@ModelAttribute("board")
	public String board() {
		return "qna";
	}
	
	//reply
	@RequestMapping(value="reply", method = RequestMethod.GET)
	public ModelAndView reply(QnaDTO qnaDTO,ModelAndView mv)throws Exception{
		mv.addObject("dto", qnaDTO); //부모 글번호 
		mv.setViewName("board/reply");
		return mv;
	}
	
	//reply db 
	@RequestMapping(value="reply",method = RequestMethod.POST)
	public ModelAndView reply(QnaDTO qnaDTO)throws Exception{
		ModelAndView mv= new ModelAndView();
		int result= qnaService.reply(qnaDTO);
		
		mv.setViewName("redirect:./list");
		
		return mv;
	}
	
	//detail
	@RequestMapping(value = "detail",method =RequestMethod.GET)
	public String detail(QnaDTO qnaDTO,Model model)throws Exception{
		BoardDTO boardDTO=qnaService.detail(qnaDTO);
		model.addAttribute("dto",boardDTO);
		
		return "board/detail";
	}
	
	//list
	@RequestMapping(value="list",method = RequestMethod.GET)
	public String list(Pager pager,Model model)throws Exception{
		List<BoardDTO> ar=qnaService.list(pager);
		model.addAttribute("list",ar);
		
		return "board/list";
		
	}
	//add form으로 이동 
		@RequestMapping(value = "add", method = RequestMethod.GET)
		public ModelAndView add() throws Exception{
			ModelAndView mv=new ModelAndView();
			mv.setViewName("board/add");
			return mv;
			
		}
		//입력받은 값을 받아서 DB로 보내 
		@RequestMapping(value = "add",method = RequestMethod.POST)
		public ModelAndView add(QnaDTO qnaDTO) throws Exception{
			ModelAndView mv= new ModelAndView();
			int result= qnaService.add(qnaDTO);
			mv.setViewName("redirect:./list");
			
			return mv;
		}
		
	//update form으로 이동 
		@RequestMapping(value = "update",method = RequestMethod.GET)
		public String update(QnaDTO qnaDTO,Model model) throws Exception{
			BoardDTO boardDTO= qnaService.detail(qnaDTO);
			model.addAttribute("dto", boardDTO);
			return "board/update";
		}
		
		//update DB
		@RequestMapping(value="update",method = RequestMethod.POST)
		public ModelAndView update(QnaDTO qnaDTO) throws Exception{
			ModelAndView mv=new ModelAndView();
			int result= qnaService.update(qnaDTO);
			mv.setViewName("redirect:./list");
			return mv;
		}
	//delete
		//delete
		@RequestMapping(value="delete",method=RequestMethod.GET)
		public String delete(QnaDTO qnaDTO) throws Exception{
			int result=qnaService.delete(qnaDTO);
			return "redirect:./list";
			
		}
}

