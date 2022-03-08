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
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/member/*")
public class MemberController {

	@Autowired
	private MemberService memberService;

	//mypage
	@RequestMapping(value = "mypage", method = RequestMethod.GET)
	public ModelAndView mypage(HttpSession session) throws Exception{
		ModelAndView mv =new ModelAndView();
		//object type 
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
			return "redirect:../";
	}
	
	
	// parameter :id pw remember (parameter는 전부 String)
	//login 
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(HttpSession session,MemberDTO memberDTO, String remember, Model model, HttpServletResponse response)
			throws Exception {

		System.out.println(remember);

		if (remember !=null&&remember.equals("1")) {
			// cookie 생성
			Cookie cookie = new Cookie("remember",memberDTO.getId());
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
		
//		String path = "redirect:./login";
//		
//		if (memberDTO != null) {
//			//로그인 했다면 
//			session.setAttribute("member", memberDTO);
//			//session에 "member"라는 이름으로 memberDTO 저장해 
//			path = "redirect:../";
//		}
		String message="Login Fail";
		String p="./login";
		
		if(memberDTO !=null) {
			session.setAttribute("member", memberDTO);
			message="Login Success";
			p="../";
		}
		model.addAttribute("message",message);
		model.addAttribute("path",p);
		String path="common/result";
		return path;
	}

	// login form이동
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void login(Model model,@CookieValue(value="remember",defaultValue="",required=false)String rememberId) throws Exception {
		//방법1 
		// model.addAttribute("rememberId", rememberId);
	}

	// insert
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(MemberDTO memberDTO) throws Exception {
		int result = memberService.join(memberDTO);
		return "redirect:../";
	}

	@RequestMapping(value = "join", method = RequestMethod.GET)
	public void join() throws Exception {
		
	}
	@RequestMapping(value = "joinCheck", method = RequestMethod.GET)
	public void joinCheck() throws Exception{
		
	}

}
