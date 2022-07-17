package com.service;

import java.util.List;

import com.model.Cashier;

public interface CashierService {
	
	boolean addCashier(Cashier cashier);

	List<Cashier> getAllCashier();

	Cashier getCashierById(int id);

	boolean updateCashier(Cashier cashier);

	boolean deleteCashier(int id);

	boolean loginCashier(String email, String password);
	
	

}
