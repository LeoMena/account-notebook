package com.lmena.notebook.service;

import java.util.List;

import com.lmena.notebook.model.dto.TransactionRequestDTO;
import com.lmena.notebook.model.entity.Transaction;

public interface TransactionService {

	public void registerTransaction(TransactionRequestDTO transactionRequest);
	public List<Transaction> getAllTransactions();
	public Transaction getTransaction(Long id);
}
