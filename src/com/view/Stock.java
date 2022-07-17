package com.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.model.Product;
import com.service.ProductService;
import com.service.ProductServiceImpl;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JSeparator;

public class Stock extends JFrame {

	private JPanel contentPane;
	private JLabel updatestock;
	private JLabel pid;
	private JTextField pidTxt;
	private JLabel productname;
	private JTextField productnameTxt;
	private JLabel availablequantity;
	private JTextField avaquantityTxt;
	private JLabel addedquantity;
	private JTextField addquantityTxt;
	private JLabel mrp;
	private JTextField mrpTxt;
	private JButton addBtn;
	private JButton updateBtn;
	private JScrollPane scrollPane;
	private JTable table;
	private int id;
	private JSeparator separator;
	private JLabel copyright;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stock frame = new Stock();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Stock() {
		setTitle("Update Stock");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1297, 760);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 250, 210));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getUpdatestock());
		contentPane.add(getPid());
		contentPane.add(getPidTxt());
		contentPane.add(getProductname());
		contentPane.add(getProductnameTxt());
		contentPane.add(getAvailablequantity());
		contentPane.add(getAvaquantityTxt());
		contentPane.add(getAddedquantity());
		contentPane.add(getAddquantityTxt());
		contentPane.add(getMrp());
		contentPane.add(getMrpTxt());
		contentPane.add(getAddBtn());
		contentPane.add(getUpdateBtn());
		contentPane.add(getScrollPane());
		contentPane.add(getSeparator());
		contentPane.add(getCopyright());
		
	}

	private JLabel getUpdatestock() {
		if (updatestock == null) {
			updatestock = new JLabel("Update Stock");
			updatestock.setFont(new Font("Tahoma", Font.BOLD, 32));
			updatestock.setBounds(144, 38, 218, 49);
		}
		return updatestock;
	}
	private JLabel getPid() {
		if (pid == null) {
			pid = new JLabel("Product ID : ");
			pid.setFont(new Font("Tahoma", Font.BOLD, 18));
			pid.setBounds(73, 124, 118, 32);
		}
		return pid;
	}
	private JTextField getPidTxt() {
		if (pidTxt == null) {
			pidTxt = new JTextField();
			pidTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
			pidTxt.setBounds(263, 125, 320, 32);
			pidTxt.setColumns(10);
		}
		return pidTxt;
	}
	private JLabel getProductname() {
		if (productname == null) {
			productname = new JLabel("Product Name : ");
			productname.setFont(new Font("Tahoma", Font.BOLD, 18));
			productname.setBounds(73, 187, 150, 32);
		}
		return productname;
	}
	private JTextField getProductnameTxt() {
		if (productnameTxt == null) {
			productnameTxt = new JTextField();
			productnameTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
			productnameTxt.setBounds(263, 187, 320, 32);
			productnameTxt.setColumns(10);
		}
		return productnameTxt;
	}
	private JLabel getAvailablequantity() {
		if (availablequantity == null) {
			availablequantity = new JLabel("Availabe Quantity : ");
			availablequantity.setFont(new Font("Tahoma", Font.BOLD, 18));
			availablequantity.setBounds(73, 244, 185, 32);
		}
		return availablequantity;
	}
	private JTextField getAvaquantityTxt() {
		if (avaquantityTxt == null) {
			avaquantityTxt = new JTextField();
			avaquantityTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
			avaquantityTxt.setBounds(263, 244, 320, 32);
			avaquantityTxt.setColumns(10);
		}
		return avaquantityTxt;
	}
	private JLabel getAddedquantity() {
		if (addedquantity == null) {
			addedquantity = new JLabel("Added Quantity : ");
			addedquantity.setFont(new Font("Tahoma", Font.BOLD, 18));
			addedquantity.setBounds(73, 302, 169, 32);
		}
		return addedquantity;
	}
	private JTextField getAddquantityTxt() {
		if (addquantityTxt == null) {
			addquantityTxt = new JTextField();
			addquantityTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
			addquantityTxt.setBounds(263, 302, 320, 32);
			addquantityTxt.setColumns(10);
		}
		return addquantityTxt;
	}
	private JLabel getMrp() {
		if (mrp == null) {
			mrp = new JLabel("MRP : ");
			mrp.setFont(new Font("Tahoma", Font.BOLD, 18));
			mrp.setBounds(73, 354, 150, 32);
		}
		return mrp;
	}
	private JTextField getMrpTxt() {
		if (mrpTxt == null) {
			mrpTxt = new JTextField();
			mrpTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
			mrpTxt.setBounds(263, 358, 320, 32);
			mrpTxt.setColumns(10);
		}
		return mrpTxt;
	}
	private JButton getAddBtn() {
		if (addBtn == null) {
			addBtn = new JButton("Add");
			addBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if (validation()) {
						Product product = new Product();
						product.setId(id);
						product.setPid(Integer.valueOf(pidTxt.getText().trim()));
						product.setProductname(productnameTxt.getText().trim());
						product.setAvailablequantity(Integer.valueOf(avaquantityTxt.getText().trim()));
						product.setAddedquantity(Integer.valueOf(addquantityTxt.getText().trim()));
						product.setMrp(Integer.valueOf(mrpTxt.getText().trim()));

						ProductService ps = new ProductServiceImpl();
						boolean flag = ps.addProduct(product);

						if (flag) {
							JOptionPane.showMessageDialog(contentPane, "Product Added");
							clearForm();
							displayTable();
						} else {
							JOptionPane.showMessageDialog(contentPane, "Product Not Added");
							clearForm();
						}
					}
					
				}
			});
			addBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
			addBtn.setBounds(263, 436, 150, 40);
		}
		return addBtn;
	}
	private JButton getUpdateBtn() {
		if (updateBtn == null) {
			updateBtn = new JButton("Update");
			updateBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {					
					if (table.getSelectedRow() == -1) {
						JOptionPane.showMessageDialog(table, "No row selected");
					} else {
						if (validation()) {
							Product product = new Product();

							product.setPid(Integer.valueOf(pidTxt.getText().trim()));
							product.setProductname(productnameTxt.getText().trim());
							product.setAvailablequantity(Integer.valueOf(avaquantityTxt.getText().trim()));
							product.setAddedquantity(Integer.valueOf(addquantityTxt.getText().trim()));
							product.setMrp(Integer.valueOf(mrpTxt.getText().trim()));

							ProductService ps = new ProductServiceImpl();
							boolean flag = ps.updateProduct(product);
							if (flag) {
								JOptionPane.showMessageDialog(contentPane, "Product Updated");
								clearForm();
								displayTable();
							} else {
								JOptionPane.showMessageDialog(contentPane, "Product Update Failed");
								clearForm();
							}
						}
					}
				}
			});
			updateBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
			updateBtn.setBounds(433, 436, 150, 40);
		}
		return updateBtn;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(626, 124, 647, 352);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int selectedRow = table.getSelectedRow();
					int id = (int) table.getModel().getValueAt(selectedRow, 0);
					setEditData();
					
				}
			});
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"ID", "Product ID", "Product Name", "Available Quantity", "Added Quantity", "MRP"
				}
			));
		}
		return table;
	}
	
	private boolean validation() {
		if (pidTxt.getText().isBlank()) {
			JOptionPane.showMessageDialog(pidTxt, "Product ID required");
			return false;
		}

		if (productnameTxt.getText().isBlank()) {
			JOptionPane.showMessageDialog(productnameTxt, "Product Name required");
			return false;
		}

		if (avaquantityTxt.getText().isBlank()) {
			JOptionPane.showMessageDialog(avaquantityTxt, "Available quantity required");
			return false;
		}

		if (addquantityTxt.getText().isBlank()) {
			JOptionPane.showMessageDialog(addquantityTxt, "Added quantity required");
			return false;
		}

		if (mrpTxt.getText().isBlank()) {
			JOptionPane.showMessageDialog(mrpTxt, "Marked Price required");
			return false;
		}

		return true;
	}
	
	private void displayTable() {
		DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
		tmodel.setRowCount(0);

		ProductService ps = new ProductServiceImpl();
		List<Product> productList = ps.getAllProduct();
		for (Product product : productList) {
			tmodel.addRow(new Object[] { product.getId(), product.getPid(), product.getProductname(), product.getAvailablequantity(),
					product.getAddedquantity(), product.getMrp() });
		}
	
}
	private void clearForm() {
		pidTxt.setText("");
		productnameTxt.setText("");
		avaquantityTxt.setText("");
		addquantityTxt.setText("");
		mrpTxt.setText("");
	
}
	
	private void setEditData() {
		ProductService ps = new ProductServiceImpl();
		Product product = ps.getProductById(id);

		pidTxt.setText("" + product.getPid());
		productnameTxt.setText(product.getProductname());
		avaquantityTxt.setText("" + product.getAvailablequantity());
		addquantityTxt.setText(""+product.getAddedquantity());
		mrpTxt.setText("" + product.getMrp());
	}
	
	
	
	
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBackground(Color.BLACK);
			separator.setForeground(Color.LIGHT_GRAY);
			separator.setBounds(10, 652, 1263, 2);
		}
		return separator;
	}
	private JLabel getCopyright() {
		if (copyright == null) {
			copyright = new JLabel("Copyright @ 2022 PP | All Rights Reserved");
			copyright.setFont(new Font("Tahoma", Font.PLAIN, 16));
			copyright.setBounds(452, 677, 337, 24);
		}
		return copyright;
	}
}
