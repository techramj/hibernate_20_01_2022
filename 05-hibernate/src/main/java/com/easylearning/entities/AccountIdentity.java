package com.easylearning.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class AccountIdentity implements Serializable {

	private Long accountId;

	private String bankName;

	public AccountIdentity() {
	}

	public AccountIdentity(Long accountId, String bankName) {
		super();
		this.accountId = accountId;
		this.bankName = bankName;
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

	@Override
	public int hashCode() {
		return Objects.hash(accountId, bankName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountIdentity other = (AccountIdentity) obj;
		return Objects.equals(accountId, other.accountId) && Objects.equals(bankName, other.bankName);
	}

}
