package com.spring.springtest2;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class TestController {
	
	@RequestMapping(value="input_form.bo")
	public String input() {
		return "input_form";
	}
	@RequestMapping(value="input.bo", method = RequestMethod.POST)
	public String res(LoginVo vo, Model model) {
		
		String id = vo.getId();
		String pw = vo.getPw();
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		return "res";
	}
	
	@RequestMapping(value="join")
	public String join() {
		return "join_from";
	}
	
	@RequestMapping(value="joinForm", method = RequestMethod.POST)
	public String res(memberVO vo, Model model) {
		
		String id = vo.getId();
		String pw = vo.getPw();
		String jumin = vo.getJumin();
		String gender = vo.getGender();
		String phone = vo.getPhone();
		String email = vo.getEmail();
		String hobby = vo.getHobby();
		String introduce =  vo.getIntroduce();
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("jumin", jumin);
		model.addAttribute("gender", gender);
		model.addAttribute("phone", phone);
		model.addAttribute("email", email);
		model.addAttribute("hobby", hobby);
		model.addAttribute("introduce", introduce);
		
		return "inputForm";
	}

}


/*
@RequestMapping(value="input.bo", method = RequestMethod.POST)
public ModelAndView res(HttpServletRequest request, Model model) {
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	mav.addObject("id", id);
	mav.addObject("pw", pw);
	mav.setViewName("res");
	return mav;
}
*/

/*
@RequestMapping(value="input.bo", method = RequestMethod.POST)
public String res(HttpServletRequest request, Model model) {
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	model.addAttribute("id", id);
	model.addAttribute("pw", pw);
	
	return "res";
}
*/
