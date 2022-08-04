package com.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class CashierHome extends JFrame {

	private JPanel contentPane;
	private JLabel img;
	private JLabel bill;
	private JLabel search;
	private JLabel info;
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
					CashierHome frame = new CashierHome();
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
	public CashierHome() {
		setBackground(Color.GRAY);
		setTitle("Cashier Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1066, 772);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getImg());
		contentPane.add(getBill());
		contentPane.add(getSearch());
		contentPane.add(getInfo());
		contentPane.add(getSales());
		contentPane.add(getExit());
		contentPane.add(getSeparator());
		contentPane.add(getCopyright());
	}
	private JLabel getImg() {
		if (img == null) {
			img = new JLabel("New label");
			img.setBounds(59, 18, 159, 63);
			img.setIcon(new ImageIcon(new ImageIcon("D:\\STS\\MarketBill\\src\\Images\\SwiftLogo.JPG").getImage().getScaledInstance(img.getWidth(),img.getHeight(), DO_NOTHING_ON_CLOSE)));
			//img.setBounds(40, 27, 179, 63);
			img.setHorizontalAlignment(SwingConstants.CENTER);
			//img.setIcon(new ImageIcon("D:\\STS\\MarketBill\\src\\Images\\SwiftLogo.JPG"));
			img.setBorder(new LineBorder(new Color(0, 0, 0),2,true));
		}
		return img;
	}
	private JLabel getBill() {
		if (bill == null) {
			bill = new JLabel("Create Bill");
			bill.setBounds(296, 27, 119, 38);
			bill.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new CreateBill().setVisible(true);
				}
			});
			bill.setFont(new Font("Tahoma", Font.BOLD, 18));
		}
		return bill;
	}
	private JLabel getSearch() {
		if (search == null) {
			search = new JLabel("Search Bill");
			search.setBounds(437, 27, 119, 38);
			search.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new SearchBill().setVisible(true);
				}
			});
			search.setFont(new Font("Tahoma", Font.BOLD, 18));
		}
		return search;
	}
	private JLabel getInfo() {
		if (info == null) {
			info = new JLabel("Product Information");
			info.setBounds(578, 27, 204, 38);
			info.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new ProductInformation().setVisible(true);
				}
			});
			info.setFont(new Font("Tahoma", Font.BOLD, 18));
		}
		return info;
	}
	private JLabel getSales() {
		if (sales == null) {
			sales = new JLabel("Sales");
			sales.setBounds(800, 27, 81, 38);
			sales.setFont(new Font("Tahoma", Font.BOLD, 18));
		}
		return sales;
	}
	private JLabel getExit() {
		if (exit == null) {
			exit = new JLabel("Exit");
			exit.setBounds(952, 27, 65, 38);
			exit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new SwiftBill().setVisible(true);
				}
			});
			exit.setFont(new Font("Tahoma", Font.BOLD, 18));
		}
		return exit;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(10, 662, 1007, 2);
			separator.setBackground(Color.BLACK);
		}
		return separator;
	}
	private JLabel getCopyright() {
		if (copyright == null) {
			copyright = new JLabel("Copyright @ 2022 PP | All Rights Reserved");
			copyright.setBounds(402, 684, 331, 27);
			copyright.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return copyright;
	}
}
