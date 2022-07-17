package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.db.DB;
import com.model.Product;

public class ProductServiceImpl implements ProductService{
	
	@Override
	public boolean addProduct(Product product) {
		String sql = "insert into product (id,pid,productname,availablequantity,addedquantity,mrp) values(?,?,?,?,?,?)";
		Connection conn = DB.getConnection();
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, product.getId());
			pstm.setInt(2, product.getPid());
			pstm.setString(3, product.getProductname());
			pstm.setInt(4, product.getAvailablequantity());
			pstm.setInt(5, product.getAddedquantity());
			pstm.setInt(6, product.getMrp());

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
	public List<Product> getAllProduct() {
		List<Product> productList = new ArrayList<>();
		String sql = "select * from product";

		Connection conn = DB.getConnection();

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setPid(rs.getInt("pid"));
				product.setProductname(rs.getString("productname"));
				product.setAvailablequantity(rs.getInt("availablequantity"));
				product.setAddedquantity(rs.getInt("addedquantity"));
				product.setMrp(rs.getInt("mrp"));
				productList.add(product);
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
		return productList;
	}

	@Override
	public Product getProductById(int id) {
		Product product = new Product();
		Connection conn = DB.getConnection();
		String sql = "select * from product where id=" + id;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {
				product.setId(rs.getInt("id"));
				product.setPid(rs.getInt("pid"));
				product.setProductname(rs.getString("productname"));
				product.setAvailablequantity(rs.getInt("availablequantity"));
				product.setAddedquantity(rs.getInt("addedquantity"));
				product.setMrp(rs.getInt("mrp"));
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
		return product;
	}

	@Override
	public boolean updateProduct(Product product) {
		String sql = "update product set pid=?,productname=?,availablequantity=?,addedquantity=?,mrp=? where id=?";
		Connection conn = DB.getConnection();
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			
			pstm.setInt(1, product.getPid());
			pstm.setString(2, product.getProductname());
			pstm.setInt(3, product.getAvailablequantity());
			pstm.setInt(4, product.getAddedquantity());
			pstm.setInt(5, product.getMrp());

			pstm.execute();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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
	public List<Product> getProductByProductname(String productname) {
		List<Product> productList = new ArrayList<>();
		Connection conn = DB.getConnection();
		String sql = "select * from product where productname like'%" + productname + "%'";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Product product = new Product();		
				product.setId(rs.getInt("id"));
				product.setPid(rs.getInt("pid"));
				product.setProductname(rs.getString("productname"));
				product.setAvailablequantity(rs.getInt("availablequantity"));
				product.setAddedquantity(rs.getInt("addedquantity"));
				product.setMrp(rs.getInt("mrp"));
				productList.add(product);
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
		return productList;
	}

}
