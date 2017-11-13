package com.matdatour.user_board_join;

import java.sql.Date;
import java.util.List;

import com.matdatour.board.BoardDTO;

public class JoinDTO {
	private String user_num;
	private String user_nick;
	private List<BoardDTO> boardList;
	
	public JoinDTO() {
		super();
	}

	public JoinDTO(String user_num, String user_nick, List<BoardDTO> boardList) {
		super();
		this.user_num = user_num;
		this.user_nick = user_nick;
		this.boardList = boardList;
	}

	public String getUser_num() {
		return user_num;
	}

	public void setUser_num(String user_num) {
		this.user_num = user_num;
	}

	public String getUser_nick() {
		return user_nick;
	}

	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
	}

	public List<BoardDTO> getBoardList() {
		return boardList;
	}

	public void setBoardList(List<BoardDTO> boardList) {
		this.boardList = boardList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("JoinDTO [user_num=").append(user_num).append(", user_nick=").append(user_nick)
				.append(", boardList=").append(boardList).append("]");
		return builder.toString();
	}

	 
	 

}
