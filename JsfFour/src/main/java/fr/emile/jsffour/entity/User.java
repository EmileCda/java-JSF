package fr.emile.jsffour.entity;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.emile.jsffour.common.IConstant;
import fr.emile.jsffour.utils.Utils;
import fr.emile.jsffour.entity.Address;
import fr.emile.jsffour.entity.BankCard;
import fr.emile.jsffour.entity.Order;
import fr.emile.jsffour.enums.Position;
import fr.emile.jsffour.enums.ServiceLevel;



public class User implements IConstant {
	private int id ; 
	private String firstname;
	private String lastname;
	
	private Date dateOfBirth ; 
	private boolean isDeleted ;
	private String email;
	private ServiceLevel serviceLevel;
	private String phone;
	private Position currentPosition;
	private String available;
	private List<Address> addressList ;
	private List<String> desiredLanguage;
	private List<BankCard> bankCardList ;
	private List<Order> orderList ;
	
	
	public User(int id, String firstname, String lastname, Date dateOfBirth,
			String email,ServiceLevel serviceLevel, boolean isDeleted) {
		
		this.setId(id);
		this.setFirstname(firstname);
		this.setLastname ( lastname);
		this.setDateOfBirth ( dateOfBirth);
		this.setDeleted(isDeleted);
		this.setEmail(email);
		this.setServiceLevel(serviceLevel);
		
		this.desiredLanguage = new ArrayList<String>();
		this.addressList = new ArrayList<Address>();
		this.bankCardList= new ArrayList<BankCard>();
		this.orderList = new ArrayList<Order>();

	}
	
	
	
	public User(String firstname, String lastname, String genderText, String date, String email, String levelText) {
		
		this(-1,firstname,lastname,Utils.string2Date(date,"dd/MM/yyyy"),email,ServiceLevel.fromString(levelText),false);
		

	}
	public User() {
		this(-1,"","",null,"",null,false);
	}
	
	public User(ResultSet resultSet) throws Exception {
		
		this(resultSet.getInt("id"),
				resultSet.getString("firstname"),
				resultSet.getString("lastname"),
				Utils.toJavaDate(resultSet.getDate("date_of_birth")),			
				"default email", ServiceLevel.NULL,
				resultSet.getBoolean("is_deleted"));	

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
	

	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public ServiceLevel getServiceLevel() {
		return serviceLevel;
	}



	public void setServiceLevel(ServiceLevel serviceLevel) {
		this.serviceLevel = serviceLevel;
	}



	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
	
	public void addAddress(List<Address> addressList) {
		
		for (Address address : addressList) {
			this.addAddress( address);
		}
	}

	public void addAddress(Address address) {
		
			this.addAddress( address);
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
	
	public List<String> getDesiredLanguage() {
		return desiredLanguage;
	}
	public void setDesiredLanguage(List<String> desiredLanguage) {
		this.desiredLanguage = desiredLanguage;
	}
	public List<Address> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
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
