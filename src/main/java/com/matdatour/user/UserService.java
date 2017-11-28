package com.matdatour.user;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

public interface UserService {
	public List<UserDTO> selectAllUser();

	public UserDTO selectByID(String user_id);

	public int serv_userInsert(UserDTO userdto);

	public int serv_userUpdate(UserDTO userdto);

	public int serv_userDelete(String user_id); 
	
	public boolean loginCheck(UserDTO userdto, HttpSession session);
	//로그인체크
	public UserDTO viewUser(UserDTO userdto);
	//회원 정보 
	public void logout(HttpSession session);
	 //회원 로그아웃
	
	public UserDTO userPwdCheck(Map<String, String> map);
	
	public UserDTO selectByUserNum(int user_num);
	
	public UserDTO selectByPhone(String user_phone) ;
	
	public UserDTO selectByNick(String user_nick);
	 
}
