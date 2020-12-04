package com.infy.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.infy.exception.BankException;
import com.infy.model.TransactionDTO;
import com.infy.repository.TransactionRepository;
import com.infy.utility.InfyBankConstants;

@Service("transactionService")
@Transactional
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private Environment environment;

	public List<TransactionDTO> viewTransactionDetails(Long accountNumber) throws BankException {
		List<TransactionDTO> list = transactionRepository.viewTransactionDetails(accountNumber);
		if (list.isEmpty()) {
			throw new BankException(environment.getProperty(InfyBankConstants.NO_TRANSACTION_EXCEPTION.toString()));
		}
		return list;
	}
}
