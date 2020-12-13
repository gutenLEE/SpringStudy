package com.spring.springBatis2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@Autowired
	private MemberServiceimpl memberService;

		// 시작 메인화면
		@RequestMapping("/index")
		public String main(Model model) {
			
			ArrayList<MemberVO> list = memberService.getJoinList();
			model.addAttribute("list", list);

			return "home";
		}
		


		@RequestMapping("/search")
		public ModelAndView search(@RequestParam(value="loc") String[] arr, @RequestParam(value="dept") String[] depts) {
			
			System.out.println(arr);
			System.out.println(Arrays.toString(arr));
		
//			for(String var : arr) {
//				System.out.println(var);
//			}
//
//			for(String var2 : depts) {
//				System.out.println(var2);
//			}
			
			HashMap<String, String[]> selectedKey = new HashMap<String, String[]>();
			selectedKey.put("loc", arr);
			selectedKey.put("dept", depts);
			
			System.out.println(Arrays.toString(selectedKey.get("loc")));
			
			ArrayList<MemberVO> list = memberService.dynamicSelect(selectedKey);
			
			ModelAndView  modelAndView = new ModelAndView();
			modelAndView.setViewName("result");
			modelAndView.addObject("list", list);
			
			
			return modelAndView;
		}
		
//		@RequestMapping(value = "/ajax",
//						method=RequestMethod.POST,
//						produces="application/json;charset=UTF-8")
//		@ResponseBody
//		public Map<String, Object> select(){
//			
//			Map<String, Object> retVal = new HashMap<String, Object>();
//		}
}
