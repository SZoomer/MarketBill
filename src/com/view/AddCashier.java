package com.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.model.Cashier;
import com.service.CashierService;
import com.service.CashierServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;
import javax.swing.JSeparator;


public class AddCashier extends JFrame {

	private JPanel contentPane;
	private JLabel acd;
	private JLabel names;
	private JTextField nameTxt;
	private JLabel address;
	private JTextField addressTxt;
	private JLabel mobileno;
	private JTextField mobileTxt;
	private JLabel email;
	private JTextField emailTxt;
	private JLabel password;
	private JTextField passwordTxt;
	private JButton addBtn;
	private JButton updateBtn;
	private JButton deleteBtn;
	private JScrollPane scrollPane;
	private JTable table;
	protected int cid;
	private JSeparator separator;
	private JLabel copyright;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCashier frame = new AddCashier();
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
	public AddCashier() {
		setTitle("Add Cashier");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1387, 882);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getAcd());
		contentPane.add(getNames());
		contentPane.add(getNameTxt());
		contentPane.add(getAddress());
		contentPane.add(getAddressTxt());
		contentPane.add(getMobileno());
		contentPane.add(getMobileTxt());
		contentPane.add(getEmail());
		contentPane.add(getEmailTxt());
		contentPane.add(getPassword());
		contentPane.add(getPasswordTxt());
		contentPane.add(getAddBtn());
		contentPane.add(getUpdateBtn());
		contentPane.add(getDeleteBtn());
		contentPane.add(getScrollPane());
		contentPane.add(getSeparator());
		contentPane.add(getCopyright());
		displayTable();
	}

	private JLabel getAcd() {
		if (acd == null) {
			acd = new JLabel("Add Cashier Details");
			acd.setForeground(new Color(255, 0, 0));
			acd.setBackground(new Color(255, 165, 0));
			acd.setFont(new Font("Tahoma", Font.BOLD, 20));
			acd.setBounds(149, 46, 217, 37);
		}
		return acd;
	}
	private JLabel getNames() {
		if (names == null) {
			names = new JLabel("Name : ");
			names.setFont(new Font("Tahoma", Font.BOLD, 18));
			names.setBounds(62, 128, 78, 37);
		}
		return names;
	}
	
	private JTextField getNameTxt() {
		if (nameTxt == null) {
			nameTxt = new JTextField();
			nameTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
			nameTxt.setBounds(231, 129, 309, 37);
			nameTxt.setColumns(10);
		}
		return nameTxt;
	}
	private JLabel getAddress() {
		if (address == null) {
			address = new JLabel("Address : ");
			address.setFont(new Font("Tahoma", Font.BOLD, 18));
			address.setBounds(62, 192, 91, 37);
		}
		return address;
	}
	private JTextField getAddressTxt() {
		if (addressTxt == null) {
			addressTxt = new JTextField();
			addressTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
			addressTxt.setBounds(231, 193, 309, 37);
			addressTxt.setColumns(10);
		}
		return addressTxt;
	}
	private JLabel getMobileno() {
		if (mobileno == null) {
			mobileno = new JLabel("Mobile Number : ");
			mobileno.setFont(new Font("Tahoma", Font.BOLD, 18));
			mobileno.setBounds(62, 252, 167, 37);
		}
		return mobileno;
	}
	private JTextField getMobileTxt() {
		if (mobileTxt == null) {
			mobileTxt = new JTextField();
			mobileTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
			mobileTxt.setBounds(231, 255, 309, 37);
			mobileTxt.setColumns(10);
		}
		return mobileTxt;
	}
	private JLabel getEmail() {
		if (email == null) {
			email = new JLabel("Email Address : ");
			email.setFont(new Font("Tahoma", Font.BOLD, 18));
			email.setBounds(62, 309, 161, 37);
		}
		return email;
	}
	private JTextField getEmailTxt() {
		if (emailTxt == null) {
			emailTxt = new JTextField();
			emailTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
			emailTxt.setBounds(231, 312, 309, 37);
			emailTxt.setColumns(10);
		}
		return emailTxt;
	}
	private JLabel getPassword() {
		if (password == null) {
			password = new JLabel("Password : ");
			password.setFont(new Font("Tahoma", Font.BOLD, 18));
			password.setBounds(62, 372, 135, 37);
		}
		return password;
	}
	private JTextField getPasswordTxt() {
		if (passwordTxt == null) {
			passwordTxt = new JTextField();
			passwordTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
			passwordTxt.setBounds(231, 375, 309, 37);
			passwordTxt.setColumns(10);
		}
		return passwordTxt;
	}
	private JButton getAddBtn() {
		if (addBtn == null) {
			addBtn = new JButton("Add");
			addBtn.setBackground(new Color(50, 205, 50));
			addBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
			addBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if (validation()) {

						Cashier cashier = new Cashier();
						cashier.setAddress(addressTxt.getText().trim());
						cashier.setEmail(emailTxt.getText().trim());
						cashier.setMobilenumber(mobileTxt.getText().trim());
						cashier.setPassword(new String(passwordTxt.getText()).trim());
						cashier.setName(nameTxt.getText().trim());

						CashierService cs = new CashierServiceImpl();
						boolean flag = cs.addCashier(cashier);

						if (flag) {
							JOptionPane.showMessageDialog(contentPane, "Cashier Added");
							clearForm();
							displayTable();
						} else {
							JOptionPane.showMessageDialog(contentPane, "Not added");
						}
					}
					
				}
			});
			addBtn.setBounds(62, 472, 135, 37);
		}
		return addBtn;
	}
	private JButton getUpdateBtn() {
		if (updateBtn == null) {
			updateBtn = new JButton("Update");
			updateBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int selectRow = table.getSelectedRow();
					if (selectRow == -1) {
						JOptionPane.showMessageDialog(contentPane, "No Row selected");
					}

					else {

						if (validation()) {
							Cashier cashier = new Cashier();
							cashier.setId(cid);
							cashier.setAddress(addressTxt.getText().trim());
							cashier.setEmail(emailTxt.getText().trim());
							cashier.setMobilenumber(mobileTxt.getText().trim());
							cashier.setName(nameTxt.getText().trim());
							cashier.setPassword(new String(passwordTxt.getText()).trim());

							CashierService cs = new CashierServiceImpl();
							boolean flag = cs.updateCashier(cashier);

							if (flag) {
								JOptionPane.showMessageDialog(contentPane, "Update Success");
								clearForm();
								displayTable();
							} else {
								JOptionPane.showMessageDialog(contentPane, "Update Failed");
							}
						}
					}
					
					
				}
			});
			updateBtn.setBackground(new Color(100, 149, 237));
			updateBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
			updateBtn.setBounds(231, 472, 135, 37);
		}
		return updateBtn;
	}
	private JButton getDeleteBtn() {
		if (deleteBtn == null) {
			deleteBtn = new JButton("Delete");
			deleteBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int selectedRow = table.getSelectedRow();
					if (selectedRow == -1) {
						JOptionPane.showMessageDialog(table, "No row selected");
					} else {
						CashierService cs = new CashierServiceImpl();
						cid = (int)table.getValueAt(selectedRow, 0);
						boolean flag = cs.deleteCashier(cid);
						if (flag) {
							JOptionPane.showMessageDialog(table, "Delete Success");
							clearForm();
							displayTable();
						} else {
							JOptionPane.showMessageDialog(table, "Delete Failed");
						}
					}
				}
			});
			deleteBtn.setBackground(new Color(255, 69, 0));
			deleteBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
			deleteBtn.setBounds(405, 472, 135, 37);
		}
		return deleteBtn;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBackground(new Color(189, 183, 107));
			scrollPane.setFont(new Font("Tahoma", Font.BOLD, 12));
			scrollPane.setBounds(631, 128, 708, 381);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setRowHeight(18);
			table.setBackground(new Color(220, 220, 220));
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int selectedRow = table.getSelectedRow();
					int id = (int) table.getModel().getValueAt(selectedRow, 0);
					cid = id;
					setEditData();		
				}
			});
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Name", "Address", "Mobile Number", "Email", "Password"
				}
			));
			table.setBorder(new LineBorder(new Color(0, 0, 0)));
			table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return table;
	}
	
	
	private void displayTable() {
		DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
		tmodel.setRowCount(0);

		CashierService cs = new CashierServiceImpl();
		List<Cashier> cashierList = cs.getAllCashier();
		for (Cashier cashier : cashierList) {
			tmodel.addRow(new Object[] { cashier.getId(), cashier.getName(), cashier.getMobilenumber(),
					cashier.getAddress(), cashier.getEmail(), cashier.getPassword() });
		}

	}

	private void clearForm() {
		nameTxt.setText("");
		emailTxt.setText("");
		mobileTxt.setText("");
		passwordTxt.setText("");
		addressTxt.setText("");
	}

	private boolean validation() {
		if (nameTxt.getText().isBlank()) {
			JOptionPane.showMessageDialog(nameTxt, "Name required");
			return false;
		}

		if (emailTxt.getText().isBlank()) {
			JOptionPane.showMessageDialog(emailTxt, "Email required");
			return false;
		}

		if (mobileTxt.getText().isBlank()) {
			JOptionPane.showMessageDialog(mobileTxt, "Mobilenumber required");
			return false;
		}

		if (addressTxt.getText().isBlank()) {
			JOptionPane.showMessageDialog(addressTxt, "Address required");
			return false;
		}

		if (String.valueOf(new String(passwordTxt.getText())).isBlank()) {
			JOptionPane.showMessageDialog(passwordTxt, "Password required");
			return false;
		}
		return true;
	}

	private void setEditData() {
		CashierService cs = new CashierServiceImpl();
		Cashier cashier = cs.getCashierById(cid);

		nameTxt.setText(cashier.getName());
		addressTxt.setText(cashier.getAddress());
		emailTxt.setText(cashier.getEmail());
		mobileTxt.setText(cashier.getMobilenumber());
		passwordTxt.setText(cashier.getPassword());
	}
	
	
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBackground(Color.BLACK);
			separator.setBounds(10, 687, 1353, 2);
		}
		return separator;
	}
	private JLabel getCopyright() {
		if (copyright == null) {
			copyright = new JLabel("Copyright @ 2022 PP | All Rights Reserved");
			copyright.setFont(new Font("Tahoma", Font.PLAIN, 16));
			copyright.setBounds(509, 709, 329, 29);
		}
		return copyright;
	}
}
