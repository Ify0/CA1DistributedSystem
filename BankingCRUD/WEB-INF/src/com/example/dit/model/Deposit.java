package com.example.dit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "deposit")
@Entity
public class Deposit {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	private String depositId;
	private int depositAmount;
	private String date;
	
	@ManyToOne
	private Loan loan;
	
	public Deposit() {
		
	}

	public Deposit(String depositId, int depositAmount , String date) {
		this.depositId = depositId;
		this.depositAmount = depositAmount;
		this.date = date;
	}
	@XmlElement
	public int getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(int depositAmount) {
		this.depositAmount = depositAmount;
	}
	@XmlElement
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	@XmlElement
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@XmlElement
	public Loan getLoan() {
		return loan;
	}
	
	public void setLoan (Loan loan) {
		this.loan = loan;
	}
	@XmlElement
	public String getDepositId() {
		return depositId;
	}

	public void setDepositiD(String depositId) {
		this.depositId = depositId;
	}
}
