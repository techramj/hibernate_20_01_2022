package com.easylearning.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Account {

	@Id
	@GeneratedValue
	@Column(name = "ACCOUNT_ID")
	private Long accountId;

	private String name;

	@Column(name = "CURRENT_BALANCE")
	private BigDecimal currentBalance;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ACCOUNT_ID")
	List<Transaction> transactions = new ArrayList<Transaction>();

	public Account() {
	}

	public Account(String name, BigDecimal currentBalance) {
		super();
		this.name = name;
		this.currentBalance = currentBalance;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(BigDecimal currentBalance) {
		this.currentBalance = currentBalance;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

}
