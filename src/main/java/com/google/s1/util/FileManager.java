package com.google.s1.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;


@Component
public class FileManager {

	//tomcat이 생성하는 내장객체 (application)
	//web applicatoin과  OS(외부)와 연결 
	@Autowired
	private ServletContext servletContext;
	
	public boolean remove(String path,String fileName)throws Exception{
		//file을 HDD에서 삭제 
		//필요한 정보 : 저장된 파일명, 저장된 폴더명 
		
		//1. 실제경로 받아오기 
		path = servletContext.getRealPath(path);
		//2.파일의정보를 담고있는 클래스 준비 
		File file = new File(path, fileName);
		//3.삭제 
		return file.delete(); // t/f return
		
	}
	
	public String save(MultipartFile multipartFile,String path)throws Exception{
		//파일저장은 tomcat이 아니라 OS에서 저장 
		//path=/resources/upload/member/
		String realPath = servletContext.getRealPath(path);
		System.out.println(realPath);
		
		//저장할 "폴더의 정보"를 가지고 있는 자바 객체를 선언
		File file = new File(realPath);
		//System.out.println(file.exists());
		//이거 존재합니까? 맞으면 true
		//이 폴더가 실제로 존재하는지 확인 
		//System.out.println(file.isDirectory());
		//이거 폴더입니까? 맞으면 true
		
		//만약 폴더가 없으면 에러가 발생하기 때문에 폴더를 생성 
		//지금(개발단계)은 임시폴더에만들어짐 
		if(!file.exists()) {
			//file2.mkdir(); //중간폴더가 없으면 에러 
			file.mkdirs(); //중간폴더가 없으면 중간폴더도 생성 
		}
		
		//1.중복되지 않는 파일명 생성 
		
		//1)시간을 이용하는 방법 
		Calendar ca =Calendar.getInstance();
		long l =ca.getTimeInMillis();//현재시간을 밀리세컨즈로 변환 
		System.out.println("time:"+l);
		String oriName=multipartFile.getOriginalFilename(); //common-2.jpeg
		
		String fileName= l+"_"+oriName;
		System.out.println("fileName:"+fileName);
		
		//2)UUID
		// UUID는 클래스메서드 
		fileName = UUID.randomUUID().toString();
		//UUID.randomUUID() 리턴타입이 스트링이 아님 toString() 메서드 이용해서 스트링으로 바꿔줌 
		fileName = fileName+"_"+oriName;
		System.out.println("UUID:"+fileName);
		
		//2.HDD에 파일 저장 
		//경로명:realpath에 파일명:fileName으로 저장할겨 
		
		//1)MultipartFile 클래스의 transferTo 메서드 사용 
//		//file = new File(realPath,fileName);or 
//		file = new File(file,fileName); //file에 경로가 들어가있음 
//		multipartFile.transferTo(file);
		//multipartFile을 realpath에 fileName이라는 이름으로저장하세요~ 
		
		//2)fileCopyUtils 클래스의 copy method 사용
		file =new File(file,fileName); //이 경로에 이 파일명으로 저장할겨 ~ 
		FileCopyUtils.copy(multipartFile.getBytes(), file);
		//목적지는 file (resources/upload/member/fileName)
		//이미지를 복사한다 = 0/1 을 복사한다 
		
		return fileName;
		//파일명을 DB에 저장해야되니까 리턴해줘 
		
	}
}

