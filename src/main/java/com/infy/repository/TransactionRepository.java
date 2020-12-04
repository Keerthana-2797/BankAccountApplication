package com.infy.repository;

import java.util.List;

import com.infy.model.TransactionDTO;

public interface TransactionRepository {
	public List<TransactionDTO> viewTransactionDetails(Long accountNumber);
}
