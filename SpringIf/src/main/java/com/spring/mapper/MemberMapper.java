package com.spring.mapper;

import org.apache.ibatis.annotations.Param;

public interface MemberMapper {
	
	public int loginCheck(@Param("id") String id, @Param("pw") String pw);
	
}
