package com.infy.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.infy.model.TransactionDTO;

@Entity
@Table(name = "transaction")
public class Transaction {
	@Id
	@Column(name = "account_number")
	private Long accountNumber;
	@Column(name = "account_name")
	private String accountName;
	@Column(name = "value_date")
	private LocalDate valueDate;
	private String currency;
	@Column(name = "debit_amount")
	private Double debitAmount;
	@Column(name = "credit_amount")
	private Double creditAmount;
	@Column(name = "debit_credit")
	private String debitCredit;
	@Column(name = "transaction_narrative")
	private String transactionNarrative;

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

	public LocalDate getValueDate() {
		return valueDate;
	}

	public void setValueDate(LocalDate valueDate) {
		this.valueDate = valueDate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(Double debitAmount) {
		this.debitAmount = debitAmount;
	}

	public Double getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(Double creditAmount) {
		this.creditAmount = creditAmount;
	}

	public String getDebitCredit() {
		return debitCredit;
	}

	public void setDebitCredit(String debitCredit) {
		this.debitCredit = debitCredit;
	}

	public String getTransactionNarrative() {
		return transactionNarrative;
	}

	public void setTransactionNarrative(String transactionNarrative) {
		this.transactionNarrative = transactionNarrative;
	}

	public static TransactionDTO prepareTransactionEntity(Transaction transaction) {
		TransactionDTO transactionDTO = new TransactionDTO();
		transactionDTO.setAccountName(transaction.getAccountName());
		transactionDTO.setAccountNumber(transaction.getAccountNumber());
		transactionDTO.setCreditAmount(transaction.getCreditAmount());
		transactionDTO.setDebitAmount(transaction.getDebitAmount());
		transactionDTO.setDebitCredit(transaction.getDebitCredit());
		transactionDTO.setTransactionNarrative(transaction.getTransactionNarrative());
		transactionDTO.setValueDate(transaction.getValueDate().getMonth().toString().substring(0, 1).toUpperCase()
				+ transaction.getValueDate().getMonth().toString().substring(1, 3).toLowerCase() + "."
				+ transaction.getValueDate().getDayOfMonth() + "," + transaction.getValueDate().getYear());
		transactionDTO.setTransactionNarrative(transaction.getTransactionNarrative());
		return transactionDTO;
	}

}
