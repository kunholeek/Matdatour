package com.matdatour.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("boardservice")
public class BoardServiceImpl implements BoardService {

	@Autowired
	@Qualifier("boarddao")
	BoardDAO board;

	public BoardServiceImpl() {
	}

	public BoardServiceImpl(BoardDAO board) {
		this.board = board;
	}

	public void setDao(BoardDAO board) {
		this.board = board;
	}

	@Override
	public List<BoardDTO> selectAll() {
		return board.selectAll();
	}

	@Override
	public BoardDTO selectByNum(int board_num) {
		return board.selectByNum(board_num);
	}

	@Override
	public int serv_boardInsert(BoardDTO boarddto) {
		return board.boardInsert(boarddto);
	}

	@Override
	public int serv_boardUpdate(BoardDTO boarddto) {
		return board.boardUpdate(boarddto);
	}

	@Override
	public int serv_boardDelete(int board_num) {
		return board.boardDelete(board_num);
	}

}
