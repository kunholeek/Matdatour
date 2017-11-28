package com.matdatour.user;

import java.util.List;
import java.util.Map;

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
	public int userDelete(String user_id) {
		return sqlSession.delete(namespace + "userDelete", user_id);
	}

	//로그인 체크
	@Override
	public boolean loginCheck(UserDTO userdto) {
		UserDTO user2 = sqlSession.selectOne(namespace + "loginCheck", userdto);
		return (user2 == null) ? false : true;
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

	@Override
	public UserDTO selectByUserNum(int user_num) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "selectByUserId", user_num);
	}

	@Override
	public UserDTO selectByPhone(String user_phone)   {
		// TODO Auto-generated method stub
		return  sqlSession.selectOne(namespace+"selectByUserPhone", user_phone) ;
	}

	@Override
	public UserDTO selectByNick(String user_nick) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+"selectByUserNick", user_nick);
	}

	@Override
	public UserDTO userPwdCheck(Map<String, String> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+"checkPwd", map);
	}

}
