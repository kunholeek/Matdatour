package com.matdatour.user_board_join;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userboarddao")
public class UserBoardDAOImpl implements UserBoardDAO{

	
	@Autowired
	SqlSession sqlSession;

	String namespace = "com.matdatour.user_board_join.";

	@Override
	public List<UserBoardDTO> listAll(String board_group) throws Exception {
		return sqlSession.selectList(namespace+"listAll", board_group);
	}

	@Override
	public List<UserBoardDTO> slistAll(String mtitle) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+"slistAll", mtitle);
	}

}
