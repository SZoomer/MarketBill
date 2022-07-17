package com.service;

import java.util.List;

import com.model.Bill;

public interface BillService {
	
	
	List<Bill> getAllBill();

	boolean addBill(Bill bill);

	Bill getBillById(int id);

	boolean deleteBill(int id);

}
