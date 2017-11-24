package com.matdatour.user;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("userservice")
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("userdao")
	UserDAO user;

	public UserServiceImpl() {
	}

	public UserServiceImpl(UserDAO user) {
		this.user = user;
	}

	public void setDao(UserDAO user) {
		this.user = user;
	}

	@Override
	public List<UserDTO> selectAllUser() {
		return user.selectAllUser();
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

	// 1. 회원 로그인 체크
	@Override
	public boolean loginCheck(UserDTO userdto, HttpSession session) {
		boolean result = user.loginCheck(userdto);
		if (result) { // true일 경우 세션에 등록
			UserDTO userdto2 = viewUser(userdto);
			// 세션 변수 등록

			session.setAttribute("user_num", userdto2.getUser_num());
			session.setAttribute("user_id", userdto2.getUser_id());
			session.setAttribute("user_nick", userdto2.getUser_nick());
			session.setAttribute("user_phone", userdto2.getUser_phone());
		}
		return result;
	}

	// 2. 회원 로그인 정보
	@Override
	public UserDTO viewUser(UserDTO userdto) {
		return user.viewUser(userdto);
	}

	// 3. 회원 로그아웃
	@Override
	public void logout(HttpSession session) {
		// 세션 변수 개별 삭제
		// session.removeAttribute("userId");
		// 세션 정보를 초기화 시킴
		session.invalidate();
	}

	@Override
	public UserDTO selectByUserNum(int user_num) {
		// TODO Auto-generated method stub
		return user.selectByUserNum(user_num);
	}

}
