package com.spring.springif;

import org.springframework.stereotype.Service;

@Service
public interface MemberService {
	
	public int loginCheck(String id, String pw);
	
}
