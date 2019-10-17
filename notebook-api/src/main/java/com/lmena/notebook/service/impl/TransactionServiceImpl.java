package com.lmena.notebook.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmena.notebook.exception.InvalidTransactionIdException;
import com.lmena.notebook.exception.TransactionNotFoundException;
import com.lmena.notebook.model.dto.TransactionRequestDTO;
import com.lmena.notebook.model.entity.Transaction;
import com.lmena.notebook.model.enumeration.TransactionType;
import com.lmena.notebook.repository.TransactionRepository;
import com.lmena.notebook.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	private Transaction transactionEntity;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Override
	public void registerTransaction(TransactionRequestDTO transactionRequest) {
		Transaction transaction = new Transaction();
		transaction.setAmount(transactionRequest.getAmount());
		transaction.setEffectiveDate(new Date());
		transaction.setType(transactionRequest.getType().equalsIgnoreCase(TransactionType.DEBIT.name()) ? TransactionType.DEBIT.name() : TransactionType.CREDIT.name());
		
		transactionRepository.save(transaction);

	}

	@Override
	public List<Transaction> getAllTransactions() {
		List<Transaction> transactions = transactionRepository.findAll();
		
		if (transactions.isEmpty()) {
			throw new TransactionNotFoundException("Not found transactions");
		}
		
		return transactions;
	}

	@Override
	public Transaction getTransaction(Long id) {
		if(id == null || id == 0) {
			throw new InvalidTransactionIdException("Invalid id supplied");
		}
		
		Optional<Transaction> transaction = transactionRepository.findById(id);
		
		transaction.ifPresent(transactionEntity -> {
			this.transactionEntity = transactionEntity;
		});
		
		if (!transaction.isPresent()) {
			throw new TransactionNotFoundException("Not found transaction with supplied id");
		}
		
		return this.transactionEntity;
	}

}
