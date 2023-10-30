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
	 
	 	private String customerId;
	    private String customerName;
	    private String phoneNumber;
	    private String address;
	    private int annualSalary;
	    
	    public Customer() {
	    	
	    }
	    
	    public Customer (String customerId , String customerName , String address , String phoneNumber , int annualSalary) {
	    	this.customerId = customerId;
	    	this.customerName = customerName;
	    	this.phoneNumber = phoneNumber;
	    	this.address = address;
	    	this.annualSalary = annualSalary;
	    }

		public String getCustomerName() {
			return customerName;
		}

		public void setcustomerName(String customerName) {
			this.customerName = customerName;
		}

		public String  getPhoneNumber() {
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
		
		public String getCustomerId() {
			return customerId;
		}
		
		public void setCustomerId(String customerId) {
			this.customerId = customerId;
		}
}
