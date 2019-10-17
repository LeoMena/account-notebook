package com.lmena.notebook.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class AmountValidator implements ConstraintValidator<AmountConstraint, Double>{

	@Override
	public void initialize(AmountConstraint amount) {
		
	}
	
	@Override
	public boolean isValid(Double amount, ConstraintValidatorContext context) {
		
		return amount != null && !amount.isNaN() && amount > 0; 
	}

}