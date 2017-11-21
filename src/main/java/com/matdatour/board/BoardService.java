package com.matdatour.board;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface BoardService {

	public List<BoardDTO> selectAll();

	/* public BoardDTO selectByNum(int board_num); */

	public BoardDTO detailView(int board_num) throws Exception;

	/*
	 * public BoardDTO selectByTitle(String title);
	 * 
	 * public BoardDTO selectByNickname(String nickname);
	 */
	public int serv_boardInsert(BoardDTO board);

	public int serv_boardUpdate(BoardDTO board);

	public int serv_boardDelete(int board_num);

	public String fileUpload(MultipartHttpServletRequest mRequest);

}
