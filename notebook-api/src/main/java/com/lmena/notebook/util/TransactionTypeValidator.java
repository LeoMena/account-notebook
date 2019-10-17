package com.lmena.notebook.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lmena.notebook.model.enumeration.TransactionType;

public class TransactionTypeValidator implements ConstraintValidator<TransactionTypeConstraint, String> {

	@Override
	public void initialize(TransactionTypeConstraint transactionType) {
		
	}
	
	@Override
	public boolean isValid(String transactionType, ConstraintValidatorContext context) {
		 return transactionType != null && (transactionType.equalsIgnoreCase(TransactionType.CREDIT.name()) || transactionType.equalsIgnoreCase(TransactionType.DEBIT.name()));
	}

}
