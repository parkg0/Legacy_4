package com.google.s1.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.s1.util.Pager;

@Repository
public class NoticeDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.google.s1.notice.NoticeDAO.";
	
	//list 
	//parameter로 pager보내줘 왜냐하면 mapper에 parameter type으로 pager선언함 
	//#{startRow} and #{lastRow} 받으려고 
	public List<NoticeDTO> list(Pager pager) throws Exception{
		return sqlSession.selectList(NAMESPACE+"list",pager);
	}

	
	
	//total
	public Long total(Pager pager) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"total",pager);
	}
	
	//detail
	public NoticeDTO detail(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"detail",noticeDTO);
	}
	
	//add 
	public int add(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"add",noticeDTO);
	}
	
	//delete 
	public int delete(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"delete",noticeDTO);
	}
}
