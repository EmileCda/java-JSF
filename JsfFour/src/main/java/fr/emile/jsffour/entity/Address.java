package fr.emile.jsffour.entity;

import fr.emile.jsffour.common.IConstant;

public class Address implements IConstant {

	// ---------------attribut ---------------------
	private int id;
	private String number;
	private String street;
	private String city;
	private String zipCode;
	private int idUser;
	private boolean isValide;
	private boolean isDeleted;

	// ------------------------ constructor --------------
	/**
	 * @param number
	 * @param street
	 * @param city
	 * @param zipCode
	 */
	public Address(int id, String number, String street, String city, String zipCode, int idUser,boolean isValid) {
		this.setId(id);
		this.setNumber(number);
		this.setStreet(street);
		this.setCity(city);
		this.setZipCode(zipCode);
		this.setIdUser(idUser);
		this.setValide(isValid);
	}

	public Address(String number, String street, String city, String zipCode) {
		this(DEFAULT_ID, number, street, city, zipCode, DEFAULT_ID,true);
	}

	public Address(String number, String street, String city, String zipCode, int iduser) {
		this(DEFAULT_ID, number, street, city, zipCode, iduser,true);
	}

	public Address() {
		this(DEFAULT_ID, DEFAULT_ADDRESS_NUMBER, DEFAULT_ADDRESS_STREET, DEFAULT_ADDRESS_CITY, DEFAULT_ADDRESS_ZIP_CODE,
				DEFAULT_ID,true);
	}

	// ---------------processing methode ---------------------

	// ----------- getter-Setter--------------------

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
		return String.format("Id:%d =>%s, %s %s %s =>userId [%d]", getId(), getNumber(), getStreet(), getZipCode(),
				getCity(), getIdUser());
	}

}
