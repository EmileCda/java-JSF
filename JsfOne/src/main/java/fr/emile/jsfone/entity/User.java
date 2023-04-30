package fr.emile.jsfone.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.emile.jsfone.common.IConstant;
import fr.emile.jsfone.enums.Gender;
import fr.emile.jsfone.enums.ServiceLevel;
import fr.emile.jsfone.utils.Utils;



public class User implements IConstant {
	private int id ; 
	private String firstname ; 
	private String lastname ; 
	private Date dateOfBirth ; 
	private Gender  gender;
	private String email;
	private ServiceLevel  serviceLevel;
	private List<Address> addressList ;
	private List<BankCard> bankCardList ;
	private List<Order> orderList ;
	private boolean isDeleted ;

//---------------------------------------------------------------------------------------------------------------------	
	//------------------------ constructor --------------
	/**
	 * @param firstname
	 * @param lastname
	 * @param dateOfBirth
	 */
	public User(int id, String firstname, String lastname, Date dateOfBirth, 
			Gender  gender,  String email, ServiceLevel serviceLevel,boolean isDeleted) {
		this.setId(id);
		this.setFirstname(firstname);
		this.setLastname ( lastname);
		this.setDateOfBirth ( dateOfBirth);
		addressList = new ArrayList<Address>(); 
		bankCardList= new ArrayList<BankCard>();
		orderList = new ArrayList<Order>();
		this.setDeleted(isDeleted);

	}
	public User() {
		this(DEFAULT_ID,DEFAULT_FIRSTNAME, DEFAULT_LASTNAME,new Date(),
				DEFAULT_GENDER,DEFAULT_EMAIL,DEFAULT_SERVICE_LEVEL,DEFAULT_IS_DELETE);
	}
	
	public User(String firstname, String lastname, Date dateOfBirth) {
		this(DEFAULT_ID,firstname, lastname,dateOfBirth,DEFAULT_GENDER,DEFAULT_EMAIL,DEFAULT_SERVICE_LEVEL,DEFAULT_IS_DELETE);
	}
	
	public User(String firstname, String lastname, String genderText, 
				String dateOfBirthText, String email, String serviceLevelText) {
		
		this(DEFAULT_ID,firstname, lastname,Utils.string2Date(dateOfBirthText,"dd/MM/yyyy"),
				Gender.fromString(genderText),email,ServiceLevel.fromString(serviceLevelText),DEFAULT_IS_DELETE);

	
	}
	public User(ResultSet resultSet) throws SQLException {
	
		this (resultSet.getInt("id"),
		resultSet.getString("firstname"),
		resultSet.getString("lastname"),
			 	Utils.toJavaDate(resultSet.getDate("date_of_birth")),
			 	DEFAULT_GENDER,DEFAULT_EMAIL,DEFAULT_SERVICE_LEVEL,
		 		resultSet.getBoolean("is_deleted"));
	
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
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public List<Address> getAddressList() {
		return addressList;
	}
	public void addAddress(Address address) {
		this.getAddressList().add(address);
	}
	public void addAddress(List<Address> addressList) {
		
		for (Address address : addressList) {
			this.addAddress( address);
		}
	}

	public List<BankCard> getBankCardList() {
		return bankCardList;
	}
	
	public void addBankCard(List<BankCard> bankCardList) {
		for (BankCard bankCard : bankCardList) {
			this.addBankCard( bankCard) ;
		}
	}
	public void addBankCard(BankCard bankCard) {
		
		if (!bankCard.isDeleted())		// add only bankCard not deleted
			this.getBankCardList().add( bankCard);
	}

	public List<Order> getOrderList() {
		return orderList;
	}
	public void addOrder(List<Order> orderList) {
		for (Order order : orderList) {
			this.addOrder(order) ;
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
	
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public ServiceLevel getServiceLevel() {
		return serviceLevel;
	}
	public void setServiceLevel(ServiceLevel serviceLevel) {
		this.serviceLevel = serviceLevel;
	}
	//---------------------------------------------------------------------------------------------------------------------	
	@Override
	public String toString() {
		
		String result= String.format(
				"id %d=> %s %s ",
				getId(), getFirstname(), getLastname());

		try {
			result +=  String.format("birthday %s",Utils.date2String(this.getDateOfBirth(),"dd/MM/yyyy"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		result +=  String.format("isDeleted : %b\n",this.isDeleted());
	
		result += "Adresse\n";
		for (Address address : addressList) {
			result += "\t"+ address.toString() + "\n";
		}

		result += "Carte bancaire\n";
		for (BankCard bankCard : this.getBankCardList()) {
			result += "\t"+ bankCard.toString() + "\n";
		}
		result += "Commande\n";
		for (Order order: this.getOrderList()) {
			result += "\t"+ order.toString() + "\n";
		}
		
		return result ;
	}
}
