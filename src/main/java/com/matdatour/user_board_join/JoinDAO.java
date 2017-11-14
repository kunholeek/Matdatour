package com.matdatour.user_board_join;

import java.util.List;

import com.matdatour.board.BoardDTO;

public interface JoinDAO {
	
	//게시글 전체 목록
	public List<JoinDTO> listAll(String board_group) throws Exception;
	 

}
