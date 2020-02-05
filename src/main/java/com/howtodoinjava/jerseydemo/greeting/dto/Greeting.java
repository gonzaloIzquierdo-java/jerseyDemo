package com.howtodoinjava.jerseydemo.greeting.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "greeting")
public class Greeting implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@XmlAttribute(name = "id")
	private  String id;
	
	@XmlAttribute(name = "content")
	private  String content;
	
	
	//sino no serializa en el post
	public Greeting() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Greeting(String id, String content) {
		super();
		this.id = id;
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
	
	
	
}
