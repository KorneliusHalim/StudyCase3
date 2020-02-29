package com.kornelius.studycase3.account.service;

import org.springframework.stereotype.Service;

@Service
public class AccountValidatorImpl implements AccountValidator {

	private static final String REGEXFORMAT = "[0-9]+";

	@Override
	public boolean isAccountNumberLengthSix(String accountNumber) {

		if (accountNumber.length() == 6) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean isPinLengthSix(String pin) {
		if (pin.length() == 6) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isAccountNumberFormatValid(String accountNumber) {
		if (accountNumber.matches(REGEXFORMAT)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isPinFormatValid(String pin) {
		if (pin.matches(REGEXFORMAT)) {
			return true;
		} else {
			return false;
		}
	}

}
