package com.matdatour.user;

public class UserDTO {

	private int user_num;
	private String user_id;
	private String user_pwd;
	private String user_nick;
	private String user_phone;

	public UserDTO() {
		super();
	}

	public UserDTO(int user_num, String user_id, String user_pwd, String user_nick, String user_phone) {
		super();
		this.user_num = user_num;
		this.user_id = user_id;
		this.user_pwd = user_pwd;
		this.user_nick = user_nick;
		this.user_phone = user_phone;
	}

	public int getUser_num() {
		return user_num;
	}

	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public String getUser_nick() {
		return user_nick;
	}

	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserDTO [user_num=").append(user_num).append(", user_id=").append(user_id).append(", user_pwd=")
				.append(user_pwd).append(", user_nick=").append(user_nick).append(", user_phone=").append(user_phone)
				.append("]");
		return builder.toString();
	}

}
