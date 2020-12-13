package com.spring.springSungjuk;

public class SungjukVO {
	
	private String hakbun;
	private String irum;
	private String password;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	private String grade;
	
	
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

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getGrade() {
		return grade;
	}

	
	void getGradeProcess() {
		
		this.tot = eng + kor + math;
		this.avg = (eng + kor + math) / 3.;
		
	
		if(avg >= 90)
			grade = "A+";
		else if( avg >= 80)
			grade = "B+";
		else if( avg >= 70)
			grade = "C+";
		else if( avg >= 60)
			grade = "D+";
		else if( avg < 60)
			grade = "F+";
		else
			grade = "N";
	}

	@Override
	public String toString() {
		return "SungjukVO [hakbun=" + hakbun + ", irum=" + irum + ", password=" + password + ", kor=" + kor + ", eng="
				+ eng + ", math=" + math + ", tot=" + tot + ", avg=" + avg + ", grade=" + grade + "]";
	}
	

}
