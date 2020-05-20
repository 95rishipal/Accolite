package com.rishipal.marshaller;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Library {
	String name;
	List<Book> books;
	public Library() {}

	@Override
	public String toString() {
		return "Library [name=" + name + ", books=" + books + "]";
	}

	public Library(String name, List<Book> books) {
		super();
		this.name = name;
		this.books = books;
	}



	@XmlElement
	public List<Book> getBooks() {
		return books;
	}
	
	
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
