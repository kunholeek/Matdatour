package com.matdatour.board;

import java.util.List;

public interface BoardDAO {
	
	public List<BoardDTO> selectAll();

	public BoardDTO selectByNum(int board_num);
	
	/*public BoardDTO selectByTitle(String title); 
	
	public BoardDTO selectByNickname(String nickname); 
*/
	public int boardInsert(BoardDTO boarddto);

	public int boardUpdate(BoardDTO boarddto);

	public int boardDelete(int board_num); 
	 
}