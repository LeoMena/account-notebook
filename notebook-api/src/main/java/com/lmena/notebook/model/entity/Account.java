package com.lmena.notebook.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Account {

	@Id
	private Long id;
	private Double amount;
}
