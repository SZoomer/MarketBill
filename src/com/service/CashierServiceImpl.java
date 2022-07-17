package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.db.DB;
import com.model.Cashier;

public class CashierServiceImpl implements CashierService{
	
	public boolean addCashier(Cashier cashier) {
		String sql = "insert into cashier (name,mobilenumber,address,email,password) values (?,?,?,?,?)";
		Connection conn = DB.getConnection();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cashier.getName());
			pstmt.setString(2, cashier.getMobilenumber());
			pstmt.setString(3, cashier.getAddress());
			pstmt.setString(4, cashier.getEmail());
			pstmt.setString(5, cashier.getPassword());

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
	public List<Cashier> getAllCashier() {
		List<Cashier> cashierList = new ArrayList<>();
		String sql = "select * from cashier";
		Connection conn = DB.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Cashier cashier = new Cashier();
				cashier.setId(rs.getInt("id"));
				cashier.setAddress(rs.getString("address"));
				cashier.setEmail(rs.getString("email"));
				cashier.setMobilenumber(rs.getString("mobilenumber"));
				cashier.setName(rs.getString("name"));
				cashier.setPassword(rs.getString("password"));
				cashierList.add(cashier);
			}

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
		return cashierList;
	}

	@Override
	public Cashier getCashierById(int id) {
		Cashier cashier = new Cashier();
		Connection conn = DB.getConnection();

		String sql = "select * from cashier where id=" + id;

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				cashier.setAddress(rs.getString("address"));
				cashier.setEmail(rs.getString("email"));
				cashier.setId(rs.getInt("id"));
				cashier.setMobilenumber(rs.getString("mobilenumber"));
				cashier.setName(rs.getString("name"));
				cashier.setPassword(rs.getString("password"));
			}
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
		return cashier;
	}

	@Override
	public boolean updateCashier(Cashier cashier) {
		String sql = "update cashier set name=?,email=?,password=?,mobilenumber=?,address=? where id=?";
		Connection conn = DB.getConnection();
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, cashier.getName());
			pstm.setString(2, cashier.getEmail());
			pstm.setString(3, cashier.getPassword());
			pstm.setString(4, cashier.getMobilenumber());
			pstm.setString(5, cashier.getAddress());
			pstm.setInt(6, cashier.getId());

			pstm.execute();
			return true;
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

	@Override
	public boolean deleteCashier(int id) {
		String sql = "delete from cashier where id=" + id;
		Connection conn = DB.getConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			stmt.execute(sql);
			return true;
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

	@Override
	public boolean loginCashier(String email, String password) {
		String sql = "select * from cashier where email=? and password=?";
		Connection conn = DB.getConnection();
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, email);
			pstm.setString(2, password);

			ResultSet rs = pstm.executeQuery();
			return rs.next();

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
