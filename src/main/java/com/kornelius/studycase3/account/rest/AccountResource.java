package com.kornelius.studycase3.account.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kornelius.studycase3.account.model.Account;
import com.kornelius.studycase3.account.model.Login;
import com.kornelius.studycase3.account.service.AccountService;
import com.kornelius.studycase3.account.service.AccountValidator;

@RestController
@RequestMapping("/api/account")
public class AccountResource {

	@Autowired
	private AccountService accountService;

	@Autowired
	private AccountValidator accountValidator;

	@RequestMapping(value = "/account-number", method = RequestMethod.POST)
	public ResponseEntity<String> getAccountNumber(@RequestParam String accountNumber) {

		if (!accountValidator.isAccountNumberLengthSix(accountNumber)) {
			return new ResponseEntity<>("Account Number should have 6 digits length", HttpStatus.NOT_FOUND);
		}

		if (!accountValidator.isAccountNumberFormatValid(accountNumber)) {
			return new ResponseEntity<>("Account Number should only contains numbers", HttpStatus.NOT_FOUND);
		}

		Account account = accountService.getAccountByAccountNumber(accountNumber);

		if (account != null) {
			return new ResponseEntity<>("Success", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Invalid Account Number/PIN", HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/account-number/pin", method = RequestMethod.POST)
	public ResponseEntity<String> getPin(@RequestBody Login login) {

		if (!accountValidator.isPinLengthSix(login.getPin())) {
			return new ResponseEntity<>("PIN should have 6 digits length", HttpStatus.NOT_FOUND);
		}

		if (!accountValidator.isPinFormatValid(login.getPin())) {
			return new ResponseEntity<>("PIN should only contains numbers", HttpStatus.NOT_FOUND);
		}

		Account account = accountService.getAccountByAccountNumberAndPin(login.getAccountNumber(), login.getPin());

		if (account != null) {
			return new ResponseEntity<>("Success", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Invalid Account Number/PIN", HttpStatus.NOT_FOUND);
		}
	}

}
