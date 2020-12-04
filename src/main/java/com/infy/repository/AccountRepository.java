package com.infy.repository;

import java.util.List;

import com.infy.model.AccountDTO;

public interface AccountRepository {
	public List<AccountDTO> viewAccountDetails();
}
