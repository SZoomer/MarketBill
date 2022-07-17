package com.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.model.Admin;
import com.service.AdminService;
import com.service.AdminServiceImpl;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSeparator;

public class AdminRegister extends JFrame {

	private JPanel contentPane;
	private JLabel registeradmin;
	private JLabel fname;
	private JTextField fnameTxt;
	private JLabel lname;
	private JTextField lnameTxt;
	private JLabel uname;
	private JTextField usernameTxt;
	private JLabel pword;
	private JTextField passwordTxt;
	private JLabel psword;
	private JTextField repasswordTxt;
	private JLabel dob;
	private JLabel lbladdress;
	private JTextArea addressTxtArea;
	private JButton registerBtn;
	private JButton cancelBtn;
	private JLabel clk;
	private JDateChooser dobTxt;
	private JSeparator separator;
	private JLabel copyright;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminRegister frame = new AdminRegister();
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
	public AdminRegister() {
		setTitle("Admin Register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1031, 807);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(189, 183, 107));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getRegisteradmin());
		contentPane.add(getFname());
		contentPane.add(getFnameTxt());
		contentPane.add(getLname());
		contentPane.add(getLnameTxt());
		contentPane.add(getUname());
		contentPane.add(getUsernameTxt());
		contentPane.add(getPword());
		contentPane.add(getPasswordTxt());
		contentPane.add(getPsword());
		contentPane.add(getRepasswordTxt());
		contentPane.add(getDob());
		contentPane.add(getDobTxt_1());
		contentPane.add(getLbladdress());
		contentPane.add(getAddressTxtArea());
		contentPane.add(getRegisterBtn());
		contentPane.add(getCancelBtn());
		contentPane.add(getClk());
		contentPane.add(getSeparator());
		contentPane.add(getCopyright());
	}
	private JLabel getRegisteradmin() {
		if (registeradmin == null) {
			registeradmin = new JLabel("Register Admin");
			registeradmin.setFont(new Font("Tahoma", Font.BOLD, 28));
			registeradmin.setBounds(370, 56, 260, 33);
		}
		return registeradmin;
	}
	private JLabel getFname() {
		if (fname == null) {
			fname = new JLabel("First Name : ");
			fname.setFont(new Font("Tahoma", Font.BOLD, 18));
			fname.setBounds(131, 140, 125, 40);
		}
		return fname;
	}
	private JTextField getFnameTxt() {
		if (fnameTxt == null) {
			fnameTxt = new JTextField();
			fnameTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
			fnameTxt.setBounds(343, 140, 392, 40);
			fnameTxt.setColumns(10);
		}
		return fnameTxt;
	}
	private JLabel getLname() {
		if (lname == null) {
			lname = new JLabel("Last Name : ");
			lname.setFont(new Font("Tahoma", Font.BOLD, 18));
			lname.setBounds(131, 198, 125, 40);
		}
		return lname;
	}
	private JTextField getLnameTxt() {
		if (lnameTxt == null) {
			lnameTxt = new JTextField();
			lnameTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lnameTxt.setBounds(343, 198, 393, 40);
			lnameTxt.setColumns(10);
		}
		return lnameTxt;
	}
	private JLabel getUname() {
		if (uname == null) {
			uname = new JLabel("Username : ");
			uname.setFont(new Font("Tahoma", Font.BOLD, 18));
			uname.setBounds(131, 258, 118, 40);
		}
		return uname;
	}
	private JTextField getUsernameTxt() {
		if (usernameTxt == null) {
			usernameTxt = new JTextField();
			usernameTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
			usernameTxt.setBounds(343, 258, 392, 40);
			usernameTxt.setColumns(10);
		}
		return usernameTxt;
	}
	private JLabel getPword() {
		if (pword == null) {
			pword = new JLabel("Password : ");
			pword.setFont(new Font("Tahoma", Font.BOLD, 18));
			pword.setBounds(131, 322, 111, 40);
		}
		return pword;
	}
	private JTextField getPasswordTxt() {
		if (passwordTxt == null) {
			passwordTxt = new JTextField();
			passwordTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
			passwordTxt.setBounds(343, 326, 392, 40);
			passwordTxt.setColumns(10);
		}
		return passwordTxt;
	}
	private JLabel getPsword() {
		if (psword == null) {
			psword = new JLabel("Retype Password : ");
			psword.setFont(new Font("Tahoma", Font.BOLD, 18));
			psword.setBounds(131, 385, 178, 33);
		}
		return psword;
	}
	private JTextField getRepasswordTxt() {
		if (repasswordTxt == null) {
			repasswordTxt = new JTextField();
			repasswordTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
			repasswordTxt.setBounds(343, 385, 392, 40);
			repasswordTxt.setColumns(10);
		}
		return repasswordTxt;
	}
	private JLabel getDob() {
		if (dob == null) {
			dob = new JLabel("Date of Birth : ");
			dob.setFont(new Font("Tahoma", Font.BOLD, 18));
			dob.setBounds(131, 439, 163, 40);
		}
		return dob;
	}
	private JLabel getLbladdress() {
		if (lbladdress == null) {
			lbladdress = new JLabel("Address : ");
			lbladdress.setFont(new Font("Tahoma", Font.BOLD, 18));
			lbladdress.setBounds(131, 495, 169, 40);
		}
		return lbladdress;
	}
	private JTextArea getAddressTxtArea() {
		if (addressTxtArea == null) {
			addressTxtArea = new JTextArea();
			addressTxtArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
			addressTxtArea.setBounds(343, 495, 392, 40);
		}
		return addressTxtArea;
	}
	private JButton getRegisterBtn() {
		if (registerBtn == null) {
			registerBtn = new JButton("Register");
			registerBtn.addActionListener(new ActionListener() {
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent e) {
					
					// Validation

					if (fnameTxt.getText().isBlank()) {
						JOptionPane.showMessageDialog(fnameTxt, "First name required");
						return;
					}
					if (lnameTxt.getText().isBlank()) {
						JOptionPane.showMessageDialog(lnameTxt, "Last name required");
						return;
					}
					if (usernameTxt.getText().isBlank()) {
						JOptionPane.showMessageDialog(usernameTxt, "Username required");
						return;
					}
					if (passwordTxt.getText().isBlank()) {
						JOptionPane.showMessageDialog(passwordTxt, "Password required");
						return;
					}

					if (repasswordTxt.getText().isBlank()) {
						JOptionPane.showMessageDialog(passwordTxt, "Re-Password required");
						return;
					}

					if (!passwordTxt.getText().equals(repasswordTxt.getText())) {
						JOptionPane.showMessageDialog(passwordTxt, "Password and Re Password did not match");
						return;
					}

					if (dobTxt.getDate() == null) {
						JOptionPane.showMessageDialog(dobTxt, "Birthdate required");
						return;
					}

					if (addressTxtArea.getText().isBlank()) {
						JOptionPane.showMessageDialog(addressTxtArea, "Address required");
						return;
					}

					Admin admin = new Admin();
					admin.setAddress(addressTxtArea.getText().trim());
					admin.setBirthdate(new Date(dobTxt.getDate().getTime()));
					admin.setFname(fnameTxt.getText().trim());
					admin.setLname(lnameTxt.getText().trim());
					admin.setPassword(passwordTxt.getText().trim());
					admin.setBirthdate(new Date(dobTxt.getDate().getTime()));
					admin.setUsername(usernameTxt.getText().trim());

					AdminService as = new AdminServiceImpl();
					boolean flag = as.addAdmin(admin);

					if (flag) {
						JOptionPane.showMessageDialog(contentPane, "Admin Added");
						addressTxtArea.setText("");
						dobTxt.setDate(null);
						fnameTxt.setText("");
						lnameTxt.setText("");
						passwordTxt.setText("");
						usernameTxt.setText("");
						repasswordTxt.setText("");

					} else {
						JOptionPane.showMessageDialog(contentPane, "Admin not added");
					}
					
					
					
				}
			});
			registerBtn.setBackground(new Color(60, 179, 113));
			registerBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
			registerBtn.setBounds(343, 567, 163, 40);
		}
		return registerBtn;
	}
	private JButton getCancelBtn() {
		if (cancelBtn == null) {
			cancelBtn = new JButton("Cancel");
			cancelBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new AdminLogin().setVisible(true);
					dispose();	
				}
			});
			cancelBtn.setBackground(new Color(255, 69, 0));
			cancelBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
			cancelBtn.setBounds(556, 567, 179, 40);
		}
		return cancelBtn;
	}
	private JLabel getClk() {
		if (clk == null) {
			clk = new JLabel("Click Here to login !!!");
			clk.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new AdminLogin().setVisible(true);
					dispose();
				}
			});
			clk.setFont(new Font("Tahoma", Font.BOLD, 16));
			clk.setBounds(449, 626, 192, 40);
		}
		return clk;
	}
	private JDateChooser getDobTxt_1() {
		if (dobTxt == null) {
			dobTxt = new JDateChooser();
			dobTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
			dobTxt.setBounds(343, 439, 392, 40);
		}
		return dobTxt;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBackground(Color.BLACK);
			separator.setBounds(10, 714, 997, 2);
		}
		return separator;
	}
	private JLabel getCopyright() {
		if (copyright == null) {
			copyright = new JLabel("Copyright @ 2022 PP | All Rights Reserved");
			copyright.setFont(new Font("Tahoma", Font.PLAIN, 16));
			copyright.setBounds(370, 729, 335, 20);
		}
		return copyright;
	}
}
