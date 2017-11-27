package com.matdatour.user_board_join;

import java.util.List;

public interface UserBoardDAO {
	public List<UserBoardDTO> listAll(String board_group) throws Exception;
	
	public List<UserBoardDTO> slistAll(String searchOption, String keyword); 
}
