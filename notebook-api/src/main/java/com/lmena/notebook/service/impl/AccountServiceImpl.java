package com.lmena.notebook.service.impl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmena.notebook.exception.NegativeAmountException;
import com.lmena.notebook.model.dto.TransactionRequestDTO;
import com.lmena.notebook.model.entity.Account;
import com.lmena.notebook.model.enumeration.TransactionType;
import com.lmena.notebook.repository.AccountRepository;
import com.lmena.notebook.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	private Double accountAmount;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public void updateAccount(TransactionRequestDTO transactionRequest) {
		Optional<Account> account = accountRepository.findById(1L);
		
		account.ifPresent(accountEntity -> {
			if (transactionRequest.getType().equalsIgnoreCase((TransactionType.DEBIT.name()))) {
				accountEntity.setAmount(accountEntity.getAmount() - transactionRequest.getAmount());
				
				if (accountEntity.getAmount() < 0) {
					throw new NegativeAmountException("The account balance cannot be negative");
				}
			} else {
				accountEntity.setAmount(accountEntity.getAmount() + transactionRequest.getAmount());
			}
		});		
	}

	@Override
	public Double getBalance() {
		Optional<Account> account = accountRepository.findById(1L);
		
		account.ifPresent(accountEntity -> {
			 this.accountAmount = accountEntity.getAmount();
		});
		
		return this.accountAmount;
	}

}
