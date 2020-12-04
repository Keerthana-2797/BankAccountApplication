package com.infy.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.infy.exception.BankException;
import com.infy.model.AccountDTO;
import com.infy.repository.AccountRepository;
import com.infy.utility.InfyBankConstants;

@Service("accountService")
@Transactional
@PropertySource("classpath:Validation.properties")
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private Environment environment;

	@Override
	public List<AccountDTO> viewAccountDetails() throws BankException {
		List<AccountDTO> list = accountRepository.viewAccountDetails();
		if (list.isEmpty()) {
			throw new BankException(environment.getProperty(InfyBankConstants.NO_ACCOUNT_EXCEPTION.toString()));
		}
		return list;
	}

}
