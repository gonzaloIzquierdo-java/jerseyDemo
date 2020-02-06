package com.howtodoinjava.jerseydemo.curtomer.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "contract")
public class Contract implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@XmlAttribute(name = "number")
	private String number;
	
	public Contract() {
		super();
		// TODO Auto-generated constructor stub
	}

		
	public Contract(String number) {
		super();
		this.number = number;
	}




	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	
	

}
