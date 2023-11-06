package com.example.dit.service;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


import com.example.dit.LoanDAO;

import com.example.dit.model.Loan;

@Path ("/LoanService")
public class LoanService {

	@GET
	@Path("/loansxmlfromdb")
	@Produces("application/xml")
	public List<Loan> getLoansFromDB(){
	    LoanDAO dao = new LoanDAO();
	    return dao.getAllLoans();
	}

	@GET
	@Path("/loansjsonfromdb")
	@Produces("application/json")
	public List<Loan> getJSONLoansFromDB(){
		LoanDAO dao = new LoanDAO();
	    return dao.getAllLoans();
	}
	

	@GET
	@Path("/jsonDB/loan/{loanId}")
	@Produces("application/json")
	public Loan getLoanByCustomerIdFromDBJSON(@PathParam("loanId")String loanId){
		LoanDAO dao = new LoanDAO();
		return dao.getLoanbyId(loanId);		
	}

	@GET
	@Path("/loanfromDBXML/loan/{loanId}")
	@Produces("application/xml")
	public Loan getLoanByCustomerIdFromDBJSONforXML(@PathParam("loanId")String loanId){
		LoanDAO dao = new LoanDAO();
		return dao.getLoanbyId(loanId);		
		
	}
//POST Creates a new loan and the loan amount , check if the user already doesn't have a loan
	@POST
	@Path("/newLoans")
	@Consumes("application/json")
	public String addCustomerToDBJSON(Loan loan){
		LoanDAO dao = new LoanDAO();
		dao.persist(loan);
		return "Loan added to DB from JSON Param "+ loan.getLoanAmount();	
	}

	@PUT
	@Path("/updateLoan/")
	@Produces("application/json")
	public Loan updateLoan( Loan loan){
		LoanDAO dao = new LoanDAO();
		return dao.merge(loan);	
	}

	@DELETE
	@Path("/deleteLoan/{loanId}")
	@Produces("text/plain")
	public String deleteLoan(@PathParam("loanId")String loanId){
		LoanDAO dao = new LoanDAO();
		Loan loan = dao.getLoanbyId(loanId);
		dao.removeLoan(loan);	
		return "Loan "+loan.getLoanAmount()+" deleted";
	}

	}




