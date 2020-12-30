package com.spring.springif;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/index")
	public String index1() {
		
		return "index";
	}
	@RequestMapping("/index3")
	public String index3() {
		
		return "index3";
	}
	
	@RequestMapping("/index2")
	public String index2() {
		
		return "index2";
	}
	
	@RequestMapping("/login")
	public String login() {
		
		return "login";
	}
	
	@RequestMapping("/shop")
	public String shop() {
		
		return "shop";
	}
	
	/*
	 * 유희 login check ajax 
	 * */
	@RequestMapping("/loginCheck")
	@ResponseBody
	public String loginCheck(@RequestParam(value="id") String id, @RequestParam(value="pw") String pw) {
		
		System.out.println("login in");
		System.out.println(id);
		System.out.println(pw);
		
		int state = memberService.loginCheck(id, pw);
		
		if(state == 1) {
			return "pass";
		}
		else {
			return "unpass";
		}
	}
	
	@RequestMapping("/collection")
	public String collection() {
		
		return "collection";
	}
	
	@RequestMapping("/blog")
	public String blog() {
		
		return "blog";
	}
	
	@RequestMapping("/contact")
	public String contact() {
		
		return "contact";
	}
	
	@RequestMapping("/shopping-cart")
	public String shoppingcart() {
		
		return "shopping-cart";
	}
	
	@RequestMapping("/main")
	public String main() {
		
		return "main";
	}
	
	@RequestMapping("/blog-details")
	public String blogdetails() {
		
		return "blog-details";
	}
	
	@RequestMapping("/chek-out")
	public String chekout() {
		
		return "chek-out";
	}
	
	@RequestMapping("/faq")
	public String faq() {
		
		return "faq";
	}
	
	@RequestMapping("/register")
	public String register() {
		
		return "register";
	}
}