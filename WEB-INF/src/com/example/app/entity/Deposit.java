package com.example.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@NamedQueries({
@NamedQuery(name = "Deposit.findbyId" , query = "select o from Deposit o where o.id = id"),
})
@Entity
public class Deposit {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	private int depositAmount;
	private String date;
	
	@ManyToOne
	private Loan loan;
	
	public Deposit() {
		
	}

	public Deposit(int depositAmount , String date) {
		this.depositAmount = depositAmount;
		this.date = date;
	}
	
	public int getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(int depositAmount) {
		this.depositAmount = depositAmount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Loan getLoan() {
		return loan;
	}
	
	public void setLoan (Loan loan) {
		this.loan = loan;
	}
}
