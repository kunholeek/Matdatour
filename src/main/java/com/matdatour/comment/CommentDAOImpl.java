package com.matdatour.comment;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("commentdao")
public class CommentDAOImpl implements CommentDAO{

	@Autowired
	SqlSession sqlSession;

	String namespace = "com.matdatour.comment.";
	@Override
	public List<CommentDTO> selectAllComment() {
		System.out.println("모두조회:" + sqlSession);
		return sqlSession.selectList(namespace + "selectAllComment");
	}

	@Override
	public int commentInsert(CommentDTO commentdto) {
		return sqlSession.insert(namespace + "commentInsert", commentdto);
	}

	@Override
	public int commentUpdate(CommentDTO commentdto) {
		return sqlSession.update(namespace + "commentUpdate", commentdto);
	}

	@Override
	public int commentDelete(int user_num) {
		return sqlSession.delete(namespace + "commentDelete", user_num);
	}

}
