package com.matdatour.comment;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

public interface CommentService {
	public List<CommentDTO> selectAllComment(Integer board_num);

	public void commentInsert(CommentDTO commentdto);

	public void commentUpdate(Map<Object, Object> map);

	public void commentDelete(int c_num);
 
}
