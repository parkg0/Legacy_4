package com.google.s1.notice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value = "/notice/*")
public class NoticeController {

	
	@RequestMapping(value = "")
	public void list() {
		
	}
}
