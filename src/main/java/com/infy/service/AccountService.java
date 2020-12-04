package com.infy.service;

import java.util.List;

import com.infy.exception.BankException;
import com.infy.model.AccountDTO;

public interface AccountService {

	public List<AccountDTO> viewAccountDetails() throws BankException;
}
