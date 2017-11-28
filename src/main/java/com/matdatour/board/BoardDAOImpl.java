package com.matdatour.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Repository("boarddao")
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	SqlSession sqlSession;

	String namespace = "com.matdatour.board.";

	@Override
	public List<BoardDTO> selectAll() {
		System.out.println(sqlSession);
		return sqlSession.selectList(namespace + "selectAll");
	}

	/*
	 * @Override public BoardDTO selectByNum(int board_num) {
	 * System.out.println("board_num���� �Խñ� ��ȸ:" + board_num); return
	 * sqlSession.selectOne(namespace + "selectByNum", board_num); }
	 */

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

	// 게시글 상세보기
	@Override
	public BoardDTO detailView(int board_num) throws Exception {
		return sqlSession.selectOne(namespace + "detailView", board_num);
	}

	@Override
	public String fileUpload(MultipartHttpServletRequest mRequest) {
		return null;
	}

	@Override
	public int boardDeleteByID(int user_num) {
	
		return sqlSession.delete(namespace+"boardDelete2", user_num);
	}

}
