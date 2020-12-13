package com.spring.springSungjuk;

import java.util.ArrayList;
import java.util.Optional;

public interface SungjukService {
	
	public int insertJoin(SungjukVO vo);
	public int insertSungjuk(SungjukVO vo);
	
	public int userCheck(SungjukVO vo);
	
	public ArrayList<SungjukVO> getSungjukAll();
	public ArrayList<SungjukVO> getStudnetAll();
	public Optional<SungjukVO> selectByHakbun(String hakbun);
	
	public int deleteSungjuk(String hakbun);
	public int updateSungjuk(SungjukVO vo);
}
