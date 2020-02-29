package com.kornelius.studycase3.account.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.kornelius.studycase3.account.model.Account;
import com.kornelius.studycase3.account.repository.AccountRepository;

@SpringBootTest
public class AccountServiceTest {
	
	@InjectMocks
	AccountServiceImpl accountServiceImpl;
	
	@Mock
	AccountRepository accountRepository;
	
	private Account getAccount() {
		Account account = new Account();
		account.setName("Kornelius");
		account.setAccountNumber("123456");
		account.setBalance(new BigDecimal(1000000));
		account.setPin("123456");
		return account;
	}
	
	@Test
	public void testGetAccountByAccountNumberWithValidDataShouldReturnSuccess() {
		String accountNumber = "123456";
		Optional<Account> account = Optional.of(getAccount());
		
		Mockito.when(accountRepository.findById(accountNumber)).thenReturn(account);
		Account result = accountServiceImpl.getAccountByAccountNumber(accountNumber);
		assertThat(result.getAccountNumber()).isEqualTo(accountNumber);
	}

}
