package com.rishipal.Xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Company {
	List<Employee> list;
	String name;
	public Company() {}
	public Company(List<Employee> emps, String name) {
		super();
		this.list = emps;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Company [list=" + list + ", name=" + name + "]";
	}
	@XmlElement
	public List<Employee> getList() {
		return list;
	}

	public void setList(List<Employee> list) {
		this.list = list;
	}
	
	@XmlElement
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
