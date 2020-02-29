package com.kornelius.studycase3.account.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AccountValidatorTest {

	@InjectMocks
	AccountValidatorImpl accountValidator;

	@Test
	public void testIsAccountNumberLengthSixWithValidValueShouldReturnTrue() {
		String accountNumber = "123456";
		boolean result = accountValidator.isAccountNumberLengthSix(accountNumber);
		assertThat(result).isTrue();
	}

	@Test
	public void testIsAccountNumberLengthSixShouldReturnWithValueMoreThanSixShouldReturnFalse() {
		String accountNumber = "12345678";
		boolean result = accountValidator.isAccountNumberLengthSix(accountNumber);
		assertThat(result).isFalse();
	}

	@Test
	public void testIsAccountNumberLengthSixShouldReturnWithValueLessThanSixShouldReturnFalse() {
		String accountNumber = "1234";
		boolean result = accountValidator.isAccountNumberLengthSix(accountNumber);
		assertThat(result).isFalse();
	}

	@Test
	public void testIsAccountNumberFormatValidWithValidValueShouldReturnTrue() {
		String accountNumber = "123456";
		boolean result = accountValidator.isAccountNumberFormatValid(accountNumber);
		assertThat(result).isTrue();
	}

	@Test
	public void testIsAccountNumberFormatValidWithInvalidValueFormatShouldReturnTrue() {
		String accountNumber = "12345A";
		boolean result = accountValidator.isAccountNumberFormatValid(accountNumber);
		assertThat(result).isFalse();
	}

	@Test
	public void testIsPinLengthSixWithValidValueShouldReturnTrue() {
		String pin = "123456";
		boolean result = accountValidator.isPinLengthSix(pin);
		assertThat(result).isTrue();
	}

	@Test
	public void testIsPinLengthSixShouldReturnWithValueMoreThanSixShouldReturnFalse() {
		String pin = "12345678";
		boolean result = accountValidator.isPinLengthSix(pin);
		assertThat(result).isFalse();
	}

	@Test
	public void testIsPinLengthSixShouldReturnWithValueLessThanSixShouldReturnFalse() {
		String pin = "1234";
		boolean result = accountValidator.isPinLengthSix(pin);
		assertThat(result).isFalse();
	}

	@Test
	public void testIsPinFormatValidWithValidValueShouldReturnTrue() {
		String pin = "123456";
		boolean result = accountValidator.isPinFormatValid(pin);
		assertThat(result).isTrue();
	}

	@Test
	public void testIsPinFormatValidWithInvalidValueFormatShouldReturnTrue() {
		String pin = "12345A";
		boolean result = accountValidator.isPinFormatValid(pin);
		assertThat(result).isFalse();
	}

}
