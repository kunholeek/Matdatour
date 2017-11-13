package com.matdatour.score;

public class ScoreDTO {

	private int user_num;
	private int board_num;
	private int m_star;
	
	public ScoreDTO() {
		super();
	}

	public ScoreDTO(int user_num, int board_num, int m_star) {
		super();
		this.user_num = user_num;
		this.board_num = board_num;
		this.m_star = m_star;
	}


	public int getUser_num() {
		return user_num;
	}



	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}



	public int getBoard_num() {
		return board_num;
	}



	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}


	public int getM_star() {
		return m_star;
	}



	public void setM_star(int m_star) {
		this.m_star = m_star;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ScoreDTO [user_num=").append(user_num).append(", board_num=").append(board_num)
				.append(", m_star=").append(m_star).append("]");
		return builder.toString();
	}
	
	
}
