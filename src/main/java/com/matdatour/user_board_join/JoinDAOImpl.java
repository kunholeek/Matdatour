package com.matdatour.user_board_join;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.matdatour.board.BoardDTO;

//유저 게시판 join dao
@Repository("ubjoindao")
public class JoinDAOImpl implements JoinDAO {

	@Autowired
	SqlSession sqlSession;

	String namespace = "com.matdatour.user_board_join.";

	@Override
	public List<JoinDTO> listAll(String board_group) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(board_group);
		return sqlSession.selectList(namespace + "getJoinTestAll", board_group);
	}
	                     



 

}
