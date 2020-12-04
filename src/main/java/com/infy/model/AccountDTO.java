package com.infy.model;



import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class AccountDTO {
	@NotNull(message = "{account.number.required}")
	@Min(value = 9, message = "{account.number.invalid}")
	@Max(value = 9, message = "{account.number.invalid}")
	private Long accountNumber;

	@NotNull(message = "{account.name.required}")
	@Pattern(regexp = "(SG|AU)(Savings|Current)[0-9] {3}", message = "{account.name.invalid}")
	private String accountName;

	@NotNull(message = "{account.type.required}")
	@Pattern(regexp = "(Savings|Current)", message = "{account.type.invalid}")
	private String accountType;

	private String balanceDate;

	@Pattern(regexp = "(SGD|AUD)", message = "{account.currency.invalid}")
	private String currency;

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

	public String getBalanceDate() {
		return balanceDate;
	}

	public void setBalanceDate(String balanceDate) {
		this.balanceDate = balanceDate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String cuurrency) {
		this.currency = cuurrency;
	}

	public Double getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(Double availableBalance) {
		this.availableBalance = availableBalance;
	}

}
