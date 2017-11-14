package com.matdatour.user_board_join;

import java.util.List;

public interface JoinService {

	public List<JoinDTO> listAll(String board_group) throws Exception;
	 
}
