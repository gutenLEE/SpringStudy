package com.spring.springfileUpload1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {


	@RequestMapping(value = "/fileUploadForm.bo")
	public String home() {

		return "fileUploadForm";
	}
	
	// 커맨드 객체(VO, DTO)를 통한 업로드 파일 접근
	// 커맨드 클래스에 파라미터와 동일한 이름의 MultiPartFile타입 프로퍼티를 추가해주기만 하면 업로드 파일 정보를 커맨드 객체를 통해 전달 받을 수 있게 된다.
	
	@RequestMapping(value="/fileUpload1.bo")
	public ModelAndView fileUpload1(HttpServletRequest request, RequestModel model) throws Exception{

		String name = request.getParameter("name");
		
		String uploadPath = "C:\\Project\\upload\\"; // 직접 업로드될 위치 지정, 외부경롤
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("download");
		
		ArrayList<String> orgfile_list = new ArrayList<String>();
		ArrayList<String> storedfile_list = new ArrayList<String>();
		ArrayList<Long> filesize_list = new ArrayList<Long>();
		
		for(MultipartFile mf : model.getFile()) { // medel에 name과 file 있음.
			
			String originFileName = mf.getOriginalFilename();
			long filesize = mf.getSize();
			
			System.out.println("originFileName : " + originFileName);
			System.out.println("fileSize : " + filesize);
			
			String storedFileName = System.currentTimeMillis() + originFileName; // 밀리세컨드로하면 동일한 파일 이름 생성 방지
			
			System.out.println("storedFileName = " + storedFileName);
			
			String safeFile = uploadPath + storedFileName; // 파일명과 경로
			System.out.println("safeFile = " + safeFile);
			
			try {
				if(mf.getSize() != 0) {
					mf.transferTo(new File(safeFile)); // 실제 업로드에 사용.
				}
			} catch( IOException e) {
				System.out.println("업로드 에러");
			}
			
			orgfile_list.add(originFileName);
			storedfile_list.add(storedFileName);
			filesize_list.add(filesize);
		}
			
		//뷰에 출력한 데이터 모델에 저장
		mav.addObject("name", name);
		mav.addObject("orgfile_list" , orgfile_list);
		mav.addObject("storedfile_list", storedfile_list);
		mav.addObject("filesize_list", filesize_list);
		mav.addObject("uploadPath", uploadPath); // 업로드한 정보를 화면에 뿌려주기 위해서..
		
		return mav;
	}
	
	
	@RequestMapping("/fileUpload2.bo") // 별도로 모델 객체 생성할 필요가 없다.
	public ModelAndView fileUpload2(MultipartHttpServletRequest request) throws Exception{
		//파라미터가 위에랑 바뀜 
		
		
		String name = request.getParameter("name");
		List<MultipartFile> fileList = request.getFiles("file"); // 중요 
		
		String uploadPath = "C:\\Project\\upload\\";
		
		//뷰 지정
		ModelAndView mav = new ModelAndView();
		mav.setViewName("download");
		
		ArrayList<String> orgfile_list = new ArrayList<String>();
		ArrayList<String> storedfile_list = new ArrayList<String>();
		ArrayList<Long> filesize_list = new ArrayList<Long>();
		
		for(MultipartFile mf : fileList) {
			
			String originFileName = mf.getOriginalFilename();
			long filesize = mf.getSize();
		

			System.out.println("originFileName = " + originFileName);
			System.out.println("filesize = " + filesize);
			String storedFileName = System.currentTimeMillis() + originFileName;
			System.out.println("storedFileName = " + storedFileName);
			
			String safeFile = uploadPath + storedFileName;
			
			try {
				if(mf.getSize() != 0) {
					mf.transferTo(new File(safeFile));
				}
			} catch( IOException e) {
				System.out.println("업로드 에러");
			}
			
			orgfile_list.add(originFileName);
			storedfile_list.add(storedFileName);
			filesize_list.add(filesize);
		}
		
		//뷰에 출력한 데이터 모델에 저장
		mav.addObject("name", name);
		mav.addObject("orgfile_list" , orgfile_list);
		mav.addObject("storedfile_list", storedfile_list);
		mav.addObject("filesize_list", filesize_list);
		mav.addObject("uploadPath", uploadPath);
		
		return mav;
		
	}
	
	
	@RequestMapping(value="/fileDownload.bo")
	public void fileDownload(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		response.setCharacterEncoding("utf-8");
		
		String of = request.getParameter("of"); //서버에 업로드된 변경된 실제 파일명
		String of2 = request.getParameter("of2"); // 오리지날 파일명
		
		/*
		 * 웹사이트 루트 디렉토리의 실제 디스크상의 경로 알아내기
		 * String uploadPath = request.getSession().getServletContext().getRe
		 * String fullPath = uploadPath + "/" + of;
		 * */
		
		String uploadPath = "C:\\Project\\upload\\";
		String fullPath = uploadPath + of;
		File downloadFile = new File(fullPath);
		
		//파일 다운로드를 위해 컨텐츠 타입을 application/download로 설정
		response.setContentType("application/download");
		//파일 사이즈 지정
		response.setContentLength((int)downloadFile.length());
		// 다운로드 창을 띄우기 위한 헤더 조작
		response.setHeader("content-Disposition","attachment;filename=" + new String(of2.getBytes(), "ISO8859_1"));
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		/**
		 * content-disposition속성
		 * content-disposition: attachment 브라우저 인식 파일 확장자를 포함하여 모든 확장자 파일들에 대해, 다운로드시 무조건 "파일업로드" 대화상자가 뜨도록 하는 헤더속성이다.
		 * 
		 * content-disposition: inline 브라우저 인식 파일확장자를 가진 파일들에 대해서는 웹브라우저 상에서 바로 파일을 열고, 그외의 파일들에 대해서는  "파일 다운로드" 대화상자가 뜨로록 하는 헤더속성이다.
		 */
		
		FileInputStream fin = new FileInputStream(downloadFile);
		ServletOutputStream sout = response.getOutputStream();
		
		byte[] buf = new byte[1024];
		int size = -1;
		
		while((size = fin.read(buf, 0, buf.length)) != -1) {
			sout.write(buf, 0, size);
		}
		fin.close();
		sout.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
