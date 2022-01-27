package com.easylearing.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long accountId;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ACCOUNT_ID")
	private List<Transaction> transactions = new ArrayList<>();

	@Column(name = "NAME")
	private String name;

	@Column(name = "CURRENT_BALANCE")
	private BigDecimal currentBalance;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="USER_ACCOUNT", joinColumns = @JoinColumn(name="ACCOUNT_ID"),
	inverseJoinColumns = @JoinColumn(name="USER_ID"))
	Set<User> users = new HashSet<User>();

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

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	

}
