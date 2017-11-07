package com.matdatour.contents;

public class ContentDTO {

	private int board_num;
	private String board_group;
	private String m_content;
	private String m_image;

	public ContentDTO() {
		super();
	}

	public ContentDTO(int board_num, String board_group, String m_content, String m_image) {
		super();
		this.board_num = board_num;
		this.board_group = board_group;
		this.m_content = m_content;
		this.m_image = m_image;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ContentDTO [board_num=").append(board_num).append(", board_group=").append(board_group)
				.append(", m_content=").append(m_content).append(", m_image=").append(m_image).append("]");
		return builder.toString();
	}

}
