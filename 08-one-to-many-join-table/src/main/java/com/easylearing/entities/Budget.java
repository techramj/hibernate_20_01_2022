package com.easylearing.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Budget {

	@Id
	@GeneratedValue
	private Long budgetId;

	
	private String name;

	@Column(name="GOAL_AMOUNT")
	private BigDecimal goalAmount;

	private String period;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "BUDGET_TRANSACTION", joinColumns = @JoinColumn(name="BUDGET_ID"),
	inverseJoinColumns = @JoinColumn(name="TRANSACTION_ID")
	)
	private List<Transaction> transaction = new ArrayList<Transaction>();

	public Budget() {	
	}
	
	public Budget(String name, BigDecimal goalAmount, String period) {
		this.name = name;
		this.goalAmount = goalAmount;
		this.period = period;
	}

	public Long getBudgetId() {
		return budgetId;
	}

	public void setBudgetId(Long budgetId) {
		this.budgetId = budgetId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getGoalAmount() {
		return goalAmount;
	}

	public void setGoalAmount(BigDecimal goalAmount) {
		this.goalAmount = goalAmount;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public List<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}
	
	

}
