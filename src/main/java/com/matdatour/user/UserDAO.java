package com.matdatour.user;

import java.util.List;

import javax.servlet.http.HttpSession;

public interface UserDAO {
	public List<UserDTO> selectAllUser();

	public UserDTO selectByID(String user_id);

	public int userInsert(UserDTO userdto);

	public int userUpdate(UserDTO userdto);

	public int userDelete(int user_num); 
	
	public boolean loginCheck(UserDTO userdto);
	//로그인체크
	public UserDTO viewUser(UserDTO userdto);
	//회원 정보 
	public void logout(HttpSession session);
	 //회원 로그아웃
}
