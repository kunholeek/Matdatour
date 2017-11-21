package com.matdatour.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("commentservice")
public class CommentServiceImpl implements CommentService {

	@Autowired
	@Qualifier("commentdao")
	CommentDAO comment;
	
	
	
	public CommentServiceImpl() {
	}
	public CommentServiceImpl(CommentDAO comment) {
		this.comment = comment;
	}
	public void setDao(CommentDAO comment){
		this.comment = comment;
	}
	
	
	
	@Override
	public List<CommentDTO> selectAllComment(int board_num) {
		
		return comment.selectAllComment(board_num);
	}

	@Override
	public int serv_commentInsert(CommentDTO commentdto) {
		return comment.commentInsert(commentdto);
	}

	@Override
	public int serv_commentUpdate(CommentDTO commentdto) {
		return comment.commentUpdate(commentdto);
	}

	@Override
	public int serv_commentDelete(int user_num) {
		return comment.commentDelete(user_num);
	}

}
