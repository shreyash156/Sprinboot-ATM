package com.project.springbootATM.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.springbootATM.model.Transactions;

public interface TransactionDao extends JpaRepository<Transactions, Long> {

	
	
	@Query(value="Select * from Transactions  where acc_no=:accno",nativeQuery=true)
	List<Transactions> findAllTransactions(long accno);


}
