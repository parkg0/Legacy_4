package com.google.s1.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.google.s1.notice.NoticeDAO.";
	
	//list
	public List<NoticeDTO> list() throws Exception{
		return sqlSession.selectList(NAMESPACE+"list");
	}

	//detail
	public NoticeDTO detail(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"detail",noticeDTO);
	}
	
	//add -error 
	public int add(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"add",noticeDTO);
	}
	
	//delete 
	public int delete(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"delete",noticeDTO);
	}
}
