package fr.emile.fabric.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee implements Serializable{

	private static final long serialVersionUID = -5123571793775365259L;
	private Integer id;
	private String firstname;
	private String lastname;
	private String position;
	
	
	public Employee() {
		
	}

	public Employee(String firstname, String lastname) {
		
		this(-1,firstname, lastname, "no-position");
		
	}
	public Employee(String firstname, String lastname, String position) {
		
		this(-1,firstname, lastname,position);
		
	}

	public Employee(Integer id, String firstname, String lastname, String position) {
		this.setId(id);
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setPosition(position);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return String.format("[%d] %s %s %s", getId(), getFirstname(),
				getLastname(), getPosition());
	}
	
	
	public String toXml() {
	
		String stringReturn = "";

		stringReturn += String.format("<%s>\n","employee" );
		stringReturn += String.format("<id>%d</id>\n",this.getId() );
		stringReturn += String.format("<lastname>%s</lastname>\n",this.getLastname() );
		stringReturn += String.format("<firstname>%s</firstname>\n",this.getFirstname() );
		stringReturn += String.format("<position>%s</position>\n",this.getPosition() );
		stringReturn += String.format("</%s>\n","employee" );
		
		
		return stringReturn;
	}
	
	public String toJson() {
		String stringReturn = "";
		stringReturn += String.format("{\"id\":\"%d\",\"lastname\":\"%s\",\"firstname\":\"%s\", \"position\":\"%s\"}",
				this.getId() ,
				this.getLastname(),
				this.getFirstname(),
				this.getPosition() );
		return stringReturn;
	}

}
