package com.rishipal.marshaller;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class main {
	public static void main(String arg[]) throws JAXBException {
		JAXBContext contextObj = JAXBContext.newInstance(Library.class);
//		---------------- Marshalling ----------------------------------
		Marshaller marshallerObj = contextObj.createMarshaller();
		marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		Book b1 = new Book(1,"Learn Java", "ABC", "Computer Science");
		Book b2 = new Book(2,"Learn Spring", "DFG", "Computer Science");
		Book b3 = new Book(3,"Modern India ", "A", "History");
		Book b4 = new Book(4,"Science", "klo", "12th");
		Book b5 = new Book(5,"Hands on with Python", "ABC", "Computer Science");
		Library Mlibrary = new Library("Accolite",new ArrayList<Book>(Arrays.asList(b1,b2,b3,b4,b5)));
		marshallerObj.marshal(Mlibrary, new File("Library.xml"));
		System.out.println(" Marshalling Done");
		
//		------------- UnMarshalling ------------------------------------
		Unmarshaller unmarshalObj = contextObj.createUnmarshaller();
		Library Unlibrary = (Library) unmarshalObj.unmarshal(new File("Library.xml"));
	    System.out.println(Unlibrary);
	}
}
