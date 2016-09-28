package com.billing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "common_expenses", catalog = "apartmentbilling")
public class PerPersonExpenses {
	private String SPENTBY;
	private int AMOUNT;



	@Column(name = "SPENTBY", unique = true, nullable = false, length = 45)
	public String getSPENTBY() {
		return SPENTBY;
	}

	public void setSPENTBY(String sPENTBY) {
		SPENTBY = sPENTBY;
	}

	@Column(name = "AMOUNT", unique = true, nullable = false)
	public int getAMOUNT() {
		return AMOUNT;
	}

	public void setAMOUNT(int aMOUNT) {
		AMOUNT = aMOUNT;
	}

}
