package com.infy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.exception.BankException;
import com.infy.model.TransactionDTO;
import com.infy.service.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@PostMapping("/transaction/{accountNumber}")
	public List<TransactionDTO> viewTransactionDetails(@PathVariable("accountNumber") Long accountNumber)
			throws BankException {
		return transactionService.viewTransactionDetails(accountNumber);
	}
}
