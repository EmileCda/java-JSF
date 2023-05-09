package fr.emile.laze.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import fr.emile.laze.common.IConstant;


@Entity
@Table(name = "address")
@XmlRootElement
@Embeddable
public class Address implements IConstant, Serializable {
	
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private String number;
	private String street;
	private String city;
	private String zipCode;
	private int idUser;
	private boolean isValide;
	private boolean isDeleted;


	public Address() {
		this(DEFAULT_ID,"","","","",DEFAULT_ID,true,false);
	}
		public Address( String number, String street, String city, String zipCode) {

		this(DEFAULT_ID,number,street, city,zipCode,DEFAULT_ID,true,false);
	}

	public Address(int id, String number, String street, String city, String zipCode, int idUser, boolean isValide,
			boolean isDeleted) {
		this.setId(id);
		this.setNumber(number);
		this.setStreet(street);
		this.setCity(city);
		this.setZipCode(zipCode);
		this.setIdUser(idUser);
		this.setValide(isValide);
		this.setDeleted(isDeleted);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public boolean isValide() {
		return isValide;
	}

	public void setValide(boolean isValide) {
		this.isValide = isValide;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return String.format("%d : %s, %s %s %s",
				this.getId(),
				this.getNumber(),
				this.getStreet(),
				this.getZipCode(),
				this.getCity());
	}

	

}
