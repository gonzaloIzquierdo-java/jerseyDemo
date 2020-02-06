package com.howtodoinjava.jerseydemo.curtomer.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "customer")
public class Customer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@XmlAttribute(name = "dni")
	private String dni;
	@XmlAttribute(name = "name")
	private String name;
	@XmlAttribute(name = "description")
	private String description;
	@XmlAttribute(name = "contracts")
	private List<Contract> contracts;
	
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String dni, String name, String description, List<Contract> contracts) {
		super();
		this.dni = dni;
		this.name = name;
		this.description = description;
		this.contracts = contracts;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Contract> getContracts() {
		return contracts;
	}
	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}
	
	@Override
	public String toString() {
		return "Customer [dni=" + dni + ", name=" + name + ", description=" + description + ", contracts=" + contracts
				+ "]";
	}
	
	
	
	
	
	

}
