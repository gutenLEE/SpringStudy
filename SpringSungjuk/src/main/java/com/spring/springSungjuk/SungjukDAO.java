package com.spring.springSungjuk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import com.spring.springSungjuk.JDBCUtil;

@Repository
public class SungjukDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public int insertJoin(SungjukVO vo) {
		
		int result = 0;
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = conn.prepareStatement("insert into student values(?, ?, ?)");
			
			System.out.println(vo.getHakbun() + vo.getPassword());
			
			pstmt.setString(1, vo.getHakbun());
			pstmt.setString(2, vo.getIrum());
			pstmt.setString(3, vo.getPassword());
		
			result = pstmt.executeUpdate();
			
			System.out.println("result >> " + result);
		}
		catch(Exception e) {
			System.out.println("가입 오류" + e.getMessage());
			e.printStackTrace();
		}
		finally {
			JDBCUtil.closeResource(conn, pstmt, rs);
		}
		
		return result;
	}
	
	public int insertSungjuk(SungjukVO vo) {
		
		int result = 0;
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = conn.prepareStatement("insert into student_sungjuk values(?, ?, ?, ?, ?, ?, ?)");
			
			System.out.println(vo.getHakbun());
			
			pstmt.setString(1, vo.getHakbun());
			pstmt.setInt(2, vo.getKor());
			pstmt.setInt(3, vo.getEng());
			pstmt.setInt(4, vo.getMath());
			pstmt.setInt(5, vo.getTot());
			pstmt.setDouble(6, vo.getAvg());
			pstmt.setString(7, vo.getGrade());
			
			result = pstmt.executeUpdate();
			
			System.out.println("result >> " + result);
		}
		catch(Exception e) {
			System.out.println("가입 오류" + e.getMessage());
			e.printStackTrace();
		}
		finally {
			JDBCUtil.closeResource(conn, pstmt, rs);
		}
		
		return result;
	}


	public int userCheck(SungjukVO vo) {
		
		String dbpasswd = "";
		
		int x = -1;
	
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = conn.prepareStatement("select * from student where hakbun = ?");
			pstmt.setInt(1, Integer.parseInt(vo.getHakbun()));
			rs = pstmt.executeQuery();

			if(rs.next()) {
				
				dbpasswd = rs.getString("password");

				if(dbpasswd.equals(vo.getPassword())) {
					System.out.println("일치");
					x = 1;
				}
				else {
					System.out.println("불일치");
					x = 0; 
				}
			}
			else
				x = -1;	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtil.closeResource(conn, pstmt, rs);
		}
		return x;
	}


	public ArrayList<SungjukVO> getSungjukAll() {
		
		ArrayList<SungjukVO> list = new ArrayList<SungjukVO>();
		SungjukVO vo = null;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement("select * from student a, student_sungjuk b where a.hakbun = b.hakbun");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				vo = new SungjukVO();
				
				vo.setIrum(rs.getString("irum"));
				vo.setHakbun(Integer.toString(rs.getInt("hakbun")));
				vo.setKor(rs.getInt("kor"));
				vo.setEng(rs.getInt("eng"));
				vo.setMath(rs.getInt("math"));
				vo.setTot(rs.getInt("tot"));
				vo.setAvg(rs.getInt("avg"));
				vo.setGrade(rs.getString("grade"));
				System.out.println(vo.toString());
				list.add(vo);
			}
			return list;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtil.closeResource(conn, pstmt, rs);
		}
		return list;
	}
	
	public ArrayList<SungjukVO> getStudentAll(){
		
		SungjukVO StudentVO = null;
		ArrayList<SungjukVO> student = null;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement("select * from student where hakbun != 1001 order by irum");
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				student = new ArrayList<SungjukVO>();
				
				do
				{
					StudentVO = new SungjukVO();
					StudentVO.setHakbun(Integer.toString(rs.getInt("hakbun")));
					StudentVO.setIrum(rs.getString(2));
					
					student.add(StudentVO);
					System.out.println("arryalist size >> " + student.size());
				}
				while(rs.next());
				
				return student;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtil.closeResource(conn, pstmt, rs);
		}
		return student;
	}


	public Optional<SungjukVO> selectByHakbun(String hakbun) {
		
		SungjukVO vo = null;
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement("select * from student a, student_sungjuk b where b.hakbun = ? and  a.hakbun = b.hakbun");
			
			pstmt.setInt(1, Integer.parseInt(hakbun));
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				vo = new SungjukVO();
				vo.setIrum(rs.getString("irum"));
				// 데이터 담아주기
				vo.setHakbun(Integer.toString(rs.getInt("hakbun")));

				vo.setKor(rs.getInt("kor"));
				vo.setEng(rs.getInt("eng"));
				vo.setMath(rs.getInt("math"));
				vo.setGrade(rs.getString("grade"));
				vo.getGradeProcess();
				
				return Optional.of(vo);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtil.closeResource(conn, pstmt, rs);
		}
		return Optional.empty();
	}


	public int deleteSungjuk(String hakbun) {

		int result = 0;
		int result2 = 0;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement("delete from student_sungjuk where hakbun = ?");
			pstmt.setString(1, hakbun);
			result = pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("delete from student where hakbun = ?");
			pstmt.setString(1, hakbun);
			result2 = pstmt.executeUpdate();
			
			if(result == 1 && result2 == 1) {
				return result;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtil.closeResource(conn, pstmt, rs);
		}
		return 0;

	}


	public int updateSungjuk(SungjukVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
