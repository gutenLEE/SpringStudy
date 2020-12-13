package com.emp.ajax2;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/index.me", method = RequestMethod.GET)
	public String home() {
		return "index";
	}
	@RequestMapping(value = "/getEmpJSON.me", produces="application/json; charset=utf-8")
	@ResponseBody
	public List<EmpVO> getMembers() {
		System.out.println("AAAAAAAAAAAAAAAAAA");
		List<EmpVO> list = memberService.getMembers();
		System.out.println("AAAA"+list.size());
		return list;
	}
	@RequestMapping(value = "/setEmpJSON.me", produces="application/json; charset=utf-8")
	@ResponseBody
	public List<EmpVO> setMembers() {
		System.out.println("AAAAAAAAAAAAAAAAAA");
		List<EmpVO> list = memberService.getMembers();
		System.out.println("AAAA"+list.size());
		return list;
	}


}
