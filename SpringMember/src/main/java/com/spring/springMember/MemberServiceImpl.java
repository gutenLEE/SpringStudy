package com.spring.springMember;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private SqlSession sqlSession; // myBatis 라이브러리가 제공하는 클래스
	
	
/*
 
	MemberMapper memberMapper = null;
   
   	@Autowired
    public MemberServiceImpl(SqlSession sqlSession) {
        this.memberMapper = sqlSession.getMapper(MemberMapper.class);
    }
    
 */

	@Override
	public int insertMember(MemberVO member) {
		
		 MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
			
		int res = memberMapper.insertMember(member);
		
		if(res == 1) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
	@Override
	public int userCheck(MemberVO memberVO) {
		
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		MemberVO vo = memberMapper.selectMember(memberVO);
		
		if(vo.getPassword().equals(memberVO.getPassword())) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
	@Override
	public ArrayList<MemberVO> getMemberlist() {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		
		ArrayList<MemberVO> member_list = new ArrayList<MemberVO>();
		member_list = memberMapper.getMemberlist();
		return member_list;
	}

	@Override
	public MemberVO selectMember(MemberVO memberVO) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		MemberVO vo = memberMapper.selectMember(memberVO);
		return vo;
	}

	@Override
	public int deleteMember(MemberVO memberVO) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);	
		int res = memberMapper.deleteMember(memberVO);
		return res;
	}

	@Override
	public int updateMember(MemberVO memberVO) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		int res = memberMapper.updateMember(memberVO);
		return res;
	}
	
	
}
	
