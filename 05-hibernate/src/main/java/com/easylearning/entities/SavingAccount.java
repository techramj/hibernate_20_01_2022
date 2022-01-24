package com.easylearning.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SAVING_ACCOUNT")
public class SavingAccount{
	
	@EmbeddedId
	private AccountIdentity accountIdentity;
	
	@Column(name="NAME")
	private String accountHolderName;
	
	private Double balance;
	
	public SavingAccount() {
	}

	public SavingAccount(Long accountId, String bankName, String accountHolderName, Double balance) {
		super();
		this.accountIdentity = new AccountIdentity(accountId, bankName);
		this.accountHolderName = accountHolderName;
		this.balance = balance;
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
