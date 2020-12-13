package com.emp.ajax2;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mapper.EmpMapper;

@Service("MemberService")
public class MemberServiceImpl implements MemberService {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<EmpVO> getMembers() {
		List<EmpVO> member_list = null;
		EmpMapper memberMapper = sqlSession.getMapper(EmpMapper.class);
		member_list = memberMapper.getMembers();
		return member_list;
	}




}
