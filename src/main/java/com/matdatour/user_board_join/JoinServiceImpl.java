package com.matdatour.user_board_join;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JoinServiceImpl implements JoinService {

	@Autowired
	JoinDAO joindao;

	@Override
	public List<JoinDTO> listAll(String board_group) throws Exception {
		return joindao.listAll(board_group);
	}
 

}
