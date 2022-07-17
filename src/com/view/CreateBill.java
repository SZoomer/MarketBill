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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;

import com.model.Bill;
import com.model.Product;
import com.service.BillService;
import com.service.BillServiceImpl;
import com.service.ProductServiceImpl;
import com.toedter.calendar.JDateChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.sql.Date;
import java.util.List;
import javax.swing.JSeparator;

public class CreateBill extends JFrame {

	private JPanel contentPane;
	private JLabel billnumber;
	private JTextField billnumTxt;
	private JLabel customerName;
	private JTextField custnameTxt;
	private JLabel productId;
	private JComboBox productCmbo;
	private JLabel productName;
	private JTextField prodnameTxt;
	private JLabel quantity;
	private JTextField quantityTxt;
	private JLabel discount;
	private JTextField discountTxt;
	private JLabel mrp;
	private JTextField mrpTxt;
	private JButton addBtn;
	private JButton deleteBtn;
	private JLabel billdate;
	private JDateChooser dateBtn;
	private JScrollPane scrollPane;
	private JLabel total;
	private JTextField totalTxt;
	private JLabel printTxt;
	private JTable table;
	protected JDateChooser dateChooser;
	private JLabel price;
	private JTextField priceTxt;
	private JSeparator separator;
	private JLabel copyright;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateBill frame = new CreateBill();
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
	public CreateBill() {
		setTitle("Create Bill");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1416, 838);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBillnumber());
		contentPane.add(getBillnumTxt());
		contentPane.add(getCustomerName());
		contentPane.add(getCustnameTxt());
		contentPane.add(getProductId());
		contentPane.add(getProductCmbo());
		contentPane.add(getProductName());
		contentPane.add(getProdnameTxt());
		contentPane.add(getQuantity());
		contentPane.add(getQuantityTxt1());
		contentPane.add(getDiscount());
		contentPane.add(getDiscountTxt());
		contentPane.add(getMrp());
		contentPane.add(getMrpTxt());
		contentPane.add(getAddBtn());
		contentPane.add(getDeleteBtn());
		contentPane.add(getBilldate());
		contentPane.add(getDateBtn());
		contentPane.add(getScrollPane());
		contentPane.add(getTotal());
		contentPane.add(getTotalTxt());
		contentPane.add(getPrintTxt());
		contentPane.add(getPrice());
		contentPane.add(getPriceTxt());
		contentPane.add(getSeparator());
		contentPane.add(getCopyright());
		displayTable();
	}
	private JLabel getBillnumber() {
		if (billnumber == null) {
			billnumber = new JLabel("Bill Number : ");
			billnumber.setBounds(77, 84, 136, 32);
			billnumber.setFont(new Font("Tahoma", Font.BOLD, 18));
		}
		return billnumber;
	}
	private JTextField getBillnumTxt() {
		if (billnumTxt == null) {
			billnumTxt = new JTextField();
			billnumTxt.setBounds(248, 84, 292, 32);
			billnumTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
			billnumTxt.setColumns(10);
		}
		return billnumTxt;
	}
	private JLabel getCustomerName() {
		if (customerName == null) {
			customerName = new JLabel("Customer Name : ");
			customerName.setBounds(77, 148, 167, 32);
			customerName.setFont(new Font("Tahoma", Font.BOLD, 18));
		}
		return customerName;
	}
	private JTextField getCustnameTxt() {
		if (custnameTxt == null) {
			custnameTxt = new JTextField();
			custnameTxt.setBounds(248, 148, 292, 32);
			custnameTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
			custnameTxt.setColumns(10);
		}
		return custnameTxt;
	}
	private JLabel getProductId() {
		if (productId == null) {
			productId = new JLabel("Product ID : ");
			productId.setBounds(77, 208, 126, 32);
			productId.setFont(new Font("Tahoma", Font.BOLD, 18));
		}
		return productId;
	}
	private JComboBox getProductCmbo() {
		if (productCmbo == null) {
			productCmbo = new JComboBox();
			productCmbo.setBounds(248, 208, 292, 32);
			productCmbo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			productCmbo.setModel(new DefaultComboBoxModel(new String[] {"\t\t--- Select Product ID ---", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114", "115", "116", "117", "118", "119", "120"}));
		}
		return productCmbo;
	}
	private JLabel getProductName() {
		if (productName == null) {
			productName = new JLabel("Product Name : ");
			productName.setBounds(77, 267, 150, 32);
			productName.setFont(new Font("Tahoma", Font.BOLD, 18));
		}
		return productName;
	}
	private JTextField getProdnameTxt() {
		if (prodnameTxt == null) {
			prodnameTxt = new JTextField();
			prodnameTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
			prodnameTxt.setBounds(248, 267, 292, 32);
			prodnameTxt.setColumns(10);
		}
		return prodnameTxt;
	}
	private JLabel getQuantity() {
		if (quantity == null) {
			quantity = new JLabel("Quantity : ");
			quantity.setBounds(77, 366, 150, 32);
			quantity.setFont(new Font("Tahoma", Font.BOLD, 18));
		}
		return quantity;
	}
	private JTextField getQuantityTxt1() {
		if (quantityTxt == null) {
			quantityTxt = new JTextField();
			quantityTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
			quantityTxt.setBounds(248, 370, 292, 32);
			quantityTxt.setColumns(10);
		}
		return quantityTxt;
	}
	private JLabel getDiscount() {
		if (discount == null) {
			discount = new JLabel("Discount : ");
			discount.setBounds(77, 417, 136, 32);
			discount.setFont(new Font("Tahoma", Font.BOLD, 18));
		}
		return discount;
	}
	private JTextField getDiscountTxt() {
		if (discountTxt == null) {
			discountTxt = new JTextField();
			discountTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
			discountTxt.setBounds(248, 421, 292, 32);
			discountTxt.setColumns(10);
		}
		return discountTxt;
	}
	private JLabel getMrp() {
		if (mrp == null) {
			mrp = new JLabel("MRP per item : ");
			mrp.setBounds(77, 322, 150, 32);
			mrp.setFont(new Font("Tahoma", Font.BOLD, 18));
		}
		return mrp;
	}
	private JTextField getMrpTxt() {
		if (mrpTxt == null) {
			mrpTxt = new JTextField();
			mrpTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
			mrpTxt.setBounds(248, 324, 292, 32);
			mrpTxt.setColumns(10);
		}
		return mrpTxt;
	}
	
	private JLabel getPrice() {
		if (price == null) {
			price = new JLabel("Price : ");
			price.setFont(new Font("Tahoma", Font.BOLD, 18));
			price.setBounds(77, 584, 115, 32);
		}
		return price;
	}
	private JTextField getPriceTxt() {
		if (priceTxt == null) {
			priceTxt = new JTextField();
			priceTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
			priceTxt.setBounds(248, 584, 292, 32);
			priceTxt.setColumns(10);
		}
		return priceTxt;
	}
	
	
	private JButton getAddBtn() {
		if (addBtn == null) {
			addBtn = new JButton("ADD");
			addBtn.setBounds(248, 480, 122, 40);
			addBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if (validation()) {
						Bill bill = new Bill();
						bill.setBillnumber(Integer.valueOf(billnumTxt.getText().trim()));
						bill.setBillDate(new Date(dateBtn.getDate().getTime()));
						bill.setCustomerName(custnameTxt.getText().trim());
						bill.setDiscount(Integer.valueOf(discountTxt.getText().trim()));
						bill.setProductId(Integer.valueOf(productCmbo.getSelectedItem().toString()));
						bill.setProductName(prodnameTxt.getText().trim());
						bill.setQuantity(Integer.valueOf(quantityTxt.getText().trim()));
						bill.setMrp(Integer.valueOf(mrpTxt.getText().trim()));
						bill.setPrice(bill.getQuantity() * bill.getMrp() - bill.getDiscount());	
						priceTxt.setText(""+ bill.getPrice());

						boolean flag = new BillServiceImpl().addBill(bill);
						if (flag) {
							JOptionPane.showMessageDialog(contentPane, "Bill Added");
							clearForm();
							displayTable();
						} else {
							JOptionPane.showMessageDialog(contentPane, "Bill Not Added");
							clearForm();
						}
					}
				}
					
				}
			);
			addBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		}
		return addBtn;
	}
	private JButton getDeleteBtn() {
		if (deleteBtn == null) {
			deleteBtn = new JButton("Delete");
			deleteBtn.setBounds(390, 480, 150, 40);
			deleteBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
			deleteBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int selectedRow = table.getSelectedRow();
					if (selectedRow == -1) {
						JOptionPane.showMessageDialog(contentPane, "No Row Selected");
						return;
					}
					int id = (int) table.getModel().getValueAt(selectedRow, 0);

					boolean flag = new BillServiceImpl().deleteBill(id);
					if (flag) {
						JOptionPane.showMessageDialog(contentPane, "Bill Deleted");
						clearForm();
						displayTable();
					} else {
						JOptionPane.showMessageDialog(contentPane, "Delete Failure");
					}
				}
			});
		}
		return deleteBtn;
	}
	private JLabel getBilldate() {
		if (billdate == null) {
			billdate = new JLabel("Date : ");
			billdate.setBounds(652, 84, 74, 32);
			billdate.setFont(new Font("Tahoma", Font.BOLD, 18));
		}
		return billdate;
	}
	private JDateChooser getDateBtn() {
		if (dateBtn == null) {
			dateBtn = new JDateChooser();
			dateBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
			dateBtn.setBounds(736, 84, 292, 32);
			dateBtn.setDateFormatString("MMM d,yyy");
		}
		return dateBtn;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 16));
			scrollPane.setBounds(652, 132, 725, 398);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JLabel getTotal() {
		if (total == null) {
			total = new JLabel("Grand Total : ");
			total.setBounds(652, 584, 128, 32);
			total.setFont(new Font("Tahoma", Font.BOLD, 18));
		}
		return total;
	}
	private JTextField getTotalTxt() {
		if (totalTxt == null) {
			totalTxt = new JTextField();
			totalTxt.setFont(new Font("Tahoma", Font.BOLD, 15));
			totalTxt.setBounds(790, 586, 277, 32);
			totalTxt.setColumns(10);
		}
		return totalTxt;
	}
	private JLabel getPrintTxt() {
		if (printTxt == null) {
			printTxt = new JLabel("Print");
			printTxt.setBounds(1130, 588, 67, 32);
			printTxt.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						table.print();
					} catch (PrinterException e1) {
						e1.printStackTrace();
					}
				}
			});
			printTxt.setFont(new Font("Tahoma", Font.BOLD, 20));
		}
		return printTxt;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int selectedRow = table.getSelectedRow();
					if (selectedRow == -1) {
						JOptionPane.showMessageDialog(scrollPane, "Select Row");
						return;
					}

					int id = (int) table.getModel().getValueAt(selectedRow, 0);

					Bill bill = new BillServiceImpl().getBillById(id);
					billnumTxt.setText("" + bill.getBillnumber());
					custnameTxt.setText(""+bill.getCustomerName());
					productCmbo.setSelectedItem("" + bill.getProductId());
					prodnameTxt.setText("" +bill.getProductName());
					quantityTxt.setText("" + bill.getQuantity());
					discountTxt.setText("" + bill.getDiscount());
					dateBtn.setDate(new Date(bill.getBillDate().getTime()));
					mrpTxt.setText("" + bill.getMrp());
					priceTxt.setText(""+ bill.getPrice());					
				}
			});
			table.setFont(new Font("Tahoma", Font.PLAIN, 16));
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Bill Number", "Product Name", "Quantity", "Price"
				}
			));
		}
		return table;
	}
	
	
	
	private void displayTable() {
		int total = 0;
		DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
		tmodel.setRowCount(0);

		BillService bs = new BillServiceImpl();
		List<Bill> billList = bs.getAllBill();

		for (Bill bill : billList) {
			total += bill.getPrice();
			tmodel.addRow(
					new Object[] { bill.getBillnumber(), bill.getQuantity(), bill.getProductName(), bill.getPrice() });
		}
		totalTxt.setText("" +total);
	}

	private void clearForm() {
		billnumTxt.setText("");
		custnameTxt.setText("");
		productCmbo.setSelectedIndex(0);
		prodnameTxt.setText("");
		quantityTxt.setText("");
		discountTxt.setText("");
		mrpTxt.setText("");
		dateBtn.setDate(null);
		priceTxt.setText("");
	}

	private boolean validation() {
		if (billnumTxt.getText().isBlank()) {
			JOptionPane.showMessageDialog(contentPane, "Bill Num required");
			return false;
		}

		if (custnameTxt.getText().isBlank()) {
			JOptionPane.showMessageDialog(contentPane, "Customer name required");
			return false;
		}
		if (productCmbo.getSelectedItem() == null) {
			JOptionPane.showMessageDialog(contentPane, "Product Id required");
			return false;
		}
		if (prodnameTxt.getText().isBlank()) {
			JOptionPane.showMessageDialog(contentPane, "Product Name required");
			return false;
		}
		if (quantityTxt.getText().isBlank()) {
			JOptionPane.showMessageDialog(contentPane, "Quantity required");
			return false;
		}
		if (discountTxt.getText().isBlank()) {
			JOptionPane.showMessageDialog(contentPane, "Discount required");
			return false;
		}
		if (mrpTxt.getText().isBlank()) {
			JOptionPane.showMessageDialog(contentPane, "MRP required");
			return false;
		}
		if (dateBtn.getDate() == null) {
			JOptionPane.showMessageDialog(contentPane, "Date required");
			return false;
		}
		/*
		 * if (priceTxt.getText().isBlank()) {
		 * JOptionPane.showMessageDialog(contentPane, "Price required"); return false; }
		 */
		return true;
	}

	private JTextField getQuantityTxt() {
		if (quantityTxt == null) {
			quantityTxt = new JTextField();
			quantityTxt.setColumns(10);
			quantityTxt.setBounds(170, 321, 226, 42);
		}
		return quantityTxt;
	}

	private JComboBox<String> getProductCmb() {
		if (productCmbo == null) {
			productCmbo = new JComboBox<>();
			productCmbo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int id = Integer.valueOf(productCmbo.getSelectedItem().toString());
					setData(id);
				}
			});

			List<Product> productList = new ProductServiceImpl().getAllProduct();
			String[] prodId = new String[productList.size()];
			for (int index = 0; index < prodId.length; index++) {
				prodId[index] = "" + productList.get(index).getId();
			}

			productCmbo.setModel(new DefaultComboBoxModel<>(prodId));
			productCmbo.setBounds(172, 206, 224, 35);
		}
		return productCmbo;
	}
	private void setData(int id) {
		Product product = new ProductServiceImpl().getProductById(id);
		prodnameTxt.setText(product.getProductname());
		mrpTxt.setText("" + product.getMrp());
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBackground(Color.BLACK);
			separator.setBounds(10, 740, 1362, 2);
		}
		return separator;
	}
	private JLabel getCopyright() {
		if (copyright == null) {
			copyright = new JLabel("Copyright @ 2022 PP | All Rights Reserved");
			copyright.setFont(new Font("Tahoma", Font.PLAIN, 16));
			copyright.setBounds(488, 759, 355, 20);
		}
		return copyright;
	}
}
