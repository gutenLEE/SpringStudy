package com.spring.springMember;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;


public class MemberDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	
	public int insertMember(MemberVO membervo) {
		int result = 0;
		
		System.out.println("insertMember(MemberVO membervo)");
	
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = conn.prepareStatement("insert into smember values(?, ?, ?, ?, ?, ?)");
			
			System.out.println(membervo.getId() + membervo.getPassword() + membervo.getName() + membervo.getAge() + membervo.getGender() + membervo.getEmail());
			
			
			pstmt.setString(1, membervo.getId());
			pstmt.setString(2, membervo.getPassword());
			pstmt.setString(3, membervo.getName());
			pstmt.setInt(4, membervo.getAge());
			pstmt.setString(5, membervo.getGender());
			pstmt.setString(6, membervo.getEmail());
			
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
	
	
	public int userCheck(MemberVO membervo) {
		
		String dbpasswd = "";
		
		int x = -1;
	
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = conn.prepareStatement("select * from smember where id = ?");
			
			pstmt.setString(1, membervo.getId());
			rs = pstmt.executeQuery();
			
			System.out.println("rs >>>>>>>>>>>>>>>>>>>          "  + rs);
			
			if(rs.next()) {
				dbpasswd = rs.getString("password");
				System.out.println("db pw >> " + rs.getString("password") );
				
				if(dbpasswd.equals(membervo.getPassword()))
					x = 1;
				else
					x = 0; 
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
	
	public ArrayList<MemberVO> getMemberlist(){
		MemberVO vo = null;
		ArrayList<MemberVO> member_list = null;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement("select * from smember order by id");
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member_list = new ArrayList<MemberVO>();
				do
				{
					vo = new MemberVO();
					vo.setId(rs.getString(1));
					vo.setPassword(rs.getString(2));
					vo.setName(rs.getString(3));
					vo.setAge(rs.getInt(4));
					vo.setGender(rs.getString(5));
					vo.setEmail(rs.getString(6)); 
					
					member_list.add(vo);
				}
				while(rs.next());
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtil.closeResource(conn, pstmt, rs);
		}
		return member_list;
	}
	
	
	
	
	public MemberVO selectMember(MemberVO memberVO)
	{
		MemberVO vo = null;
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement("select * from smember where id = ?");
			
			pstmt.setString(1, memberVO.getId());
			rs = pstmt.executeQuery();
			rs.next();
			
			vo = new MemberVO();
			vo.setId(rs.getString(1));
			vo.setPassword(rs.getString(2));
			vo.setName(rs.getString(3));
			vo.setAge(rs.getInt(4));
			vo.setGender(rs.getString(5));
			vo.setEmail(rs.getString(6));
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtil.closeResource(conn, pstmt, rs);
		}
		return vo;
	}	
	
	
	public int deleteMember(MemberVO memberVO) {
		
		int result = 0;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement("delete from smember where id = ?");
			pstmt.setString(1, memberVO.getId());
			result = pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtil.closeResource(conn, pstmt, rs);
		}
		return result;
	}
	
	
	
	
	public int updateMember(MemberVO memberVO) {
		
		int result = 0;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement("update  smember set name = ?, gender = ?, email = ?  where id = ?");
			pstmt.setString(1, memberVO.getName());
			pstmt.setString(2, memberVO.getGender());
			pstmt.setString(3, memberVO.getEmail());
			pstmt.setString(4, memberVO.getId());
			result = pstmt.executeUpdate();
			
			System.out.println("result >> " + result);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtil.closeResource(conn, pstmt, rs);
		}
		return result;
		
	}
	
	
	
	
	
	
	
	
	
}
