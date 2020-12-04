package com.infy.utility;

public enum InfyBankConstants {
	NO_ACCOUNT_EXCEPTION("account.not.found"), GENERAL_EXCEPTION_MESSAGE("general.exception"),
	NO_TRANSACTION_EXCEPTION("transaction.not.made");

	private final String type;

	private InfyBankConstants(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return this.type;
	}
}
