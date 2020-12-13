package com.spring.springbatis;

import java.util.List;

public interface MemberMapper {
    public List<MemberDTO> viewAll();
    public void insertMember(MemberDTO dto);
}