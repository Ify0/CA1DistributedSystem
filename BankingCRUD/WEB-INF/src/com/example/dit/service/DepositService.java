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

import com.example.dit.DepositDAO;
import com.example.dit.model.Deposit;

@Path ("/DepositService")
public class DepositService {
	@GET
	@Path("/depositsxmlfromdb")
	@Produces("application/xml")
	public List<Deposit> DepositgetFromDB(){
		DepositDAO dao = new DepositDAO();
	    return dao.getAllDeposits();
	}

	@GET
	@Path("/depositsjsonfromdb")
	@Produces("application/json")
	public List<Deposit> DepositsgetFromDB(){
		DepositDAO dao = new DepositDAO();
	    return dao.getAllDeposits();
	}

	@GET
	@Path("/jsonDB/deposits/{depositid}")
	@Produces("application/json")
	public Deposit getDepositByIdFromDBJSON(@PathParam("depositId")String depositId){
		DepositDAO dao = new DepositDAO();
		return dao.getDepositbyId(depositId);		
	}

	@GET
	@Path("/depositsfromDBXML/{depositid}")
	@Produces("application/xml")
	public Deposit getDepositsByIdFromDBJSON(@PathParam("depositId")String depositId){
		DepositDAO dao = new DepositDAO();
		return dao.getDepositbyId(depositId);		
	}

	@POST
	@Path("/newDeposit")
	@Consumes("application/json")
	public String addDepositToDBJSON(Deposit deposit){
		DepositDAO dao = new DepositDAO();
		dao.persist(deposit);
		return "Deposit added to DB from JSON Param "+ deposit.getDepositAmount();	
	}

	@PUT
	@Path("/updateDeposit")
	@Produces("application/json")
	public Deposit updateDeposit(Deposit deposit){
		DepositDAO dao = new DepositDAO();
		return dao.merge(deposit);	
	}

	@DELETE
	@Path("/deleteDeposit/{depositsId}")
	@Produces("text/plain")
	public String deleteDepositsId(@PathParam("depositId")String depositId){
		DepositDAO dao = new DepositDAO();
		Deposit depo = dao.getDepositbyId(depositId);
		dao.removeDeposit(depo);	
		return "Deposit "+depo+" deleted";
	}

	}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            