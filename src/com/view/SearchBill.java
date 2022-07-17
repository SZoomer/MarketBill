package com.view;

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

import com.model.Bill;
import com.service.BillServiceImpl;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

@SuppressWarnings({ "serial" })
public class SearchBill extends JFrame {

	private JPanel contentPane;
	private JLabel searchbill;
	private JLabel bill;
	private JTextField billnumTxt;
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
					SearchBill frame = new SearchBill();
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
	public SearchBill() {
		setTitle("Search Bill");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1067, 794);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(169, 169, 169));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getSearchbill());
		contentPane.add(getBill());
		contentPane.add(getBillnumTxt());
		contentPane.add(getSearchBtn());
		contentPane.add(getScrollPane());
		contentPane.add(getSeparator());
		contentPane.add(getCopyright());
	}

	private JLabel getSearchbill() {
		if (searchbill == null) {
			searchbill = new JLabel("Search Bill");
			searchbill.setFont(new Font("Tahoma", Font.BOLD, 22));
			searchbill.setBounds(466, 40, 145, 30);
		}
		return searchbill;
	}
	private JLabel getBill() {
		if (bill == null) {
			bill = new JLabel("Bill Number : ");
			bill.setFont(new Font("Tahoma", Font.BOLD, 18));
			bill.setBounds(62, 123, 128, 30);
		}
		return bill;
	}
	private JTextField getBillnumTxt() {
		if (billnumTxt == null) {
			billnumTxt = new JTextField();
			billnumTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
			billnumTxt.setBounds(200, 127, 200, 30);
			billnumTxt.setColumns(10);
		}
		return billnumTxt;
	}
	private JButton getSearchBtn() {
		if (searchBtn == null) {
			searchBtn = new JButton("Search");
			searchBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (billnumTxt.getText().isBlank()) {
						JOptionPane.showMessageDialog(billnumTxt, "Bill Number Required");
						return;
					}

					int id = Integer.valueOf(billnumTxt.getText());
					Bill bill = new BillServiceImpl().getBillById(id);

					if (bill.getBillnumber() == id) {
						dislayDataTable(bill);
						clearForm();
					} else {
						JOptionPane.showMessageDialog(contentPane, "Bill not availabe");
						dislayDataTable(null);
						clearForm();
					}
					
					
				}
			});
			searchBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
			searchBtn.setBounds(696, 127, 150, 30);
		}
		return searchBtn;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(62, 192, 941, 442);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setFont(new Font("Tahoma", Font.PLAIN, 16));
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Bill Number", "Customer Name", "Amount", "Date"
				}
			));
		}
		return table;
	}
	
	private void clearForm() {
		billnumTxt.setText("");

	}

	private void dislayDataTable(Bill bill) {
		DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
		tmodel.setRowCount(0);
		if (bill instanceof Bill)
			tmodel.addRow(
					new Object[] { bill.getBillnumber(), bill.getCustomerName(), bill.getPrice(), bill.getBillDate() });
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBackground(Color.BLACK);
			separator.setBounds(10, 698, 1014, 2);
		}
		return separator;
	}
	private JLabel getCopyright() {
		if (copyright == null) {
			copyright = new JLabel("Copyright @ 2022 PP | All Rights Reserved");
			copyright.setFont(new Font("Tahoma", Font.PLAIN, 16));
			copyright.setBounds(320, 710, 316, 27);
		}
		return copyright;
	}
}

