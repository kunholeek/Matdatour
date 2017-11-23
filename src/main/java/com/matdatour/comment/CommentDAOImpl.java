package com.matdatour.comment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("commentdao")

public class CommentDAOImpl implements CommentDAO {

	@Autowired
	SqlSession sqlSession;

	String namespace = "com.matdatour.comment.";
 
	
	@Override
	public List<CommentDTO> selectAllComment(Integer board_num) {
		return sqlSession.selectList("com.matdatour.user_board_join.commentlist",board_num);
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
