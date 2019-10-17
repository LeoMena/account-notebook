package com.lmena.notebook.model.dto;


import com.lmena.notebook.util.AmountConstraint;
import com.lmena.notebook.util.TransactionTypeConstraint;

import lombok.Data;

@Data
public class TransactionRequestDTO {

	@TransactionTypeConstraint
	private String type;
	
	@AmountConstraint
	private Double amount;
}
