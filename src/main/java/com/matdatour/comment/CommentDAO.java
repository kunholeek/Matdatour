package com.matdatour.comment;

import java.sql.Date;
import java.util.List;

public interface CommentDAO {
	public List<CommentDTO> selectAllComment(Integer board_num);

	public int commentInsert(CommentDTO commentdto);

	public int commentUpdate(CommentDTO commentdto);

	public int commentDelete(int user_num);
 
}
