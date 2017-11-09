package com.matdatour.user;

import java.util.List;

import javax.servlet.http.HttpSession;

public interface UserService {
	public List<UserDTO> selectAllUser();

	public UserDTO selectByID(String user_id);

	public int serv_userInsert(UserDTO userdto);

	public int serv_userUpdate(UserDTO userdto);

	public int serv_userDelete(int user_num); 
	
	public boolean loginCheck(UserDTO userdto, HttpSession session);
	//로그인체크
	public UserDTO viewUser(UserDTO userdto);
	//회원 정보 
	public void logout(HttpSession session);
	 //회원 로그아웃
	 
}
