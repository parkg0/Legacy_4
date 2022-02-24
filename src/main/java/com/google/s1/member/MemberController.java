package com.google.s1.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/member/*")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@RequestMapping(value="update",method = RequestMethod.POST)
	public String update(MemberDTO memberDTO)throws Exception{
		memberService.update(memberDTO);
		
		return"redirect:./mypage";
	}
	
	@RequestMapping(value = "update", method =RequestMethod.GET)
	public ModelAndView update(HttpSession session)throws Exception{
		ModelAndView mv =new ModelAndView();
		MemberDTO memberDTO=(MemberDTO)session.getAttribute("member");
		memberDTO=memberService.mypage(memberDTO);
		mv.addObject("dto",memberDTO);
		mv.setViewName("member/update");
		
		return mv;
	}
	
	//mypage
	@RequestMapping(value = "mypage", method = RequestMethod.GET)
	public ModelAndView mypage(HttpSession session) throws Exception{
		ModelAndView mv =new ModelAndView();
		//object type                    id,pw 담겨있는 memberDTO
		MemberDTO memberDTO=(MemberDTO)session.getAttribute("member");
		memberDTO=memberService.mypage(memberDTO);
		mv.setViewName("member/mypage");
		mv.addObject("dto",memberDTO);
		
		return mv;
	}
	
	//logout
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception{
			session.invalidate();
			//session삭제 
			return "redirect:../";
	}
	
	
	// parameter :id pw remember (parameter는 전부 String)
	//login 
	//폼에서 id pw 입력-> parameter잖아 그걸 memberDTO로 선언한겨 
	//remember는  저장할지 안할지 여부 1-저장 
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(HttpSession session,MemberDTO memberDTO, String remember, Model model, HttpServletResponse response)
			throws Exception {

		System.out.println(remember);

		if (remember !=null&&remember.equals("1")) {
			// cookie 생성
			Cookie cookie = new Cookie("remember",memberDTO.getId());
			//remember=id1
			cookie.setMaxAge(-1);
			// 응답
			response.addCookie(cookie);
		}else {
			//쿠키 삭제 
			Cookie cookie = new Cookie("remember", "");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		memberDTO = memberService.login(memberDTO);
		//로그인하고 정보 memberDTO에 담았어 
		
		String path = "redirect:./login";
		if (memberDTO != null) {
			//로그인 했다면 
			session.setAttribute("member", memberDTO);
			session.setMaxInactiveInterval(60*60);
			//session에 "member"라는 이름으로 memberDTO 저장해 
			path = "redirect:../";
		}
		return path;
	}

	// login form이동
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void login(Model model,@CookieValue(value="remember",defaultValue="",required=false)String rememberId) throws Exception {
	//쿠키이름 "remember"인 쿠기의 값을  String rememberId 여따 담아 그리고 login.jsp ㄱ 
		
		//방법1 
		// model.addAttribute("rememberId", rememberId);
	}

	// 회원가입 
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(MemberDTO memberDTO) throws Exception {
		int result = memberService.join(memberDTO);
		return "redirect:../";
	}

	//회원가입 폼으로 이동 
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public void join() throws Exception {

	}

}
