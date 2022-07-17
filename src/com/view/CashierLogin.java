package com.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.service.CashierService;
import com.service.CashierServiceImpl;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class CashierLogin extends JFrame {

	private JPanel contentPane;
	private JLabel loginform;
	private JLabel email;
	private JTextField emailTxt;
	private JLabel password;
	private JTextField passwordTxt;
	private JButton loginBtn;
	private JButton cancelBtn;
	private JSeparator separator;
	private JLabel copyright;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CashierLogin frame = new CashierLogin();
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
	public CashierLogin() {
		setTitle("Cashier Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1055, 609);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLoginform());
		contentPane.add(getEmail());
		contentPane.add(getEmailTxt());
		contentPane.add(getPassword());
		contentPane.add(getPasswordTxt());
		contentPane.add(getLoginBtn());
		contentPane.add(getCancelBtn());
		contentPane.add(getSeparator());
		contentPane.add(getCopyright());
	}

	private JLabel getLoginform() {
		if (loginform == null) {
			loginform = new JLabel("Cashier Login Form");
			loginform.setFont(new Font("Tahoma", Font.BOLD, 26));
			loginform.setBounds(369, 71, 277, 32);
		}
		return loginform;
	}
	private JLabel getEmail() {
		if (email == null) {
			email = new JLabel("Email : ");
			email.setFont(new Font("Tahoma", Font.BOLD, 18));
			email.setBounds(229, 177, 121, 32);
		}
		return email;
	}
	private JTextField getEmailTxt() {
		if (emailTxt == null) {
			emailTxt = new JTextField();
			emailTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
			emailTxt.setBounds(369, 178, 416, 32);
			emailTxt.setColumns(10);
		}
		return emailTxt;
	}
	private JLabel getPassword() {
		if (password == null) {
			password = new JLabel("Password : ");
			password.setFont(new Font("Tahoma", Font.BOLD, 18));
			password.setBounds(229, 239, 121, 32);
		}
		return password;
	}
	private JTextField getPasswordTxt() {
		if (passwordTxt == null) {
			passwordTxt = new JTextField();
			passwordTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
			passwordTxt.setBounds(369, 240, 416, 32);
			passwordTxt.setColumns(10);
		}
		return passwordTxt;
	}
	private JButton getLoginBtn() {
		if (loginBtn == null) {
			loginBtn = new JButton("Login");
			loginBtn.setBackground(new Color(50, 205, 50));
			loginBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String username = emailTxt.getText().trim(),
							password = String.valueOf(passwordTxt.getText()).trim();

					CashierService cs = new CashierServiceImpl();
					boolean flag = cs.loginCashier(username, password);

					if (flag) {
						JOptionPane.showMessageDialog(contentPane, "Login Success");
						new CashierHome().setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(contentPane, "Username and password not correct");
					}
				}
			});
			loginBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
			loginBtn.setBounds(369, 307, 200, 38);
		}
		return loginBtn;
	}
	private JButton getCancelBtn() {
		if (cancelBtn == null) {
			cancelBtn = new JButton("Cancel");
			cancelBtn.setBackground(new Color(255, 140, 0));
			cancelBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						new SwiftBill().setVisible(true);
						dispose();
				}
			});
			cancelBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
			cancelBtn.setBounds(585, 307, 200, 38);
		}
		return cancelBtn;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBackground(Color.BLACK);
			separator.setBounds(35, 511, 981, 2);
		}
		return separator;
	}
	private JLabel getCopyright() {
		if (copyright == null) {
			copyright = new JLabel("Copyright @ 2022 PP | All Rights Reserved");
			copyright.setFont(new Font("Tahoma", Font.PLAIN, 16));
			copyright.setBounds(405, 524, 364, 28);
		}
		return copyright;
	}
}
