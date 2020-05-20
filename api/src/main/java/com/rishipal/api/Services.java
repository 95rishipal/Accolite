package com.rishipal.api;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import com.rishipal.Xml.Company;
import com.rishipal.Xml.Employee;

@Path("/employee")
public class Services {
	JAXBContext contextObj;
	
	public Services() throws JAXBException{
		contextObj = JAXBContext.newInstance(Company.class);
	}
	
	@GET
	@Path("/getall")
	@Produces(MediaType.APPLICATION_XML)
	public Company getAll() throws JAXBException {
		System.out.println("All");
		Company company = Unmarshaller();
		return company;
	} 
	
	
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Employee getAll(@PathParam("id") int id) throws JAXBException {
		System.out.println("Get Id -> "+ id);
		Company company = Unmarshaller();
		Employee employee=null;
		for(Employee e : company.getList()) {
			if(e.getEmpid()!=id) {
				employee = e;
			}
		}
		return employee;
	} 
	
	
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_HTML)
	public String test() {
		return "Working";
	}
	
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Company addEmp(Employee e) throws JAXBException {
		Company company = Unmarshaller();
		try {
			for(Employee emp : company.getList()) {
				if(emp.getEmpid()==e.getEmpid()) {
					return null;
				}
			}
		}catch(NullPointerException np) {
			company.setList(new ArrayList<Employee>());
		}
		company.getList().add(e);
		Marshaller(company);
		return company;
	}
	
	@PUT
	@Path("/edit/{id}")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Company editEmp(@PathParam("id") int id, Employee e) throws JAXBException {
		System.out.println("Get Id -> "+ id);
		Company company = Unmarshaller();
		int i=0;
		try {
			for(Employee emp : company.getList()) {
				if(emp.getEmpid()!=id) {
					break;
				}
				i++;
			}
		System.out.println("Edited id:"+ (i-1));
		company.getList().set(i-1, e);
		Marshaller(company);
		return company;
		}catch(IndexOutOfBoundsException ex) {
			return company;
		}
		catch(NullPointerException ex) {
			return null;
		}
	}
	
	
	@DELETE
	@Path("/del/{id}")
	public Company delete(@PathParam("id") int id) throws JAXBException 
	{       
		Company company = Unmarshaller();
		List<Employee> list = new ArrayList<Employee>();
		for(Employee e : company.getList()) {
			if(e.getEmpid()!=id) {
				list.add(e);
			}
		}
		if(list != null) {
			company.setList(list);
			Marshaller(company);
			return company;
		}
		return null;
	}
	
	
	public Company Unmarshaller() throws JAXBException {
		Unmarshaller unmarshalObj = contextObj.createUnmarshaller();
		Company company=(Company) unmarshalObj.unmarshal(new File("E:\\Company.xml"));
	    System.out.println("Unmarshalling Done!!");
		return company;
	}
	
	public void Marshaller(Company company) throws JAXBException {
		Marshaller marshallerObj = contextObj.createMarshaller();
		marshallerObj.marshal(company, new File("E:\\Company.xml"));
		System.out.println("Marshalling Done!");
	}
}
