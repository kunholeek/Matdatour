package com.matdatour.comment;

import java.sql.Date;

public class CommentDTO {

	private int c_num;
	private int board_num;
	private int user_num;
	private String c_replyer;
	private String c_comment;
	private String c_user_nick;
	private Date c_date; // regdate

	public CommentDTO() {
		super();
	}

	public CommentDTO(int c_num, int board_num, int user_num, String c_replyer, String c_comment, String c_user_nick,
			Date c_date) {
		super();
		this.c_num = c_num;
		this.board_num = board_num;
		this.user_num = user_num;
		this.c_replyer = c_replyer;
		this.c_comment = c_comment;
		this.c_user_nick = c_user_nick;
		this.c_date = c_date;
	}

	public int getC_num() {
		return c_num;
	}

	public void setC_num(int c_num) {
		this.c_num = c_num;
	}

	public int getBoard_num() {
		return board_num;
	}

	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}

	public String getC_comment() {
		return c_comment;
	}

	public void setC_comment(String c_comment) {
		this.c_comment = c_comment;
	}

	public String getC_user_nick() {
		return c_user_nick;
	}

	public void setC_user_nick(String c_user_nick) {
		this.c_user_nick = c_user_nick;
	}

	public Date getC_date() {
		return c_date;
	}

	public void setC_date(Date c_date) {
		this.c_date = c_date;
	}

	public int getUser_num() {
		return user_num;
	}

	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}

	public String getC_replyer() {
		return c_replyer;
	}

	public void setC_replyer(String c_replyer) {
		this.c_replyer = c_replyer;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CommentDTO [c_num=").append(c_num).append(", board_num=").append(board_num)
				.append(", user_num=").append(user_num).append(", c_replyer=").append(c_replyer).append(", c_comment=")
				.append(c_comment).append(", c_user_nick=").append(c_user_nick).append(", c_date=")
				.append(c_date)
				.append("]");
		return builder.toString();
	}

}
