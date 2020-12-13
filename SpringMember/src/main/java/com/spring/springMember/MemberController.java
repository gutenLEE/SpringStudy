package com.spring.springMember;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	
	@Autowired
	private MemberServiceImpl memberService;
	
	@RequestMapping("/login.me")
	public MemberVO userCheck(MemberVO memberVO, HttpSession session, HttpServletResponse response) throws Exception{
		
		System.out.println( "from web => " + memberVO.toString());
		
		int res = memberService.userCheck(memberVO);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		PrintWriter writer = response.getWriter();
		
		if(res == 1) 
		{
			session.setAttribute("id", memberVO.getId());
			writer.write("<script> alert('login success'); " + "location.href='./main.me'; </script>");
			// redirect:/main.me
		}
		else {
			writer.write("<script> alert('login fail'); " + "location.href='./loginform.me'; </script>");
			// redirect:/inputform.me
		}
		return null;
	}
	
	@RequestMapping("/main.me")
	public String mainPage() throws Exception{
		return "main";
	}
	
	@RequestMapping("/loginform.me")
	public String loginform() throws Exception{
		return "loginForm";
	}
	
	
	// joinform
	@RequestMapping("/joinform.me")
	public String joinform() throws Exception{
		return "joinForm2";
	}
	
	

	@RequestMapping("/joinprocess.me")
	public String insertMember(MemberVO memberVO, HttpServletResponse response) throws Exception{
		
		System.out.println(" joinForm => " + memberVO.toString());

		int res = memberService.insertMember(memberVO);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8"); 
		
		PrintWriter writer = response.getWriter();
		
		if(res != 0) {
			writer.write("<script> alert('join success'); " + "location.href='./loginform.me'; </script>");
		}
		else {
			writer.write("<script> alert('join fail'); " + "location.href='./loginform.me'; </script>");
		}
		return "loginForm";
	}
	
	
	@RequestMapping("/memberlist.me")
	public String getMemberlist(Model model) throws Exception{
		
		ArrayList<MemberVO> member_list = memberService.getMemberlist();
		model.addAttribute("member_list", member_list);
		
		return "member_list";
	}
	
	@RequestMapping("/memberinfo.me")
	public String selectMember(MemberVO memberVO, Model model) throws Exception{
		
		MemberVO vo = memberService.selectMember(memberVO);
		model.addAttribute("memberVO", vo);
		
		return "member_info";
	}
	
	
	// 멤버 리스트로 redirect 해보기
	
	@RequestMapping("/deleteMember.me")
	public String deleteMember(@ModelAttribute MemberVO memberVO, Model model) throws Exception{
		
		memberService.deleteMember(memberVO);
		
		return "redirect:/memberlist.me";
	}
	
	
	
	@RequestMapping("/updateMember.me")
	public String updateMember(MemberVO memberVO, Model model) throws Exception{
		
		MemberVO vo = memberService.selectMember(memberVO);
		model.addAttribute("memberVO" , vo);
		
		return "updateform";
	}
	
	@RequestMapping("/updateProcess.me")
	public String updateProcess(MemberVO memberVO, Model model) throws Exception{
		System.out.println("수정 form => " + memberVO.toString());
		int res = memberService.updateMember(memberVO);
		
		return "redirect:/memberlist.me"; 
	}
	
	
	
	
	
	
}
