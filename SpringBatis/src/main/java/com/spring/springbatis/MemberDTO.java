package com.spring.springbatis;

public class MemberDTO {
	String hakbun;
	String irum;
	String password;
	
   public MemberDTO(String hakbun, String irum, String password) {
        this.hakbun = hakbun;
        this.irum = irum;
        this.password = password;
   }
	
	
	public String getHakbun() {
		return hakbun;
	}
	public void setHakbun(String hakbun) {
		this.hakbun = hakbun;
	}
	public String getIrum() {
		return irum;
	}
	public void setIrum(String irum) {
		this.irum = irum;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
