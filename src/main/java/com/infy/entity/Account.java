package com.infy.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.infy.model.AccountDTO;

@Entity
@Table(name = "account")
public class Account {

	@Id
	@Column(name = "account_number")
	private Long accountNumber;
	@Column(name = "account_name")
	private String accountName;
	@Column(name = "account_type")
	private String accountType;
	@Column(name = "balance_date")
	private LocalDate balanceDate;
	private String currency;
	@Column(name = "available_balance")
	private Double availableBalance;

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public LocalDate getBalanceDate() {
		return balanceDate;
	}

	public void setBalanceDate(LocalDate balanceDate) {
		this.balanceDate = balanceDate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCuurrency(String cuurrency) {
		this.currency = cuurrency;
	}

	public Double getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(Double availableBalance) {
		this.availableBalance = availableBalance;
	}

	public static AccountDTO prepareAccountEntity(Account account) {
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setAccountName(account.getAccountName());
		accountDTO.setAccountNumber(account.getAccountNumber());
		accountDTO.setAccountType(account.getAccountType());
		accountDTO.setAvailableBalance(account.getAvailableBalance());
		accountDTO.setBalanceDate(account.getBalanceDate().getDayOfMonth() + "/"
				+ account.getBalanceDate().getMonthValue() + "/" + account.getBalanceDate().getYear());
		accountDTO.setCurrency(account.getCurrency());
		return accountDTO;
	}

}
