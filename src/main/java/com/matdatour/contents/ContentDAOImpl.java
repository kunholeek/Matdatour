package com.matdatour.contents;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("contentdao")
public class ContentDAOImpl implements ContentDAO{
	
	@Autowired
	SqlSession sqlSession;

	String namespace = "com.matdatour.contents.";
	@Override
	public int contentInsert(ContentDTO contentdto) {
		return sqlSession.insert(namespace + "contentInsert", contentdto);
	}

	@Override
	public int contentUpdate(ContentDTO contentdto) {
		return sqlSession.update(namespace + "contentUpdate", contentdto);
	}

	@Override
	public int contentDelete(int board_num) {
		return sqlSession.delete(namespace + "contentDelete", board_num);
	}

}
