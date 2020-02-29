package com.kornelius.studycase3.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kornelius.studycase3.account.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

	@Query("select acc from Account acc where acc.accountNumber = :accountNumber and acc.pin= :pin ")
	Account getAccountByAccountNumberAndPin(@Param("accountNumber") String accountNumber, @Param("pin") String pin);

}
