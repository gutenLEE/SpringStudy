package com.spring.springMember;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.mapper.MemberMapper;

public class MemberMapperTest {

	public static void main(String[] args) {
		
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		
		MemberMapper dao = context.getBean("MemberMapper", MemberMapper.class);
		
		for(MemberVO vo : dao.getMemberlist()) {
			System.out.println(vo.toString());
		}
	}

}
