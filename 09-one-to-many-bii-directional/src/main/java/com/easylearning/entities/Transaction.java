package com.easylearning.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {

	@Id
	@GeneratedValue
	@Column(name="TRANSACTION_ID")
	private Long transactionId;

	@Column(name="TRANSACTION_TYPE")
	private String transactiontype;

	private String tile;

	private BigDecimal amount;
	
	@ManyToOne
	@JoinColumn(name="ACCOUNT_ID")
	private Account account;
	
	public Transaction() {
	}

	public Transaction(String transactiontype, String tile, BigDecimal amount) {
		this.transactiontype = transactiontype;
		this.tile = tile;
		this.amount = amount;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactiontype() {
		return transactiontype;
	}

	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}

	public String getTile() {
		return tile;
	}

	public void setTile(String tile) {
		this.tile = tile;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	
	
}
