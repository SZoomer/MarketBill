package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.db.DB;
import com.model.Bill;

public class BillServiceImpl implements BillService {
	
	
	@Override
	public List<Bill> getAllBill() {
		List<Bill> billList = new ArrayList<>();
		String sql = "select * from bill";
		Connection conn = DB.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Bill bill = new Bill();
				bill.setBillnumber(rs.getInt("billnumber"));
				bill.setBillDate(rs.getDate("billdate"));
				bill.setCustomerName(rs.getString("customername"));
				bill.setDiscount(rs.getInt("discount"));
				bill.setPrice(rs.getInt("price"));
				bill.setProductId(rs.getInt("productid"));
				bill.setProductName(rs.getString("productname"));
				bill.setQuantity(rs.getInt("quantity"));
				billList.add(bill);
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
		return billList;
	}

	@Override
	public boolean addBill(Bill bill) {
		String sql = "insert into bill (billnumber,customername,productid,productname,quantity,discount,billdate,price,mrp) values (?,?,?,?,?,?,?,?,?)";
		Connection conn = DB.getConnection();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bill.getBillnumber());
			pstmt.setString(2, bill.getCustomerName());
			pstmt.setInt(3, bill.getProductId());
			pstmt.setString(4, bill.getProductName());
			pstmt.setInt(5, bill.getQuantity());
			pstmt.setInt(6, bill.getDiscount());
			pstmt.setDate(7, bill.getBillDate());
			pstmt.setInt(8, bill.getPrice());
			pstmt.setInt(9, bill.getMrp());

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
	public Bill getBillById(int id) {
		Bill bill = new Bill();
		Connection conn = DB.getConnection();

		String sql = "select * from bill where billnumber=" + id;

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				bill.setBillDate(rs.getDate("billdate"));
				bill.setBillnumber(rs.getInt("billnumber"));
				bill.setCustomerName(rs.getString("customername"));
				bill.setDiscount(rs.getInt("discount"));
				bill.setPrice(rs.getInt("price"));
				bill.setProductId(rs.getInt("productid"));
				bill.setProductName(rs.getString("productname"));
				bill.setQuantity(rs.getInt("quantity"));
				bill.setMrp(rs.getInt("mrp"));
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
		return bill;
	}

	@Override
	public boolean deleteBill(int id) {
		String sql = "delete from bill where billnumber=" + id;
		Connection conn = DB.getConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			stmt.execute(sql);
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
}
