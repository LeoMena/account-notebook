package com.lmena.notebook.service;

import com.lmena.notebook.model.dto.TransactionRequestDTO;

public interface AccountService {

	public void updateAccount(TransactionRequestDTO transaccionRequest);
	public Double getBalance();
}
