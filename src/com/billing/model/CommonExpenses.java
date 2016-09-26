package com.billing.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "common_expenses", catalog = "apartmentbilling")
public class CommonExpenses implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private int amount;
	private String spentby;
	private Date enteredDate;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "NAME", unique = true, nullable = false, length = 45)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "AMOUNT", unique = true, nullable = false)
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Column(name = "SPENTBY", unique = true, nullable = false, length = 45)
	public String getSpentby() {
		return spentby;
	}

	public void setSpentby(String spentby) {
		this.spentby = spentby;
	}

	@Column(name = "ENTEREDDATE", nullable = false)
	public Date getEnteredDate() {
		return enteredDate;
	}

	public void setEnteredDate(Date enteredDate) {
		this.enteredDate = enteredDate;
	}
}
