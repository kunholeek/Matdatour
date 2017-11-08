package com.matdatour.comment;

import java.util.List;

public interface CommentService {
	public List<CommentDTO> selectAllComment();

	public int serv_commentInsert(CommentDTO commentdto);

	public int serv_commentUpdate(CommentDTO commentdto);

	public int serv_commentDelete(int user_num);
}
