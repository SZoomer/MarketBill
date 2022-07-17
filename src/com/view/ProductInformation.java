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
import com.service.ProductServiceImpl;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Color;

public class ProductInformation extends JFrame {

	private JPanel contentPane;
	private JLabel productinformation;
	private JLabel productname;
	private JTextField productnameTxt;
	private JButton searchBtn;
	private JScrollPane scrollPane;
	private JTable table;
	private JSeparator separator;
	private JLabel copyright;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductInformation frame = new ProductInformation();
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
	public ProductInformation() {
		setBackground(Color.LIGHT_GRAY);
		setTitle("Product Information");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1088, 731);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getProductinformation());
		contentPane.add(getProductname());
		contentPane.add(getProductnameTxt());
		contentPane.add(getSearchBtn());
		contentPane.add(getScrollPane());
		contentPane.add(getSeparator());
		contentPane.add(getCopyright());
	}

	private JLabel getProductinformation() {
		if (productinformation == null) {
			productinformation = new JLabel("Product Information");
			productinformation.setFont(new Font("Tahoma", Font.BOLD, 32));
			productinformation.setBounds(323, 34, 354, 32);
		}
		return productinformation;
	}
	private JLabel getProductname() {
		if (productname == null) {
			productname = new JLabel("Product Name : ");
			productname.setFont(new Font("Tahoma", Font.BOLD, 18));
			productname.setBounds(77, 114, 150, 32);
		}
		return productname;
	}
	private JTextField getProductnameTxt() {
		if (productnameTxt == null) {
			productnameTxt = new JTextField();
			productnameTxt.setBounds(237, 114, 299, 32);
			productnameTxt.setColumns(10);
		}
		return productnameTxt;
	}
	private JButton getSearchBtn() {
		if (searchBtn == null) {
			searchBtn = new JButton("Search");
			searchBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String productname = productnameTxt.getText().trim();
					List<Product> productList = new ProductServiceImpl().getProductByProductname(productname);

					if (productList.isEmpty()) {
						JOptionPane.showMessageDialog(contentPane, "Product Not Found");
					}
					dislayDataTable(productList);
					clearForm();
				}
			});
			searchBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
			searchBtn.setBounds(698, 114, 166, 32);
		}
		return searchBtn;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(77, 179, 949, 278);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setFont(new Font("Tahoma", Font.BOLD, 14));
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Product ID", "Product Name", "Available Quantity", "Added Quantity", "MRP"
				}
			));
		}
		return table;
	}
	private void clearForm() {
		productnameTxt.setText("");

	}

	private void dislayDataTable(List<Product> productList) {
		DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
		tmodel.setRowCount(0);
		for (Product product : productList) {
			tmodel.addRow(new Object[] { product.getPid(), product.getProductname(), product.getAvailablequantity(), product.getAddedquantity(), product.getMrp() });
		}
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBackground(Color.BLACK);
			separator.setBounds(10, 635, 1041, 2);
		}
		return separator;
	}
	private JLabel getCopyright() {
		if (copyright == null) {
			copyright = new JLabel("Copyright @ 2022 PP | All Rights Reserved");
			copyright.setFont(new Font("Tahoma", Font.PLAIN, 16));
			copyright.setBounds(416, 659, 322, 25);
		}
		return copyright;
	}
}
