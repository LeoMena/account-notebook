package com.lmena.notebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lmena.notebook.model.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
