package com.spring.springSungjuk;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sungjukService")
public class SungjukServiceimpl implements SungjukService {
	
	@Autowired(required=false)
	private SungjukDAO sungjukDAO = null;

	@Override
	public int insertJoin(SungjukVO vo) {
		
		int result = sungjukDAO.insertJoin(vo);
	
		return result;
	}
	
	
	
	@Override
	public int insertSungjuk(SungjukVO vo) {
		int result = sungjukDAO.insertSungjuk(vo);
		return result;
	}



	@Override
	public int userCheck(SungjukVO vo) {
		
		int result = sungjukDAO.userCheck(vo);
		System.out.println("sevice usercheck result >> " + result);
		
		return result;
	}

	@Override
	public ArrayList<SungjukVO> getSungjukAll() {
		ArrayList<SungjukVO> list = sungjukDAO.getSungjukAll();
		return list;
	}
	
	

	@Override
	public ArrayList<SungjukVO> getStudnetAll() {
		ArrayList<SungjukVO> list = sungjukDAO.getStudentAll();
		return list;
	}

	@Override
	public Optional<SungjukVO> selectByHakbun(String hakbun) {
		
		Optional<SungjukVO> sungjukVO = sungjukDAO.selectByHakbun(hakbun);
		
		return sungjukVO;
	}

	@Override
	public int deleteSungjuk(String hakbun) {
		
		int res = sungjukDAO.deleteSungjuk(hakbun);
		
		
		
		
		return res;
	}

	@Override
	public int updateSungjuk(SungjukVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}


}
