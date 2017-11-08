package com.matdatour.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service("userservice")
public class UserServiceImpl implements UserService{
	
	@Autowired
	@Qualifier("userdao")
	UserDAO user;

	public UserServiceImpl() {
	}
	
	public UserServiceImpl(UserDAO user){
		this.user = user;
	}
	
	public void setDao(UserDAO user){
		this.user = user;
	}
	
	
	@Override
	public List<UserDTO> selectAll() {
		return user.selectAll();
	}

	@Override
	public UserDTO selectByID(String user_id) {
		return user.selectByID(user_id);
	}

	@Override
	public int serv_userInsert(UserDTO userdto) {
		return user.userInsert(userdto);
	}

	@Override
	public int serv_userUpdate(UserDTO userdto) {
		return user.userUpdate(userdto);
	}

	@Override
	public int serv_userDelete(int user_num) {
		return user.userDelete(user_num);
	}

}
