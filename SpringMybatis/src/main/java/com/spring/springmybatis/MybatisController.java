package com.spring.springmybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MybatisController {
	
	@Autowired
	private MemberServiceImpl memberService;
	
	// 시작 메인화면
	@RequestMapping("/list.do")
	public ModelAndView main( ) {
		
		//  view 화면인 main.jsp에 db로부터 읽어온 데이터를 보여준다.
		ModelAndView result = new ModelAndView();
		
		// addObject view에 넘어가는 데이터
		List<MemberVO> memberlist = memberService.getMembers(); 
		
		result.addObject("memberlist",memberlist);
		result.setViewName("list");
		
		return result;
	}
	
	// insert 버튼 클릭시 값을 가져와서 list.jsp로 화면전환 해준다.
	@RequestMapping("/insert.do")
	public ModelAndView insert(MemberVO	member) {
		
		/*
		 HashMap<String, String> map = new HashMap<String, String>();
		 map.put("id", member.getId());
		 map.put("name", member.getName());
		 map.put("email", member.getEmail());
		 map.put("phone", member.getPhone());
		 memberService.insertMember2(map);
		 */
		
		memberService.insertMember(member);
		
		ModelAndView result = new ModelAndView();
		List<MemberVO> memberList = memberService.getMembers();
		
		result.addObject("memberlist", memberList);
		result.setViewName("list");
		
		return result;
	}
	
	@RequestMapping("/updateForm.do")
	public ModelAndView updateForm(MemberVO	member) {
		
		System.out.println(member.toString());
		
		
		String id = member.getId();
		member = memberService.getMember(id);
		
		
		System.out.println( "after select > " +  member.toString());
		
		System.out.println("updateForm complete");
		
		ModelAndView result = new ModelAndView();
		result.addObject("member", member);
		result.setViewName("updateForm");
		return result;
	}
	
	/*
	 	@RequestMapping("/update.do")
	 	public ModelAndView update(MemberVO member){
	 		
	 		memberService.updateMember(member);
	 		System.out.println("update complete");
	 		
	 		ModelAndView result = new ModelAndView();
	 		List<MemberVO> memberList = memberService.getMembers();
	 		result.addObject("memberList", memberList);
	 		result.setViewName("list");
	 		return result;
	 	}
	 */
	
 	@RequestMapping("/update.do")
 	public String update(MemberVO member){
 		
 		System.out.println( member.toString() );
 		memberService.updateMember(member);
 		
 		ModelAndView result = new ModelAndView();
 		System.out.println("update complete");
 		
 		return "redirect:/list.do";
 	}
 	
 	@RequestMapping("/delete.do")
 	public ModelAndView delete(MemberVO member){
 		
 		String id = member.getId();
 		memberService.deleteMember(id);
 		
 		System.out.println("delete complete");
 		
 		ModelAndView result = new ModelAndView();
 		
 		List<MemberVO> memberList = memberService.getMembers();
 		
 		result.addObject("memberlist", memberList);
 		result.setViewName("list");
 		
 		return result;
 	}
 	
	/*
 	@RequestMapping("/update.do")
 	public String update(MemberVO member){
 		
 		memberService.updateMember(member);
 		System.out.println("update complete");
 		
 		return "redirect:/list.do";
 	}
 */
}
