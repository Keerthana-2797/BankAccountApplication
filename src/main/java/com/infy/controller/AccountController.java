package com.infy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.exception.BankException;
import com.infy.model.AccountDTO;
import com.infy.service.AccountService;

@RestController
@Validated
public class AccountController {
	@Autowired
	private AccountService accountService;

	@GetMapping("/login")
	public List<AccountDTO> viewAccountDetails() throws BankException {
		return accountService.viewAccountDetails();
	}

}
