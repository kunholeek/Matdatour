package com.matdatour.user_board_join;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBoardServiceImpl implements UserBoardService {

	@Autowired
	UserBoardDAO userboarddao;

	@Override
	public List<UserBoardDTO> listAll(String board_group) throws Exception {
		return userboarddao.listAll(board_group);
	}

	@Override
	public List<UserBoardDTO> slistAll(String searchOption, String keyword) {
		return userboarddao.slistAll(searchOption, keyword);
	}

}
