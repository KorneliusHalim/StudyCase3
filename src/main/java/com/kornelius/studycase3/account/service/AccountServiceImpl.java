package com.kornelius.studycase3.account.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kornelius.studycase3.account.model.Account;
import com.kornelius.studycase3.account.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Account getAccountByAccountNumber(String accountNumber) {

		Optional<Account> account = accountRepository.findById(accountNumber);

		if (account.isPresent()) {

			return account.get();
		} else {

			return null;
		}

	}

	@Override
	public Account getAccountByAccountNumberAndPin(String accountNumber, String pin) {
		return accountRepository.getAccountByAccountNumberAndPin(accountNumber, pin);
	}

}
