package com.rishipal.Xml;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class main {
	public static void main(String arg[]) throws JAXBException {
		JAXBContext contextObj = JAXBContext.newInstance(Company.class);
//		---------------- Marshalling ----------------------------------
		Marshaller marshallerObj = contextObj.createMarshaller();
		marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		Employee e1 = new Employee(1,"Rishipal", "Intern", "1/1/1");
		Employee e2 = new Employee(2,"Balpreet", "Intern", "2/2/2");
		Employee e3 = new Employee(3,"Pawan", "Intern", "3/3/3");
		
		Company accolite = new Company(new ArrayList<Employee>(Arrays.asList(e1,e2,e3)), "Accolite");
		marshallerObj.marshal(accolite, new File("E:\\Company.xml"));
		System.out.println("Done");
		
//		------------- UnMarshalling ------------------------------------
//		Unmarshaller unmarshalObj = contextObj.createUnmarshaller();
//		Company company=(Company) unmarshalObj.unmarshal(new File("Company.xml"));
//	    System.out.println(company);
	}
}
