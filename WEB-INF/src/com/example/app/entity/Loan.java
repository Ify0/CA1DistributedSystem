package com.example.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@NamedQueries({
@NamedQuery(name = "Loan.findbyId" , query = "select o from Loan o where o.id = id"),
})
@Entity
public class Loan {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	private String description; 
	private int loanAmount; 
	
	@OneToOne
	private Customer customer;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Deposit> deposits = new ArrayList<Deposit>();
	
	public Loan() {
		
	}
	
	public Loan(String description , int loanAmount , Customer customer) {
		this.description = description;
		this.loanAmount = loanAmount;
		this.customer = customer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Loan(List<Deposit> deposits) {
		super();
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public List<Deposit> getDeposit(){
		return deposits;
	}
	
	public void setDeposit(List<Deposit> deposits) {
		this.deposits = deposits;
	}
	

}
