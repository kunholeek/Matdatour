package com.matdatour.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.matdatour.user.UserDAO;

@Service("adminservice")
public class AdminServiceImpl implements AdminService {

	@Autowired
	@Qualifier("admindao")
	AdminDAO admin;

	public AdminServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public AdminServiceImpl(AdminDAO admin) {
		this.admin = admin;
	}

	public void setDao(AdminDAO admin) {
		this.admin = admin;
	}

	@Override
	public AdminDTO selectByAdminID(String admin_id) {
		return admin.selectByAdminID(admin_id);
	}

}
