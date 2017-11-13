package com.matdatour.board;

import java.sql.Date;

public class BoardDTO {

	private int board_num;
	private String board_group;
	private Date board_date;
	private String title;
	private int recommend;
	private String m_content;
	private String m_image;
	private int user_num;
	
	public BoardDTO() {
		super();
	}

	public BoardDTO(int board_num, String board_group, Date board_date, String title, int recommend, String m_content,
			String m_image, int user_num) {
		super();
		this.board_num = board_num;
		this.board_group = board_group;
		this.board_date = board_date;
		this.title = title;
		this.recommend = recommend;
		this.m_content = m_content;
		this.m_image = m_image;
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

	public String getM_content() {
		return m_content;
	}

	public void setM_content(String m_content) {
		this.m_content = m_content;
	}

	public String getM_image() {
		return m_image;
	}

	public void setM_image(String m_image) {
		this.m_image = m_image;
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
				.append(recommend).append(", m_content=").append(m_content).append(", m_image=").append(m_image)
				.append(", user_num=").append(user_num).append("]");
		return builder.toString();
	}


}
