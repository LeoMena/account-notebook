package com.lmena.notebook.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.lmena.notebook.model.dto.TransactionRequestDTO;
import com.lmena.notebook.model.entity.Transaction;
import com.lmena.notebook.service.AccountService;
import com.lmena.notebook.service.NotebookService;
import com.lmena.notebook.service.TransactionService;

@Service
public class NotebookServiceImpl implements NotebookService {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private TransactionService transactionService;
	
	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public void addTransaction(TransactionRequestDTO transactionRequest) {
		this.accountService.updateAccount(transactionRequest);
		this.transactionService.registerTransaction(transactionRequest);
	}

	@Override
	public List<Transaction> getAllTransactions() {
		return this.transactionService.getAllTransactions();
	}

	@Override
	public Transaction getTransaction(Long id) {
		return this.transactionService.getTransaction(id);
	}

	@Override
	public double getAccountBalance() {
		return this.accountService.getBalance();
	}

}
