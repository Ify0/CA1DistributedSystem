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

import com.example.dit.CustomerDAO;
import com.example.dit.model.Customer;



@Path ("/CustomerService")
public class CustomerService {

@GET
@Path("/customersxmlfromdb")
@Produces("application/xml")
public List<Customer> getCustomersFromDB(){
    CustomerDAO dao = new CustomerDAO();
    return dao.getAllCustomers();
}

@GET
@Path("/customersjsonfromdb")
@Produces("application/json")
public List<Customer> getJSONCustomersFromDB(){
   CustomerDAO dao = new CustomerDAO();
    return dao.getAllCustomers();
}


@GET
@Path("/jsonDB/customer/{customerName}")
@Produces("application/json")
public Customer getCustomerByNameFromDBJSON(@PathParam("customerName")String customerName){
	CustomerDAO dao = new CustomerDAO();
	return dao.getCustomerByName(customerName);		
}

@GET
@Path("/customerfromDBXML/{customerName}")
@Produces("application/xml")
public Customer getCustomerByNameFromDBXML(@PathParam("customerName")String customerName){
	CustomerDAO dao = new CustomerDAO();
	return dao.getCustomerByName(customerName);	
}

@POST
@Path("/newCustomer")
@Consumes("application/json")
public String addCustomerToDBJSON(Customer customer){
	CustomerDAO dao = new CustomerDAO();
	dao.persist(customer);
	return "Customer added to DB from JSON Param "+customer.getCustomerName();	
}

@PUT
@Path("/updateCustomer}")
@Produces("application/json")
public Customer updateCustomer(Customer customer){
	CustomerDAO dao = new CustomerDAO();
	return dao.merge(customer);	
}
 
@DELETE
@Path("/deleteCustomer/{customerName}")
@Produces("text/plain")
public String deleteCustomer(@PathParam("customerName")String customerName){
	CustomerDAO dao = new CustomerDAO();
	Customer cust = dao.getCustomerByName(customerName);
	dao.removeCustomer(cust);	
	return "Customer "+cust+" deleted";
}

}
