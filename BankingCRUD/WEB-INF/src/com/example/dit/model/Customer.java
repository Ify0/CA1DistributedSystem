package com.example.dit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name = "customer")
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
	    	this.address = address;
	    	this.phoneNumber = phoneNumber;
	    	this.annualSalary = annualSalary;
	    }

	    @XmlElement
		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}
		@XmlElement
		public String  getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		@XmlElement
		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}
		@XmlElement
		public int getAnnualSalary() {
			return annualSalary;
		}

		public void setAnnualSalary(int annualSalary) {
			this.annualSalary = annualSalary;
		}
		@XmlElement
		public String getCustomerId() {
			return customerId;
		}
		
		public void setCustomerId(String customerId) {
			this.customerId = customerId;
		}
}
