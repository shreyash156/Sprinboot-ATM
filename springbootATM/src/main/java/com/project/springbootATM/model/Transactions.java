package com.project.springbootATM.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Transactions")
public class Transactions {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tid;
	private String transacttype;
	private Date date;
	private String status;
	private double amount;
	private double availableBalance;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "acc_no")
	@JsonIgnore
	private Account account;

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTransacttype() {
		return transacttype;
	}

	public void setTransacttype(String transacttype) {
		this.transacttype = transacttype;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Transactions(int tid, String transacttype, Date date, String status, double amount, double availableBalance,
			Account account) {
		super();
		this.tid = tid;
		this.transacttype = transacttype;
		this.date = date;
		this.status = status;
		this.amount = amount;
		this.availableBalance = availableBalance;
		this.account = account;
	}

	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Transactions [tid=" + tid + ", transacttype=" + transacttype + ", date=" + date + ", status=" + status
				+ ", amount=" + amount + ", availableBalance=" + availableBalance + ", account=" + account + "]";
	}

}
