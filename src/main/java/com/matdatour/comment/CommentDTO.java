package com.matdatour.comment;

import java.sql.Date;

public class CommentDTO {
	
	private int c_num;
	private String c_comment;
	private Date c_date;	
	private int board_num;
	private String user_nick;
	private int user_num;

	
	
	public CommentDTO() {
		super();
	}


	public CommentDTO(int c_num, String c_comment, Date c_date, int board_num, String user_nick, int user_num) {
		super();
		this.c_num = c_num;
		this.c_comment = c_comment;
		this.c_date = c_date;
		this.board_num = board_num;
		this.user_nick = user_nick;
		this.user_num = user_num;
	}

	public String getUser_nick() {
		return user_nick;
	}

	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
	}

	public int getC_num() {
		return c_num;
	}

	public void setC_num(int c_num) {
		this.c_num = c_num;
	}

	public String getC_comment() {
		return c_comment;
	}

	public void setC_comment(String c_comment) {
		this.c_comment = c_comment;
	}

	public Date getC_date() {
		return c_date;
	}

	public void setC_date(Date c_date) {
		this.c_date = c_date;
	}

	public int getBoard_num() {
		return board_num;
	}

	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}

	public int getUser_num() {
		return user_num;
	}

	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CommentDTO [c_num=").append(c_num).append(", c_comment=").append(c_comment).append(", c_date=")
				.append(c_date).append(", board_num=").append(board_num).append(", user_nick=").append(user_nick)
				.append(", user_num=").append(user_num).append("]");
		return builder.toString();
	}

}
