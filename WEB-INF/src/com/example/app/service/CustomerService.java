package com.example.app.service;

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

import com.example.app.dao.CustomerDAO;
import com.example.app.entity.Customer;



@Path ("/CustomerService")
public class CustomerService {
	
	private static Map<String, Customer> customers = new HashMap<String, Customer>();
	
static {
		
        Customer customer1 = new Customer();
        customer1.setCustomerId("1");
        customer1.setcustomerName("John Smith");
        customer1.setAddress("Dublin , Ireland");
        customer1.setPhoneNumber("0834457898");
        customer1.setAnnualSalary(34000);
        customers.put(customer1.getCustomerId(), customer1 );
        
        Customer customer2 = new Customer();
        customer2.setCustomerId("2");
        customer2.setcustomerName("Layla Parkers");
        customer2.setAddress("Galway , Ireland");
        customer2.setAnnualSalary(45000);
        customers.put(customer2.getCustomerId(), customer2);
        
    }

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
@Path("/updateCustomer/")
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
