package com.billing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user", catalog = "apartmentbilling")
public class User {
	private int ID;
	private String name;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "ID", unique = true, nullable = false)
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	@Column(name = "NAME", unique = true, nullable = false, length = 45)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
