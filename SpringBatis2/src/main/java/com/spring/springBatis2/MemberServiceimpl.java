package com.spring.springBatis2;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mapper.MemberMapper;

@Service
public class MemberServiceimpl implements MemberService{
	
	@Autowired
	private SqlSession sqlSession;
	
	MemberMapper memberMapper = null;
	   
   @Autowired
   public MemberServiceimpl(SqlSession sqlSession) {
        this.memberMapper = sqlSession.getMapper(MemberMapper.class);
    }

	@Override
	public ArrayList<MemberVO> getJoinList() {
		
		ArrayList<MemberVO> joinList = memberMapper.getJoinList();
		
		return joinList;
	}

	@Override
	public ArrayList<MemberVO> dynamicSelect(HashMap<String, String[]> selectedKey ) {
		
			ArrayList<MemberVO> list = new ArrayList<MemberVO>();
			list = memberMapper.dynamicSelect(selectedKey);
			
			System.out.println("list »çÀÌÁî => " + list.size());
			
		return list;
	}
	

}
