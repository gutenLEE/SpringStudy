package com.spring.mb2replay.member;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mapper.MemberMapper;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	
	MemberMapper memberMapper = null;
	   
   @Autowired
    public MemberServiceImpl(SqlSession sqlSession) {
        this.memberMapper = sqlSession.getMapper(MemberMapper.class);
   }    
	
	@Override
	public int insertMember(MemberVO memberVO) {
		int res  = memberMapper.insertMember(memberVO); 
		
		return res;
	}

	@Override
	public int userCheck(MemberVO memberVO) {
		MemberVO vo  = memberMapper.selectMember(memberVO); 
		if(memberVO.getPassword().equals(vo.getPassword())) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public ArrayList<MemberVO> getMemberlist() {
		ArrayList<MemberVO> member_list = new ArrayList<MemberVO>();
		member_list = memberMapper.getMemberlist();
	
		return member_list;
	}

	@Override
	public MemberVO selectMember(MemberVO memberVO) {
		MemberVO vo  = memberMapper.selectMember(memberVO);
			
		return vo;
	}

	@Override
	public int deleteMember(MemberVO memberVO) {
		int res = memberMapper.deleteMember(memberVO); 
		
		return res;
	}

}
