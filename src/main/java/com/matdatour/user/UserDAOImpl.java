package com.matdatour.user;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userdao")
public class UserDAOImpl implements UserDAO {

	@Autowired
	SqlSession sqlSession;

	String namespace = "com.matdatour.user.";
	
	
	//1. 회원 목록
	@Override
	public List<UserDTO> selectAllUser() {
		return sqlSession.selectList(namespace + "selectAllUser");
	}

	@Override
	public UserDTO selectByID(String user_id) {
		System.out.println(user_id);
		return sqlSession.selectOne(namespace + "selectByUserId", user_id);
	}
	
	//회원 등록
	@Override
	public int userInsert(UserDTO userdto) {
		return sqlSession.insert(namespace + "userInsert", userdto);
	}

	@Override
	public int userUpdate(UserDTO userdto) {
		return sqlSession.update(namespace + "userUpdate", userdto);
	}

	@Override
	public int userDelete(int user_num) {
		return sqlSession.delete(namespace + "userDelete", user_num);
	}

	//로그인 체크
	@Override
	public boolean loginCheck(UserDTO userdto) {
		String name = sqlSession.selectOne(namespace + "loginCheck", userdto);
		return (name == null) ? false : true;
	}

	@Override
	public UserDTO viewUser(UserDTO userdto) {
		return sqlSession.selectOne(namespace + "viewUser", userdto);
	}
	
	//로그아웃
	@Override
	public void logout(HttpSession session) {
		// TODO Auto-generated method stub

	}

}
