package com.matdatour.comment;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface CommentDAO {
	public List<CommentDTO> selectAllComment(Integer board_num);

	public int commentInsert(CommentDTO commentdto);

	public int commentUpdate(Map<Object, Object> map);

	public int commentDelete(int c_num);
 
}
