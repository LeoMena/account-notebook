package com.lmena.notebook.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.lmena.notebook.model.dto.TransactionRequestDTO;
import com.lmena.notebook.model.entity.Transaction;
import com.lmena.notebook.service.NotebookService;

//cross origin only for testing purpose
@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping(path = "/api")
public class NotebookRestController {

	@Autowired
	private NotebookService notebookService;
	
	
	@GetMapping(value = "/transactions", produces = "application/json")
	@ResponseBody
	public List<Transaction> getTransactions(){
		return notebookService.getAllTransactions();
	}
	
	@GetMapping(value = "/transactions/{id}")
	@ResponseBody
	public Transaction getTransaction(@PathVariable("id") Long id) {
		return notebookService.getTransaction(id);
	}
	
	@PostMapping(value = "/transactions", consumes = "application/json")
	@ResponseBody
	public String registerTransaction (@Valid @RequestBody TransactionRequestDTO transactionRequest) {
		notebookService.addTransaction(transactionRequest);
		return "Transaccion stored";
	}
	
	@GetMapping(value = "/")
	@ResponseBody
	public Double getAccountBalance() {
		return notebookService.getAccountBalance();
	}

	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return errors;
	}
	
}
