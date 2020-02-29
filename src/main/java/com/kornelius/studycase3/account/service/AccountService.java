package com.kornelius.studycase3.account.service;

import com.kornelius.studycase3.account.model.Account;

public interface AccountService {

	Account getAccountByAccountNumber(String accountNumber);

	Account getAccountByAccountNumberAndPin(String accountNumber, String pin);

}
