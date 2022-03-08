package com.google.s1.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.s1.board.BoardDTO;
import com.google.s1.board.BoardService;
import com.google.s1.util.Pager;

@Service
public class QnaService implements BoardService {

	@Autowired
	private QnaDAO qnaDAO;
	
	//reply
	public int reply(QnaDTO qnaDTO) throws Exception{
		//qnaDTO.num      :부모글의 글번호 
		//qnaDTO.title    :form에서 입력한 답글 제목 
		//qnaDTO.writer   :form에서 입력한 답글 작성자 
		//qnaDTO.contents :form에서 입력한 답글 내용 
		//qnaDTO.regDate  :null
		//qnaDTO.hit      :null
		//qnaDTO.ref      :0
		//qnaDTO.step     :0
		//qnaDTO.depth    :0
		//부모글의 글번호가 ref와 같으냐 --no 틀린경우가 있음 -댓글의 댓글 
		
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
	public int add(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.add(boardDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.update(boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.delete(boardDTO);
	}

}