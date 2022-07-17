package com.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class SwiftBill extends JFrame {

	private JPanel contentPane;
	private JLabel supermarket;
	private JButton adminBtn;
	private JButton CashierBtn;
	private JLabel iconswift;
	private JLabel swiftbill;
	private JSeparator separator;
	private JLabel copyright;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwiftBill frame = new SwiftBill();
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
	public SwiftBill() {
		setTitle("Swift Bill");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1083, 798);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(189, 183, 107));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getSupermarket());
		contentPane.add(getAdminBtn());
		contentPane.add(getCashierBtn());
		contentPane.add(getIconswift());
		contentPane.add(getSwiftbill());
		contentPane.add(getSeparator());
		contentPane.add(getCopyright());
	}
	private JLabel getSupermarket() {
		if (supermarket == null) {
			supermarket = new JLabel("Welcome To Supermarket Billing System");
			supermarket.setBounds(259, 64, 601, 46);
			supermarket.setFont(new Font("Tahoma", Font.BOLD, 28));
		}
		return supermarket;
	}
	private JButton getAdminBtn() {
		if (adminBtn == null) {
			adminBtn = new JButton("Admin Login");
			adminBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					new AdminLogin().setVisible(true);
					dispose();
				}
			});
			adminBtn.setBounds(724, 324, 188, 52);
			adminBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		}
		return adminBtn;
	}
	private JButton getCashierBtn() {
		if (CashierBtn == null) {
			CashierBtn = new JButton("Cashier Login");
			CashierBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new CashierLogin().setVisible(true);
					dispose();				
				}
			});
			CashierBtn.setBounds(724, 416, 188, 52);
			CashierBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		}
		return CashierBtn;
	}
	private JLabel getIconswift() {
		if (iconswift == null) {
			iconswift = new JLabel("New label");
			iconswift.setIcon(new ImageIcon("D:\\STS\\MarketBill\\SwiftIcon\\SwiftLogo.JPG"));
			iconswift.setBorder(new LineBorder(new Color(0, 0, 0)));
			iconswift.setBounds(198, 310, 284, 155);
		}
		return iconswift;
	}
	private JLabel getSwiftbill() {
		if (swiftbill == null) {
			swiftbill = new JLabel("Swift Bill");
			swiftbill.setFont(new Font("Tahoma", Font.BOLD, 32));
			swiftbill.setBounds(259, 494, 181, 62);
		}
		return swiftbill;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBackground(Color.BLACK);
			separator.setBounds(10, 678, 1049, 7);
		}
		return separator;
	}
	private JLabel getCopyright() {
		if (copyright == null) {
			copyright = new JLabel("Copyright @ 2022 PP | All Rights Reserved");
			copyright.setFont(new Font("Tahoma", Font.PLAIN, 16));
			copyright.setBounds(379, 695, 346, 35);
		}
		return copyright;
	}
}
