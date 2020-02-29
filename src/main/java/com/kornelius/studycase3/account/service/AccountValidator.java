package com.kornelius.studycase3.account.service;

public interface AccountValidator {

	boolean isAccountNumberLengthSix(String accountNumber);

	boolean isAccountNumberFormatValid(String accountNumber);

	boolean isPinLengthSix(String pin);

	boolean isPinFormatValid(String pin);

}
