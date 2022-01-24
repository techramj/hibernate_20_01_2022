package com.easylearning.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account implements Serializable{
	
	@Id
	@Column(name="ACCOUNT_ID")
	private Long accountId;
	
	@Id
	@Column(name = "BANK_NAME")
	private String bankName;
	
	@Column(name="NAME")
	private String accountHolderName;
	
	private Double balance;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(Long accountId, String bankName, String accountHolderName, Double balance) {
		super();
		this.accountId = accountId;
		this.bankName = bankName;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}


}
