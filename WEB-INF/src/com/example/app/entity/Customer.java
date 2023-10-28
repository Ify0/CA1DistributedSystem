package com.example.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	 
	    private String name;
	    private String phoneNumber;
	    private String address;
	    private int annualSalary;
	    
	    public Customer() {
	    	
	    }
	    
	    public Customer (String name , String phoneNumber , String address , int annualSalary) {
	    	this.name = name;
	    	this.phoneNumber = phoneNumber;
	    	this.address = address;
	    	this.annualSalary = annualSalary;
	    }

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public int getAnnualSalary() {
			return annualSalary;
		}

		public void setAnnualSalary(int annualSalary) {
			this.annualSalary = annualSalary;
		}
		
		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
		}
}
