package com.spring.springfileUpload1;

import org.springframework.web.multipart.MultipartFile;

public class RequestModel {
	
	private String name;
	private MultipartFile file[]; // 업로드될 파일 저장
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MultipartFile[] getFile() {
		return file;
	}
	public void setFile(MultipartFile[] file) {
		this.file = file;
	}
	
	
}
