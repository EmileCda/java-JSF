package fr.emile.lunh.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;

import fr.emile.lunh.utils.Utils;
import fr.emile.lunh.entity.Address;
//import fr.emile.redrose.entity.BankCard;
//import fr.emile.redrose.entity.Order;
import fr.emile.lunh.common.IConstant;
import fr.emile.lunh.enums.Gender;

//@Entity
//@Table(name = "user")
@XmlRootElement
public class User implements Serializable, IConstant {
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	@Column(nullable=false)
	private String firstname;
	@Column(nullable=false)
	private String lastname;
	private Gender gender;
	@Column(nullable=false)
	private Date birthdate;
	@Column(nullable=false, unique=true)
	private String email;
	private byte[] encryptPass;
	@Column(columnDefinition="tinyint(1) default false")
	private Boolean isDeleted ;
	
//	@Embedded
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name="address_id", nullable = false)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user" )
	private List<Address> addressList ;
//	private List<BankCard> bankCardList ;
//	private List<Order> orderList ;
	
	public User( ) {
		this(DEFAULT_ID,DEFAULT_GENDER,"","",NULL_DATE,DEFAULT_EMAIL,false);
		
	}
	
	public User( Gender gender,String firstname, String lastname, Date birthdate, String email) {
		this(DEFAULT_ID,gender,firstname,lastname,birthdate,email,false);
	}
	
	
	public User(Integer id, Gender gender,String firstname, String lastname, Date birthdate, String email, boolean isDeleted) {
		this.setId ( id);
		this.setGender(gender);
		this.setFirstname ( firstname);
		this.setLasttname ( lastname);
		this.setBirthdate ( birthdate);
		this.setEmail ( email);
		this.setDeleted ( isDeleted);
	}
	

//-------------------- processing methode ---------------------------------------------------------
	
	public void addAddress(Address address) {
		
		address.setUser(this);
		this.getAddressList().add(address);
	}
//-------------------------------------------------------------------------------------------------
	public void addAddress(List<Address> addressList) {
		
		for (Address address : addressList) {
			this.addAddress( address);
		}
	}
	
//-------------------- Getter /setter -------------------------------------------------------------

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
	public String getLasttname() {
		return lastname;
	}
	public void setLasttname(String lasttname) {
		this.lastname = lasttname;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public Boolean isDeleted() {
		return this.GetDeleted();
	}

	public Boolean GetDeleted() {
		return this.isDeleted;
	}

	public void setDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Version
	protected Integer version;


	public Integer getVersion() {
		return version;
	}


	public void setVersion(Integer version) {
		this.version = version;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public List<Address> getAddressList() {
		if (addressList == null) {
			this.addressList= new ArrayList<Address>();
		}
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}
			
	@Override
	public String toString() {
		return String.format("%d : %s %s %s %s %s",getId(), 
				getGender().getTitle(),
				getFirstname(), getLasttname(), 
				Utils.date2String(this.getBirthdate(),"dd/MM/yyyy"),this.getEmail());
	}

	public byte[] getEncryptPass() {
		return encryptPass;
	}

	public void setEncryptPass(byte[] encryptPass) {
		this.encryptPass = encryptPass;
	}


}
