package com.itheima.category.domain;

import com.itheima.account.domain.Account;

/**
 * Category entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("all")
public class Category implements java.io.Serializable {

	// Fields

	private Integer id;
	private Account account;
	private String type;
	private Boolean hot;

	// Constructors

	/** default constructor */
	public Category() {
	}

	/** full constructor */
	public Category(Account account, String type, Boolean hot) {
		this.account = account;
		this.type = type;
		this.hot = hot;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getHot() {
		return this.hot;
	}

	public void setHot(Boolean hot) {
		this.hot = hot;
	}

}