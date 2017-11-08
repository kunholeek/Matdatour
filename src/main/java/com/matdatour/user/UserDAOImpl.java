package com.matdatour.user;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userdao")
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	SqlSession sqlSession;

	String namespace = "com.matdatour.user.";

	@Override
	public List<UserDTO> selectAll() {
		System.out.println("모두조회:" + sqlSession);
		return sqlSession.selectList(namespace + "selectAllUser");
	}

	@Override
	public UserDTO selectByID(String user_id) {
		System.out.println("user_id으로 회원 조회:" + user_id);
		return sqlSession.selectOne(namespace + "selectByUserId", user_id);
	}

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

}
