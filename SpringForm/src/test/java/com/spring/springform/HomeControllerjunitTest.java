package com.spring.springform;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.junit.Test;

public class HomeControllerjunitTest {
	
	public static HomeControllerjunitTest db = new HomeControllerjunitTest();
	
	public static void main(String[] args) throws Exception{
		db.testConnection();
	}

	@Test
	public void testConnection() throws Exception{
		
		Connection con = null;
		PreparedStatement pstmt = null;
		System.out.println("1");
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String sql = "insert into emp_copy (empno,ename,job,mgr,hiredate,sal,comm,deptno) values (?, ?, ?, ?, sysdate, ?, ?, ?)";
			
			Class.forName(driver);
			System.out.println("2");
			
			con = DriverManager.getConnection(url, "scott", "123456");
	
			System.out.println("DriverManager.getConnection okay");
			
			pstmt = con.prepareStatement(sql);
			System.out.println("pstmt >>" + pstmt);
			System.out.println("con.prepareStatement(sql) okay");
			
			
			pstmt.setInt(1, 1);
			pstmt.setString(2, "1");
			pstmt.setString(3, "1");
			pstmt.setInt(4, 1);
			pstmt.setDouble(5, 111);
			pstmt.setDouble(6, 111);
			pstmt.setInt(7, 111);
			pstmt.executeUpdate();
			
			System.out.println("3");
		}
		catch(Exception e) {
		}
		
		
	}
}