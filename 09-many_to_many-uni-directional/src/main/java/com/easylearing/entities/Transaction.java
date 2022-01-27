package com.easylearing.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "TRANSACTION_ID")
	private Long transactionId;

	@Column(name = "TRANSACTION_TYPE")
	private String transactionType;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "AMOUNT")
	private BigDecimal amount;

	@ManyToOne
	@JoinColumn(name = "ACCOUNT_ID")
	private Account account;

	public Transaction() {
	}

	public Transaction(String transactionType, String title, BigDecimal amount) {
		this.transactionType = transactionType;
		this.title = title;
		this.amount = amount;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
