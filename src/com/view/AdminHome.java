package com.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

public class AdminHome extends JFrame {

	private JPanel contentPane;
	private JLabel ahimage;
	private JLabel cashier;
	private JLabel stock;
	private JLabel transaction;
	private JLabel sales;
	private JLabel exit;
	private JSeparator separator;
	private JLabel copyright;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHome frame = new AdminHome();
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
	public AdminHome() {
		setTitle("Admin Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1118, 762);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getAhimage());
		contentPane.add(getCashier());
		contentPane.add(getStock());
		contentPane.add(getTransaction());
		contentPane.add(getSales());
		contentPane.add(getExit());
		contentPane.add(getSeparator());
		contentPane.add(getCopyright());
	}
	private JLabel getAhimage() {
		if (ahimage == null) {
			ahimage = new JLabel("New label");
			ahimage.setIcon(new ImageIcon("D:\\STS\\MarketBill\\SwiftIcon\\SwiftLogo.JPG"));
			ahimage.setBorder(new LineBorder(new Color(0, 0, 0)));
			ahimage.setBounds(37, 21, 241, 62);
		}
		return ahimage;
	}
	private JLabel getCashier() {
		if (cashier == null) {
			cashier = new JLabel("Cashier");
			cashier.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new AddCashier().setVisible(true);
					
				}
			});
			cashier.setFont(new Font("Tahoma", Font.BOLD, 20));
			cashier.setBounds(307, 28, 120, 41);
		}
		return cashier;
	}
	private JLabel getStock() {
		if (stock == null) {
			stock = new JLabel("Stock");
			stock.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new Stock().setVisible(true);
				}
			});
			stock.setFont(new Font("Tahoma", Font.BOLD, 20));
			stock.setBounds(448, 28, 106, 41);
		}
		return stock;
	}
	private JLabel getTransaction() {
		if (transaction == null) {
			transaction = new JLabel("Transaction");
			transaction.setFont(new Font("Tahoma", Font.BOLD, 20));
			transaction.setBounds(564, 28, 120, 41);
		}
		return transaction;
	}
	private JLabel getSales() {
		if (sales == null) {
			sales = new JLabel("Sales");
			sales.setFont(new Font("Tahoma", Font.BOLD, 20));
			sales.setBounds(737, 28, 120, 41);
		}
		return sales;
	}
	private JLabel getExit() {
		if (exit == null) {
			exit = new JLabel("Exit");
			exit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new SwiftBill().setVisible(true);
					dispose();
				}
			});
			exit.setFont(new Font("Tahoma", Font.BOLD, 20));
			exit.setBounds(918, 28, 120, 41);
		}
		return exit;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBackground(Color.BLACK);
			separator.setBounds(10, 653, 1084, 2);
		}
		return separator;
	}
	private JLabel getCopyright() {
		if (copyright == null) {
			copyright = new JLabel("Copyright @ 2022 PP | All Rights Reserved");
			copyright.setFont(new Font("Tahoma", Font.PLAIN, 16));
			copyright.setBounds(448, 672, 330, 29);
		}
		return copyright;
	}
}
