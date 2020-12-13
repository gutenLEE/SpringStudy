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
	
	// Ŀ�ǵ� ��ü(VO, DTO)�� ���� ���ε� ���� ����
	// Ŀ�ǵ� Ŭ������ �Ķ���Ϳ� ������ �̸��� MultiPartFileŸ�� ������Ƽ�� �߰����ֱ⸸ �ϸ� ���ε� ���� ������ Ŀ�ǵ� ��ü�� ���� ���� ���� �� �ְ� �ȴ�.
	
	@RequestMapping(value="/fileUpload1.bo")
	public ModelAndView fileUpload1(HttpServletRequest request, RequestModel model) throws Exception{

		String name = request.getParameter("name");
		
		String uploadPath = "C:\\Project\\upload\\"; // ���� ���ε�� ��ġ ����, �ܺΰ��
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("download");
		
		ArrayList<String> orgfile_list = new ArrayList<String>();
		ArrayList<String> storedfile_list = new ArrayList<String>();
		ArrayList<Long> filesize_list = new ArrayList<Long>();
		
		for(MultipartFile mf : model.getFile()) { // medel�� name�� file ����.
			
			String originFileName = mf.getOriginalFilename();
			long filesize = mf.getSize();
			
			System.out.println("originFileName : " + originFileName);
			System.out.println("fileSize : " + filesize);
			
			String storedFileName = System.currentTimeMillis() + originFileName; // �и���������ϸ� ������ ���� �̸� ���� ����
			
			System.out.println("storedFileName = " + storedFileName);
			
			String safeFile = uploadPath + storedFileName; // ���ϸ�� ���
			System.out.println("safeFile = " + safeFile);
			
			try {
				if(mf.getSize() != 0) {
					mf.transferTo(new File(safeFile)); // ���� ���ε忡 ���.
				}
			} catch( IOException e) {
				System.out.println("���ε� ����");
			}
			
			orgfile_list.add(originFileName);
			storedfile_list.add(storedFileName);
			filesize_list.add(filesize);
		}
			
		//�信 ����� ������ �𵨿� ����
		mav.addObject("name", name);
		mav.addObject("orgfile_list" , orgfile_list);
		mav.addObject("storedfile_list", storedfile_list);
		mav.addObject("filesize_list", filesize_list);
		mav.addObject("uploadPath", uploadPath); // ���ε��� ������ ȭ�鿡 �ѷ��ֱ� ���ؼ�..
		
		return mav;
	}
	
	
	@RequestMapping("/fileUpload2.bo") // ������ �� ��ü ������ �ʿ䰡 ����.
	public ModelAndView fileUpload2(MultipartHttpServletRequest request) throws Exception{
		//�Ķ���Ͱ� ������ �ٲ� 
		
		
		String name = request.getParameter("name");
		List<MultipartFile> fileList = request.getFiles("file"); // �߿� 
		
		String uploadPath = "C:\\Project\\upload\\";
		
		//�� ����
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
				System.out.println("���ε� ����");
			}
			
			orgfile_list.add(originFileName);
			storedfile_list.add(storedFileName);
			filesize_list.add(filesize);
		}
		
		//�信 ����� ������ �𵨿� ����
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
		
		String of = request.getParameter("of"); //������ ���ε�� ����� ���� ���ϸ�
		String of2 = request.getParameter("of2"); // �������� ���ϸ�
		
		/*
		 * ������Ʈ ��Ʈ ���丮�� ���� ��ũ���� ��� �˾Ƴ���
		 * String uploadPath = request.getSession().getServletContext().getRe
		 * String fullPath = uploadPath + "/" + of;
		 * */
		
		String uploadPath = "C:\\Project\\upload\\";
		String fullPath = uploadPath + of;
		File downloadFile = new File(fullPath);
		
		//���� �ٿ�ε带 ���� ������ Ÿ���� application/download�� ����
		response.setContentType("application/download");
		//���� ������ ����
		response.setContentLength((int)downloadFile.length());
		// �ٿ�ε� â�� ���� ���� ��� ����
		response.setHeader("content-Disposition","attachment;filename=" + new String(of2.getBytes(), "ISO8859_1"));
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		/**
		 * content-disposition�Ӽ�
		 * content-disposition: attachment ������ �ν� ���� Ȯ���ڸ� �����Ͽ� ��� Ȯ���� ���ϵ鿡 ����, �ٿ�ε�� ������ "���Ͼ��ε�" ��ȭ���ڰ� �ߵ��� �ϴ� ����Ӽ��̴�.
		 * 
		 * content-disposition: inline ������ �ν� ����Ȯ���ڸ� ���� ���ϵ鿡 ���ؼ��� �������� �󿡼� �ٷ� ������ ����, �׿��� ���ϵ鿡 ���ؼ���  "���� �ٿ�ε�" ��ȭ���ڰ� �߷η� �ϴ� ����Ӽ��̴�.
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
