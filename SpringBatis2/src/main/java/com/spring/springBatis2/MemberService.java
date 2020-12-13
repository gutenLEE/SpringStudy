package com.spring.springBatis2;

import java.util.ArrayList;
import java.util.HashMap;

public interface MemberService {
	
	ArrayList<MemberVO> getJoinList();
	ArrayList<MemberVO> dynamicSelect(HashMap<String, String[]> selectedKey );
}
