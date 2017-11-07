package com.matdatour.board;

import java.sql.Date;

public class BoardDTO {

	private int board_num;
	private String board_group;
	private Date board_date;
	private String title;
	private int recommend;
	private int user_num;

	public BoardDTO() {
		super();
	}

	public BoardDTO(int board_num, String board_group, Date board_date, String title, int recommend, int user_num) {
		super();
		this.board_num = board_num;
		this.board_group = board_group;
		this.board_date = board_date;
		this.title = title;
		this.recommend = recommend;
		this.user_num = user_num;
	}

	public int getBoard_num() {
		return board_num;
	}

	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}

	public String getBoard_group() {
		return board_group;
	}

	public void setBoard_group(String board_group) {
		this.board_group = board_group;
	}

	public Date getBoard_date() {
		return board_date;
	}

	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getRecommend() {
		return recommend;
	}

	public void setRecommend(int recommend) {
		this.recommend = recommend;
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
		builder.append("BoardDTO [board_num=").append(board_num).append(", board_group=").append(board_group)
				.append(", board_date=").append(board_date).append(", title=").append(title).append(", recommend=")
				.append(recommend).append(", user_num=").append(user_num).append("]");
		return builder.toString();
	}

}
