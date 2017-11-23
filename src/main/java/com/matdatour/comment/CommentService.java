package com.matdatour.comment;

import java.util.List;

import javax.servlet.http.HttpSession;

public interface CommentService {
	public List<CommentDTO> selectAllComment(Integer board_num);

	public void commentInsert(CommentDTO commentdto);

	public void commentUpdate(CommentDTO commentdto);

	public void commentDelete(int c_num);
 
}
