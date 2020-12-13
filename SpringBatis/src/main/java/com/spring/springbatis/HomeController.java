package com.spring.springbatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {

    @Autowired
    private MemberMapper mapper;

    @RequestMapping("test")
    public String test(Model model) {
       //¿¹½Ã
        return "home";
    }

    @RequestMapping("insertMember")
    public String insertMember(@RequestParam("hakbun")String hakbun, @RequestParam("irum")String irum, @RequestParam("password")String password) {
        System.out.println("Insert! id = "+ hakbun );
        mapper.insertMember(new MemberDTO(hakbun, irum, password));
        return "test";
    }

}
