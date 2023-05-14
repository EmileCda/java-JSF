package fr.emile.jsfsix.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.emile.jsfsix.common.IConstant;
import fr.emile.jsfsix.utils.Utils;

public class User implements IConstant {
	private int id;
	private String firstname;
	private String lastname;
	private String tarte = "";
	private Date dateOfBirth;
	private String birthDateText = "";
	private int serviceLevel;
	private int gender;
	private String monMail = "";
	private String email = "";

	private List<Address> addressList;
	private List<BankCard> bankCardList;
	private List<Order> orderList;
	private boolean isDeleted;

//---------------------------------------------------------------------------------------------------------------------
	// ------------------------ constructor --------------
	/**
	 * @param firstname
	 * @param lastname
	 * @param dateOfBirth
	 */
	public User(int id, String firstname, String lastname, Date dateOfBirth, boolean isDeleted) {
		this.setId(id);
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setDateOfBirth(dateOfBirth);
		addressList = new ArrayList<>();
		bankCardList = new ArrayList<>();
		orderList = new ArrayList<>();
		this.setDeleted(isDeleted);
		this.setEmail(lastname);
		this.setBirthDateText(Utils.date2String(dateOfBirth, "dd/MM/yyyy"));

	}

	public User() {
		this(DEFAULT_ID, DEFAULT_FIRSTNAME, DEFAULT_LASTTNAME, new Date(), DEFAULT_IS_DELETE);
	}

	public User(String firstname, String lastname, Date dateOfBirth) {
		this(DEFAULT_ID, firstname, lastname, dateOfBirth, DEFAULT_IS_DELETE);
	}

	public User(String firstname, String lastname, String birthDate, String gender, String email) {
		this(-1, firstname, lastname, Utils.string2Date(birthDate, "dd/MM/yyyy"), false);
		this.setEmail(email);
		this.setGender(gender=="Homme" ? 1 :2);

	}

//---------------------------------------------------------------------------------------------------------------------
	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Date getDateOfBirth() {
		
		if (dateOfBirth== null)
			return new Date();
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getBirthDateText() {
		String dateText = Utils.date2String(this.getDateOfBirth(), "dd/MM/yyyy");
		this.setBirthDateText(dateText);
		return this.birthDateText;
	}

	public void setBirthDateText(String birthDateText) {
		this.birthDateText = birthDateText;
		this.setDateOfBirth(Utils.string2Date(birthDateText, "dd/MM/yyyy"));
	}

	public String getMonMail() {
		return monMail;
	}

	public void setMonMail(String monMail) {
		this.monMail = monMail;

	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public List<Address> getAddressList() {
		return addressList;
	}

	public void addAddress(Address address) {
		this.getAddressList().add(address);
	}

	public void addAddress(List<Address> addressList) {

		for (Address address : addressList) {
			this.addAddress(address);
		}
	}

	public List<BankCard> getBankCardList() {
		return bankCardList;
	}

	public void addBankCard(List<BankCard> bankCardList) {
		for (BankCard bankCard : bankCardList) {
			this.addBankCard(bankCard);
		}
	}

	public void addBankCard(BankCard bankCard) {

		if (!bankCard.isDeleted()) // add only bankCard not deleted
			this.getBankCardList().add(bankCard);
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void addOrder(List<Order> orderList) {
		for (Order order : orderList) {
			this.addOrder(order);
		}
	}

	public void addOrder(Order order) {
		this.getOrderList().add(order);
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public int getServiceLevel() {
		return serviceLevel;
	}

	public void setServiceLevel(int serviceLevel) {
		this.serviceLevel = serviceLevel;
	}

	// ---------------------------------------------------------------------------------------------------------------------
	@Override
	public String toString() {

		String result = String.format("id %d=> %s %s ", getId(), getFirstname(), getLastname());

		try {
			result += String.format("birthday %s", Utils.date2String(this.getDateOfBirth(), "dd/MM/yyyy"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		result += String.format("isDeleted : %b\n", this.isDeleted());

		result += "Adresse\n";
		for (Address address : addressList) {
			result += "\t" + address.toString() + "\n";
		}

		result += "Carte bancaire\n";
		for (BankCard bankCard : this.getBankCardList()) {
			result += "\t" + bankCard.toString() + "\n";
		}
		result += "Commande\n";
		for (Order order : this.getOrderList()) {
			result += "\t" + order.toString() + "\n";
		}

		return result;
	}

	public String getTarte() {
		return tarte;
	}

	public void setTarte(String tarte) {
		this.tarte = tarte;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
