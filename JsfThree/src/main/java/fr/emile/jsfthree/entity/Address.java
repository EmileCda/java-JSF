package fr.emile.jsfthree.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Address {

	private int id;
	private String number;
	private String street;
	private String city;
	private String zipCode;
	private int idUser;
	private boolean isValide;
	private boolean isDeleted;

	public Address(int id, String number, String street, String city, String zipCode, int idUser, boolean isValide,
			boolean isDeleted) {
		this.id = id;
		this.number = number;
		this.street = street;
		this.city = city;
		this.zipCode = zipCode;
		this.idUser = idUser;
		this.isValide = isValide;
		this.isDeleted = isDeleted;
	}

	public Address(ResultSet resultSet) throws SQLException {
	
		this(resultSet.getInt("id"), resultSet.getString("number"), resultSet.getString("street"),
					resultSet.getString("city"), resultSet.getString("zip_code"), resultSet.getInt("user_id"),
					resultSet.getBoolean("is_valid"),
					resultSet.getBoolean("is_deleted"));
			
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
		return "Address [getId()=" + getId() + ", getNumber()=" + getNumber() + ", getStreet()=" + getStreet()
				+ ", getCity()=" + getCity() + ", getZipCode()=" + getZipCode() + ", getIdUser()=" + getIdUser()
				+ ", isValide()=" + isValide() + ", isDeleted()=" + isDeleted() + "]";
	}

}
