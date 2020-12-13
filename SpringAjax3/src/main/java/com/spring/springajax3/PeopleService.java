package com.spring.springajax3;

import java.util.List;

public interface PeopleService {
	
	List<PeopleVO> getPeoplejson();
	void insertPeople(PeopleVO vo);
	void deletePeople(String id);
}
