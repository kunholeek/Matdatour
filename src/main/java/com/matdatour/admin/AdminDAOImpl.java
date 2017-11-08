package com.matdatour.admin;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("admindao")
public class AdminDAOImpl implements AdminDAO {

	@Autowired
	SqlSession sqlSession;

	String namespace = "com.matdatour.admin.";

	@Override
	public AdminDTO selectByAdminID(String admin_id) {

		System.out.println("admin_id으로 회원 조회:" + admin_id);
		return sqlSession.selectOne(namespace + "selectByAdminID", admin_id);
	}

}
