package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.db.DB;
import com.model.Admin;

public class AdminServiceImpl implements AdminService {
	
	@Override
	public boolean addAdmin(Admin admin) {
		String sql = "insert into admin (fname,lname,username,password,birthdate,address) values (?,?,?,?,?,?)";
		Connection conn = DB.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, admin.getFname());
			pstmt.setString(2, admin.getLname());
			pstmt.setString(3, admin.getUsername());
			pstmt.setString(4, admin.getPassword());
			pstmt.setDate(5, admin.getBirthdate());
			pstmt.setString(6, admin.getAddress());

			pstmt.execute();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	@Override
	public boolean loginAdmin(String username, String password) {
		Connection conn = DB.getConnection();
		String sql = "select * from admin where username=? and password=?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, username);
			pstm.setString(2, password);

			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

}

