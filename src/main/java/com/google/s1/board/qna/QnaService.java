package com.google.s1.board.qna;

import java.util.List;

import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.s1.board.BoardDTO;
import com.google.s1.board.BoardFileDTO;
import com.google.s1.board.BoardService;
import com.google.s1.util.FileManager;
import com.google.s1.util.Pager;

@Service
public class QnaService implements BoardService {

	@Autowired
	private QnaDAO qnaDAO;
	@Autowired
	private FileManager fileManager;
	
	@Override
	public BoardFileDTO detailFile(BoardFileDTO boardFileDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.detailFile(boardFileDTO);
	}
	//reply
	public int reply(QnaDTO qnaDTO) throws Exception{
		//qnaDTO.num      :부모글의 글번호 
		//qnaDTO.title    :form에서 입력한 답글 제목 
		//qnaDTO.writer   :form에서 입력한 답글 작성자 
		//qnaDTO.contents :form에서 입력한 답글 내용 
		//qnaDTO.regDate  :null
		//qnaDTO.hit      :null
		//qnaDTO.ref      :null or 0 //int인 경우 
		//qnaDTO.step     :null or 0
		//qnaDTO.depth    :null or 0
		//부모글의 글번호가 ref와 같으냐 --no 틀린경우가 있음 -댓글의 댓글 
		//그러므로 부모글의 정보 조회해야됨 
		
		//1.부모의 정보를 조회 (Ref,step ,depth)
		BoardDTO boardDTO = qnaDAO.detail(qnaDTO);
		QnaDTO parent = (QnaDTO)boardDTO; //!!!!!!!!!!
		
		
		//2.답글의 ref는 부모의 ref
		qnaDTO.setRef(parent.getRef());
		
		//3.답글의 step은 부모의 step+1
		qnaDTO.setStep(parent.getStep()+1);
		
		//4.답글의 depth는 부모의 depth+1
		qnaDTO.setDepth(parent.getDepth()+1);
		
		//5. 테이블에서 ref가 부모의 ref와 같고 step이 부모의 step보다 큰것들(초과)을 각자의 step에 +1 값으로 업데이트
		//step update
		int result = qnaDAO.stepUpdate(parent);
		
		//6.답글 insert
		result = qnaDAO.reply(qnaDTO);
		
		return result;
	}
	
	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		pager.makeRow();
		
		pager.makeNum(qnaDAO.total(pager));
		return qnaDAO.list(pager);
	}

	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.detail(boardDTO);
	}

	@Override
	public int add(BoardDTO boardDTO,MultipartFile [] files) throws Exception {
		// TODO Auto-generated method stub
		int result =qnaDAO.add(boardDTO);
		System.out.println(result);
		for(int i=0;i<files.length;i++) {
			System.out.println(files[i].isEmpty());
			if(files[i].isEmpty()) {
				
				continue;
			}
		
			String fileName=fileManager.save(files[i], "resources/upload/qna");
			
			QnaFileDTO qnaFileDTO = new QnaFileDTO();
			qnaFileDTO.setNum(boardDTO.getNum());
			qnaFileDTO.setFileName(fileName);
			qnaFileDTO.setOriName(files[i].getOriginalFilename());
			System.out.println("test");
			result=qnaDAO.addFile(qnaFileDTO);
			System.out.println(result); 
			
		}
		return result;
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.update(boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		List<QnaFileDTO> ar = qnaDAO.listFile(boardDTO);
		int result=qnaDAO.delete(boardDTO);
		if(result>0) {
			for(QnaFileDTO dto:ar) {
				boolean check = fileManager.remove("resources/upload/qna",dto.getFileName());
		
			}
		}
		return result;
	}


}
