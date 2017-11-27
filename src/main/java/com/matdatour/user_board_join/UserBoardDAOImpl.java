package com.matdatour.user_board_join;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userboarddao")
public class UserBoardDAOImpl implements UserBoardDAO {

	@Autowired
	SqlSession sqlSession;

	String namespace = "com.matdatour.user_board_join.";

	@Override
	public List<UserBoardDTO> listAll(String board_group) throws Exception {
		return sqlSession.selectList(namespace + "listAll", board_group);
	}

	@Override
	public List<UserBoardDTO> slistAll(String searchOption, String keyword) {
		// 검색옵션, 키워드 맵에 저장
	    Map<String, String> map = new HashMap<String, String>();
	    map.put("searchOption", searchOption);
	    map.put("keyword", keyword);
		return sqlSession.selectList(namespace+"slistAll", map);
	}

}
