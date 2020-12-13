package com.spring.springform;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class HomeController {
	
	// get, post method 생략하면 둘 다 사용 가능하다는 뜻.
	
	@RequestMapping(value = "inputForm.me")
	public String inputForm() {
		return "inputform";
	}
	@RequestMapping(value="inputProcess.me")
	public String inputProcess(EmpVO vo) {
		
		
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
			
			pstmt = con.prepareStatement(sql);
			
			
			pstmt.setInt(1, vo.getEmpno());
			pstmt.setString(2, vo.getEname());
			pstmt.setString(3, vo.getJob());
			pstmt.setInt(4, vo.getMgr());
			pstmt.setDouble(5, vo.getSal());
			pstmt.setDouble(6, vo.getComm());
			pstmt.setInt(7, vo.getDeptno());
			pstmt.executeUpdate();
			
			System.out.println("3");
		}
		catch(Exception e) {
		}
		return "index";
	}
	
	@RequestMapping(value="selectProcess.me")
	public String selectProcess(Model model) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<EmpVO> list = new ArrayList<EmpVO>(); 
		
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "123456");
		
			pstmt = con.prepareStatement("select * from emp_copy order by ename asc");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				EmpVO empvo = new EmpVO();
				empvo.setEmpno(rs.getInt(1));
				empvo.setEname(rs.getString(2));
				empvo.setJob(rs.getString(3));
				empvo.setMgr(rs.getInt(4));
				empvo.setHiredate(rs.getDate(5));
				empvo.setSal(rs.getDouble(6));
				empvo.setComm(rs.getDouble(7));
				empvo.setDeptno(rs.getInt(8));
				
				list.add(empvo);
			}
			model.addAttribute("list", list); // 모델을 직접 객체 생성할 수 없다.  그래서 파라미터로 model 객체를 전달 받는 것이다. 
		}
		catch(Exception e) {
		}
		return "list";
	}
	
	@RequestMapping(value="selectDept.me")
	public String selectDept(Model model, @RequestParam(value="deptno" , required=false, defaultValue="1") int deptno) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DeptVO deptvo = null;
		
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "123456");
		
			pstmt = con.prepareStatement("select * from emp_copy where deptno = ?");
			pstmt.setInt(1,  deptno);
			rs = pstmt.executeQuery();
			rs.next();
			
			deptvo = new DeptVO();
			deptvo.setDeptno(rs.getInt("deptno"));
			deptvo.setDname(rs.getString("dname"));
			deptvo.setLoc(rs.getString("loc"));
			
			model.addAttribute("deptvo", deptvo);
		}
		catch(Exception e) {
		}
		return "deptview";
	}
	
	@RequestMapping(value="deletee.me")
	public String deletee(Model model, @RequestParam(value="empno" , required=false, defaultValue="1") int empno) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmpVO empvo = null;
		
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "123456");
		
			pstmt = con.prepareStatement("delete from emp_copy where empno = ?");
			pstmt.setInt(1,  empno);
			pstmt.executeUpdate();
			
			model.addAttribute("empno", empno);
		}
		catch(Exception e) {
		}
		return "redirect:selectProcess.me";
	}
	
	

	
	@RequestMapping(value="selectEmpDept.me")
	public String selectEmpDept(Model model) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<EmpDeptVo> list2 = new ArrayList<EmpDeptVo>(); 
		
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "123456");
		
			pstmt = con.prepareStatement(" select emp.empno, emp.ename, emp.job, emp.deptno, dept.dname, dept.loc from emp_copy emp,  dept_copy dept where emp.deptno = dept.deptno order by emp.ename asc");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				EmpDeptVo empDeptvo = new EmpDeptVo();
				empDeptvo.setEmpno(rs.getInt(1));
				empDeptvo.setEname(rs.getString(2));
				empDeptvo.setJob(rs.getString(3));
				empDeptvo.setDeptno(rs.getInt(4));
				empDeptvo.setDname(rs.getString(5));
				empDeptvo.setLoc(rs.getString(6));
			
				list2.add(empDeptvo);
			}
			model.addAttribute("list2", list2); // 모델을 직접 객체 생성할 수 없다.  그래서 파라미터로 model 객체를 전달 받는 것이다. 
		}
		catch(Exception e) {
		}
		return "list2";
	}
	
	@RequestMapping(value="delete2.me")
	public String deletee(Model model, HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		                                                       
		String empno = request.getParameter("empno");
		System.out.println("empno >> " + empno);
		
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "123456");
		
			pstmt = con.prepareStatement("delete from emp_copy where empno = ?");
			pstmt.setInt(1,  Integer.parseInt(empno));
			pstmt.executeUpdate();
			
		}
		catch(Exception e) {
		}
		return "redirect:selectEmpDept.me";
	}
	
	
	@RequestMapping(value="selectUpdate.me")
	public String selectUpdate(Model model, @RequestParam(value="empno" , required=false, defaultValue="1") int empno) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmpVO empvo = null;
		
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "123456");
		
			pstmt = con.prepareStatement("select * from emp_copy where empno = ?");
			pstmt.setInt(1,  empno);
			rs = pstmt.executeQuery();
			rs.next();
			
			empvo = new EmpVO();
			
			empvo.setEmpno(rs.getInt(1));
			empvo.setEname(rs.getString(2));
			empvo.setJob(rs.getString(3));
			empvo.setMgr(rs.getInt(4));
			empvo.setHiredate(rs.getDate(5));
			empvo.setSal(rs.getDouble(6));
			empvo.setComm(rs.getDouble(7));
			empvo.setDeptno(rs.getInt(8));
			
			model.addAttribute("empvo", empvo);
		}
		catch(Exception e) {
		}
		
		return "update";
	}
	
	@RequestMapping(value="updateProcess.me")
	public String UpdateProcess(Model model, HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "123456");
		
			pstmt = con.prepareStatement("update emp_copy set job = ?, mgr = ?, sal = ?, comm = ?, deptno = ? where empno = ?");
			
			System.out.println(request.getParameter("job") + (request.getParameter("sal")));
			System.out.println(   request.getParameter("empno")             );
			System.out.println(   request.getParameter("mgr")             );
			System.out.println(   request.getParameter("deptno")             );
			
			
			pstmt.setString(1,  request.getParameter("job"));
			pstmt.setInt(2,  Integer.parseInt(request.getParameter("mgr")));
			pstmt.setInt(3,  Integer.parseInt(request.getParameter("sal")));
			pstmt.setDouble(4, Double.parseDouble(request.getParameter("comm")));
			pstmt.setInt(5, Integer.parseInt(request.getParameter("deptno")));
			pstmt.setInt(6, Integer.parseInt(request.getParameter("empno")));
			pstmt.executeUpdate();
			
		}
		catch(Exception e) {
		}
		
		return "redirect:selectProcess.me";
	}
	

}
