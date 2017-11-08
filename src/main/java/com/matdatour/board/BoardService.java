package com.matdatour.board;

import java.util.List;

public interface BoardService {
	
	
	public List<BoardDTO> selectAll();

	public BoardDTO selectByNum(int board_num);
	
	/*public BoardDTO selectByTitle(String title); 
	
	public BoardDTO selectByNickname(String nickname); 
*/
	public int serv_boardInsert(BoardDTO board);

	public int serv_boardUpdate(BoardDTO board);

	public int serv_boardDelete(int board_num); 

}
