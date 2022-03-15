package com.google.s1.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import com.google.s1.file.FileDTO;
import com.google.s1.member.MemberFileDTO;

@Component
public class FileDown extends AbstractView{
	//bean 이름: fileDown

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("file Down 실행");
		
		FileDTO fileDTO=(FileDTO)model.get("file");
		//FileDTO fileDTO = model.get("file"); 이라하면 error가 뜸 
		//why? model에 담을때는 Object type으로 담음 꺼내려면 형변환해서 꺼내야함 
		System.out.println(fileDTO.getFileName());
		System.out.println(fileDTO.getOriName());
		
		String board = (String)model.get("board");
		
		String path ="/resources/upload/"+board+"/";
		
		//내장객체는 다른 영역의 내장객체를 불러올 수 있음 
		//단 좁은 영역에서 큰 영역으로 가능 /반대로는 불가능 
		//page ->request -> session -> application(servletcontext)
		//getRealPath메서드는 application이 가지고 있음 
		//매개변수에 request가 있음 
		//getRealPath가 필요함 리퀘스트에서 어플리케이션에 있는 겟리얼패쓰 가져와 
		ServletContext sc = request.getSession().getServletContext();
		
		path = sc.getRealPath(path);
		
		File file = new File(path,fileDTO.getFileName());
		
		System.out.println(file.exists());
		System.out.println(file.isFile());
		
		//Encoding 처리 
		response.setCharacterEncoding("UTF-8");
		
		//총 파일의 크기 계산
		response.setContentLength((int)file.length());
		
		//다운로드시 파일의 이름을 인코딩 
		String fileName=URLEncoder.encode(fileDTO.getOriName(),"UTF-8");
		
		//Header 설정
		response.setHeader("Content-Disposition","attachment;filename=\""+fileName+"\"");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		//HDD에서 파일을 읽어서 Clinet로 전송 연결 준비 
		FileInputStream f1 = new FileInputStream(file); //읽을 준비 
		OutputStream os = response.getOutputStream(); // 응답으로 내보낼 준비 
		
		//최종 전송 
		FileCopyUtils.copy(f1, os);
		
		//연결 끊기
		os.close();
		f1.close();
		
		
	}
	
}
 