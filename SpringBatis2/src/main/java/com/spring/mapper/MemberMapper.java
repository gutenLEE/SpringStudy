package com.spring.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import com.spring.springBatis2.MemberVO;

public interface MemberMapper {
	
	ArrayList<MemberVO> getJoinList();	ArrayList<MemberVO> dynamicSelect(HashMap<String, String[]> keys);
}
	
	
	
	
	
	
	
	