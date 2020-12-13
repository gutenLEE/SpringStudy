package com.spring.springmemberboard2;

public class ddd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sql = "";
		sql="insert into smemberboard2 (num, id, subject,";
		sql+="content,org_file,up_file,re_ref,re_lev,re_seq,readcount," +
			"boarddate) values(?,?,?,?,?,?,?,?,?,?,sysdate)";
		System.out.println(sql);
	}

}
