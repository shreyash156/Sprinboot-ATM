package com.project.springbootATM.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.springbootATM.model.Account;

public interface AccountDao extends JpaRepository<Account, Long> {

	@Query("select a from Account a where a.accno=:accno")
	Account findByAccno(@Param("accno") long accno);

	

}
