package com.matdatour.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("boarddao")
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	SqlSession sqlSession;

	String namespace = "com.matdatour.board.";

	@Override
	public List<BoardDTO> selectAll() {
		System.out.println("모두조회:" + sqlSession);
		return sqlSession.selectList(namespace + "selectAll");
	}

	@Override
	public BoardDTO selectByNum(int board_num) {
		System.out.println("board_num으로 게시글 조회:" + board_num);
		return sqlSession.selectOne(namespace + "selectByNum", board_num);
	}

	@Override
	public int boardInsert(BoardDTO boarddto) {
		return sqlSession.insert(namespace + "boardInsert", boarddto);

	}

	@Override
	public int boardUpdate(BoardDTO boarddto) {
		return sqlSession.update(namespace + "boardUpdate", boarddto);

	}

	@Override
	public int boardDelete(int board_num) {
		return sqlSession.delete(namespace + "boardDelete", board_num);

	}

}
