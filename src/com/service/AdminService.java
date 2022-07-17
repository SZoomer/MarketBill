package com.service;

import com.model.Admin;

public interface AdminService {
	
	boolean addAdmin(Admin admin);

	boolean loginAdmin(String username, String password);

}
