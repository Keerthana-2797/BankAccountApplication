package com.infy.service;

import java.util.List;

import com.infy.exception.BankException;
import com.infy.model.TransactionDTO;

public interface TransactionService {
	public List<TransactionDTO> viewTransactionDetails(Long accountNumber) throws BankException;
}
