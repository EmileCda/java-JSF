package fr.emile.bluemoon.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import fr.emile.bluemoon.common.IConstant;

@Entity
@Table(name = "address")
public class Address implements IConstant, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	private Integer number;
	private String numberType;
	private String street;
	private String streetType;
	@Column(nullable=false)
	private String city;
	@Column(nullable=false)
	private String zipCode;
	@Column(nullable=false,columnDefinition = "tinyint(1) default true")
	private Boolean isValide;
	@Column(nullable=false,columnDefinition="tinyint(1) default false")
	private Boolean isDeleted;

	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	
	public Address() {
		this(DEFAULT_ID,DEFAULT_ID,"","","","","",true,false);
	
	}
	
	public Address( Integer number,String numberType,String streetType, String street, String city, String zipCode) {
		this(DEFAULT_ID,number,numberType,streetType,street, city,zipCode,true,false);

	}

	public Address(Integer id, Integer number,
			String numberType, String streetType,String street, String city, String zipCode, 
			Boolean isValide,Boolean isDeleted) {
		this.setId(id);
		this.setNumber(number);
		this.setNumberType(numberType);
		this.setStreetType(streetType);
		this.setStreet(street);
		this.setCity(city);
		this.setZipCode(zipCode);
		this.setValide(isValide);
		this.setDeleted(isDeleted);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

//	public int getIdUser() {
//		return idUser;
//	}
//
//	public void setIdUser(int idUser) {
//		this.idUser = idUser;
//	}

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
		return String.format("%d : %s%s, %s %s %s %s",
				this.getId(),
				this.getNumber(),
				this.getNumberType(),
				this.getStreetType(),
				this.getStreet(),
				this.getZipCode(),
				this.getCity());
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getNumberType() {
		return numberType;
	}
	public void setNumberType(String numberType) {
		this.numberType = numberType;
	}
	public Boolean getIsValide() {
		return isValide;
	}
	public void setIsValide(Boolean isValide) {
		this.isValide = isValide;
	}
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public void setId(Integer id) {
		this.id = id;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStreetType() {
		return streetType;
	}

	public void setStreetType(String streetType) {
		this.streetType = streetType;
	}

//	public Integer getUserId() {
//		return userId;
//	}
//
//	public void setUserId(Integer userId) {
//		this.userId = userId;
//	}

}
