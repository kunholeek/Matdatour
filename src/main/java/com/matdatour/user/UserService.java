package com.matdatour.user;

import java.util.List;

public interface UserService {
	public List<UserDTO> selectAll();

	public UserDTO selectByID(String user_id);

	public int serv_userInsert(UserDTO userdto);

	public int serv_userUpdate(UserDTO userdto);

	public int serv_userDelete(int user_num); 
	 
}
