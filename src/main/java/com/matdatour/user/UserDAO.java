package com.matdatour.user;

import java.util.List;

public interface UserDAO {
	public List<UserDTO> selectAll();

	public UserDTO selectByID(String user_id);

	public int userInsert(UserDTO userdto);

	public int userUpdate(UserDTO userdto);

	public int userDelete(int user_num); 
	 
}
