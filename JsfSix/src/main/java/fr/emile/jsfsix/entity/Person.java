package fr.emile.jsfsix.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.emile.jsfsix.model.dao.AddressDao;
import fr.emile.jsfsix.model.dao.IAddressDao;
import fr.emile.jsfsix.entity.Address;
import fr.emile.jsfsix.common.IConstant;
import fr.emile.jsfsix.enums.Gender;
import fr.emile.jsfsix.enums.Position;
import fr.emile.jsfsix.enums.ServiceLevel;
import fr.emile.jsfsix.utils.Utils;

public class Person implements IConstant {
	private int id;
	private String firstname ;
	private String lastname ;
	private Gender gender ;
	private Date birthdate;
	private String email ;
	private String phone ;
	private List<Address> addressList;
	private boolean isDeleted;
	
	public Person() {
		this(DEFAULT_ID,"","",Gender.NULL,NULL_DATE,"","");
		
	}
	public Person(int id, String fistname, String lastname, Gender gender, Date birthdate, 
			String email, String phone
			) {
		this.setId ( id);
		this.setFirstname( fistname);
		this.setLastname ( lastname);
		this.setGender ( gender);
		this.setBirthdate ( birthdate);
		this.setEmail ( email);
		this.setPhone (phone);
		this.setDeleted (false);
		
		this.initAddressList();
	}

	public void addAddress(Address oneAddress) {
		this.getAddressList().add(oneAddress) ;
	}


	public void initAddressList() {
		
		if (this.getAddressList() == null)
			addressList = new ArrayList<Address>() ;		
		else
			this.getAddressList().clear(); 
		
		if (this.getId() >0 ) {
			final IAddressDao myAddressDao = new AddressDao();
			try {

				addressList = myAddressDao.get(this.getId());
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		
	}

	public int getId() {
		return this.id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String fistname) {
		this.firstname= fistname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public Gender getGender() {
		return gender;
	}


	public void setGender(Gender gender) {
		this.gender = gender;
	}


	public Date getBirthdate() {
		return birthdate;
	}


	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public List<Address> getAddressList() {
		return addressList;
	}


	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}


	public boolean isDeleted() {
		return isDeleted;
	}


	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	@Override
	public String toString() {
		return String.format("id:%d %s %s %s %s [%s]",
				this.getId(),
				getFirstname(),getLastname(),
				getGender(), Utils.date2String(getBirthdate(),DATE_FORMAT), getEmail());
				
	}
	
	
	
}
