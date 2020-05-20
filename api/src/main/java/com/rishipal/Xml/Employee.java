package com.rishipal.Xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {
	String name;
	int empid;
	String Desg;
	String DOB;
	
	public Employee(){}
	public Employee(int id, String name, String ds, String dob) {
		super();
		this.empid= id;
		this.name = name;
		this.Desg = ds;
		this.DOB = dob;
	}
	
	@XmlElement
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlAttribute
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	
	@XmlElement
	public String getDesg() {
		return Desg;
	}
	public void setDesg(String desg) {
		Desg = desg;
	}
	
	@XmlElement
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", empid=" + empid + ", Desg=" + Desg + ", DOB=" + DOB + "]";
	}
	
}
