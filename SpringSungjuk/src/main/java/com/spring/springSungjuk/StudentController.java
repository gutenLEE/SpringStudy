package com.spring.springSungjuk;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class StudentController {
	
	@Autowired
	private SungjukService sungjukService;
	
	@RequestMapping(value = "/login.me")
	public String home(Locale locale, Model model) {
		return "login";
	}
	
	@RequestMapping(value="loginProcess.me")
	public String loginProcess(SungjukVO vo, Model model, HttpServletRequest request) {
		
		int result = sungjukService.userCheck(vo);
		
		if(result == 1) {
			
			// 로그인 성공 -> 세션에 학번 저장.
			HttpSession session = request.getSession();
			
			String hakbun = vo.getHakbun();
			session.setAttribute("hakbun", hakbun);
			
			// admin
			if(vo.getHakbun().equals("1001")) {

				return "adminPage";
			}
			// 학생
			else {
				
				Optional<SungjukVO> sungjuk = sungjukService.selectByHakbun(hakbun);
				model.addAttribute("sungjuk", sungjuk);
				
				return "student_page";				
			}
		}
		// 로그인 실패
		else {
			System.out.println("login_flag >>> " + result);
			
			model.addAttribute("login_flag", result);
			return "redirect:/login.me";
		}
		
	}
	
	@RequestMapping(value = "/joinform.me")
	public String joinform(SungjukVO vo, Model model) {
		
		return "joinform";
	}
	
	@RequestMapping(value = "/joinProcess.me")
	public String joinProcess(SungjukVO vo, Model model) {
		
		System.out.println("학번 >> " + vo.getHakbun());
		int result = sungjukService.insertJoin(vo);
		model.addAttribute("hakbun", vo.getHakbun());
		
		return "login";
	}
	
	@RequestMapping(value = "member_sungjuk.me")
	public String memberSungjuk(SungjukVO sungjukVO, Model model, HttpSession session) {
		
		System.out.println("controller 학번 >>> " + session.getAttribute("hakbun"));
		
		String hakbun = (String) session.getAttribute("hakbun");
		
		Optional<SungjukVO> sungjuk = sungjukService.selectByHakbun(hakbun);
		
		model.addAttribute("sungjuk", sungjuk);
		model.addAttribute("hakbun", hakbun);
		
		return "member_sungjuk";
	}
	
	@RequestMapping(value="adminMenu.me")
	public String adminMenu(Model model) {
		
		ArrayList<SungjukVO> studentList = sungjukService.getStudnetAll();
		
		model.addAttribute("student", studentList);
		
		return "admin_menu";
	}
	
	@RequestMapping(value="adminInsert.me")
	public String adminInsert(Model model) {
		return "admin_insert";
	}
	
	@RequestMapping(value="insertProcess.me")
	public String insertProcess(SungjukVO vo, Model model) {
		
		return "redirect:admin_menu";
	}
	
	@RequestMapping(value="sungjukForm.me")
	public String sungjukForm(HttpServletRequest request, Model model) {
		
		String irum = request.getParameter("irum");
		String hakbun = request.getParameter("hakbun");
		
		model.addAttribute("irum", irum);
		model.addAttribute("hakbun", hakbun);
		
		
		return "sungjukForm";
	}
	@RequestMapping(value="sungjukProcess.me")
	public String sungjukProcess(SungjukVO vo) {
		
		vo.getGradeProcess();
		int result = sungjukService.insertSungjuk(vo);
		
		return "redirect:/adminMenu.me";
	}
	
	@RequestMapping(value = "adminSelect.me")
	public String memberSungjuk(SungjukVO sungjukVO, Model model, HttpServletRequest request) {
		
		String hakbun = request.getParameter("hakbun");
		Optional<SungjukVO> sungjuk = sungjukService.selectByHakbun(hakbun);
		
		model.addAttribute("sungjuk", sungjuk);
		model.addAttribute("hakbun", hakbun);
		
		return "member_sungjuk";
	}
	
	@RequestMapping(value = "adminDelete.me")
	public String adminDelete(HttpServletRequest request) {
		
		String hakbun = request.getParameter("hakbun");
		int res = sungjukService.deleteSungjuk(hakbun);
		
		return "redirect:/adminMenu.me";
	}
	
	@RequestMapping(value="selectAll.me")
	public String getSungjukAll(Model model) {
		
		ArrayList<SungjukVO> vo = sungjukService.getSungjukAll();
		model.addAttribute("sungjuk", vo);
		
		return "sungjukList";
	}
}
