package com.matdatour.comment;

import java.util.List;

import javax.servlet.http.HttpSession;

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

	public void setDao(CommentDAO comment) {
		this.comment = comment;
	}

	@Override
	public List<CommentDTO> selectAllComment(Integer board_num) {
		return comment.selectAllComment(board_num);
	}

	@Override
	public void commentInsert(CommentDTO commentdto) {
		comment.commentInsert(commentdto);
	}

	@Override
	public void commentUpdate(CommentDTO commentdto) {
		 
	}

	@Override
	public void commentDelete(int c_num) {
		 
	}

	 
 

}
