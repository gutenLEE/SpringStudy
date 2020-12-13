package com.spring.mapper;

import java.util.ArrayList;

import com.spring.springMember.MemberVO;

public interface MemberMapper {
	
	int insertMember(MemberVO member);
	MemberVO userCheck(MemberVO member);
	ArrayList<MemberVO> getMemberlist();
	MemberVO selectMember(MemberVO member);
	int deleteMember(MemberVO member);
	int updateMember(MemberVO memebr);
}
