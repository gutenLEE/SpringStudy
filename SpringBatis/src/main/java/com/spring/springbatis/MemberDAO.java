package com.spring.springbatis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberDAO {

    @Autowired
    private SqlSession session;


    public void memberInsert(MemberDTO member) {
         session.insert("com.spring.springBatis.mapper.MemberMapper.insertMember",member);
    }
}