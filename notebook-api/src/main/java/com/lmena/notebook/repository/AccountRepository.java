package com.lmena.notebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lmena.notebook.model.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
