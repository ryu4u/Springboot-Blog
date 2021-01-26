package com.cooleye.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {

	@GetMapping("/temp/html")
	public String tempHtml() {
		System.out.println("tempHtml()");
		return "/home.html";
	}
	
	@GetMapping("/temp/jsp")
	public String tmpJsp() {
		// prefix: /WEB-INF/views/
	    // suffix: .jsp
		//풀네임 : /WEB-INF/views/test.jsp
		return "test";
	}
}
