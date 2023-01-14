package com.project.springbootATM.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Account")
public class Account {

	@Id
	@Column(length = 200)
	private Long accno;
	private String pin;
	private double Balance;

	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Transactions> Transactions;

	public Long getAccno() {
		return accno;
	}

	public void setAccno(Long accno) {
		this.accno = accno;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public double getBalance() {
		return Balance;
	}

	public void setBalance(double Balance) {
		this.Balance = Balance;
	}

	public List<Transactions> getTransactions() {
		return Transactions;
	}

	public void setTransactions(List<Transactions> transactions) {
		Transactions = transactions;
	}

	public Account(Long accno, String pin, double balance,
			List<com.project.springbootATM.model.Transactions> transactions) {
		super();
		this.accno = accno;
		this.pin = pin;
		Balance = balance;
		Transactions = transactions;

	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Account [accno=" + accno + ", pin=" + pin + ", Balance=" + Balance + ", Transactions=" + Transactions
				+ "]";
	}

}
