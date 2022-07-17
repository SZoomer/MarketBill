package com.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;

import com.service.AdminService;
import com.service.AdminServiceImpl;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;

public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JLabel adminloginform;
	private JLabel uname;
	private JTextField usernameTxt;
	private JLabel pword;
	private JTextField passwordTxt;
	private JButton loginBtn;
	private JButton cancelBtn;
	private JLabel notaccount;
	private JLabel newaccount;
	private JSeparator separator;
	private JLabel copyright;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
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
	public AdminLogin() {
		setTitle("Admin Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1082, 779);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(189, 183, 107));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getAdminloginform());
		contentPane.add(getUname());
		contentPane.add(getUsernameTxt());
		contentPane.add(getPword());
		contentPane.add(getPasswordTxt());
		contentPane.add(getLoginBtn());
		contentPane.add(getCancelBtn());
		contentPane.add(getNotaccount());
		contentPane.add(getNewaccount());
		contentPane.add(getSeparator());
		contentPane.add(getCopyright());
	}

	private JLabel getAdminloginform() {
		if (adminloginform == null) {
			adminloginform = new JLabel("Admin Login Form");
			adminloginform.setForeground(new Color(0, 0, 128));
			adminloginform.setFont(new Font("Tahoma", Font.BOLD, 26));
			adminloginform.setBounds(405, 68, 263, 65);
		}
		return adminloginform;
	}
	private JLabel getUname() {
		if (uname == null) {
			uname = new JLabel("Username : ");
			uname.setFont(new Font("Tahoma", Font.BOLD, 18));
			uname.setBounds(214, 178, 129, 50);
		}
		return uname;
	}
	private JTextField getUsernameTxt() {
		if (usernameTxt == null) {
			usernameTxt = new JTextField();
			usernameTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
			usernameTxt.setBounds(362, 184, 380, 40);
			usernameTxt.setColumns(10);
		}
		return usernameTxt;
	}
	private JLabel getPword() {
		if (pword == null) {
			pword = new JLabel("Password : ");
			pword.setFont(new Font("Tahoma", Font.BOLD, 18));
			pword.setBounds(214, 269, 115, 34);
		}
		return pword;
	}
	private JTextField getPasswordTxt() {
		if (passwordTxt == null) {
			passwordTxt = new JTextField();
			passwordTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
			passwordTxt.setBounds(362, 270, 380, 40);
			passwordTxt.setColumns(10);
		}
		return passwordTxt;
	}
	private JButton getLoginBtn() {
		if (loginBtn == null) {
			loginBtn = new JButton("Login");
			loginBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String username = usernameTxt.getText().trim(),
						 password = String.valueOf(passwordTxt.getText()).trim();

					AdminService as = new AdminServiceImpl();
					boolean flag = as.loginAdmin(username, password);

					if (flag) {
						JOptionPane.showMessageDialog(contentPane, "Login Success");
						new AdminHome().setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(contentPane, "Username or Password is not correct");
					}
					
				}
			});
			loginBtn.setForeground(Color.BLACK);
			loginBtn.setBackground(new Color(0, 0, 255));
			loginBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
			loginBtn.setBounds(362, 362, 180, 40);
		}
		return loginBtn;
	}
	private JButton getCancelBtn() {
		if (cancelBtn == null) {
			cancelBtn = new JButton("Cancel");
			cancelBtn.setBackground(new Color(255, 0, 0));
			cancelBtn.setForeground(Color.BLACK);
			cancelBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new SwiftBill().setVisible(true);
					dispose();
				}
			});
			cancelBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
			cancelBtn.setBounds(562, 362, 180, 40);
		}
		return cancelBtn;
	}
	private JLabel getNotaccount() {
		if (notaccount == null) {
			notaccount = new JLabel("Don't have an account ?");
			notaccount.setFont(new Font("Tahoma", Font.PLAIN, 18));
			notaccount.setBounds(362, 447, 248, 40);
		}
		return notaccount;
	}
	private JLabel getNewaccount() {
		if (newaccount == null) {
			newaccount = new JLabel("Click Here to create a new account !!!");
			newaccount.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new AdminRegister().setVisible(true);
					dispose();
				}
			});
			newaccount.setFont(new Font("Tahoma", Font.PLAIN, 18));
			newaccount.setBounds(362, 497, 380, 40);
		}
		return newaccount;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBackground(Color.BLACK);
			separator.setBounds(10, 679, 1048, 2);
		}
		return separator;
	}
	private JLabel getCopyright() {
		if (copyright == null) {
			copyright = new JLabel("Copyright @ 2022 PP | All Rights Reserved");
			copyright.setFont(new Font("Tahoma", Font.PLAIN, 16));
			copyright.setBounds(405, 686, 334, 30);
		}
		return copyright;
	}
}
