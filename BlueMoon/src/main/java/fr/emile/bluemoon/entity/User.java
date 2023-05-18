package fr.emile.bluemoon.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Embedded;
import javax.persistence.Table;

import javax.persistence.Transient;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlInlineBinaryData;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import fr.emile.bluemoon.adaptator.ToBlob;
import fr.emile.bluemoon.common.IConstant;
import fr.emile.bluemoon.entity.Address;
import fr.emile.bluemoon.enums.Gender;
import fr.emile.bluemoon.utils.Utils;

@Entity
@XmlInlineBinaryData
@Table(name = "user")
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

	@Transient
	@XmlTransient
	private String pass;

	private byte[] encryptPass;
	@Column(columnDefinition="tinyint(1) default false")
	private Boolean isDeleted ;
	

//	https://stackoverflow.com/questions/18526877/model-class-running-multiple-queries-in-hibernate
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
	private List<Address> addressList ;

	//	private List<BankCard> bankCardList ;
//	private List<Order> orderList ;
	
	public User( ) {
		this(DEFAULT_ID,DEFAULT_GENDER,"","",NULL_DATE,DEFAULT_EMAIL,DEFAULT_PASS,false);
		
	}
	
	public User( Gender gender,String firstname, String lastname, Date birthdate, String email,String pass) {
		this(DEFAULT_ID,gender,firstname,lastname,birthdate,email,pass,false);
	}
	
	
	public User(Integer id, Gender gender,String firstname, 
			String lastname, Date birthdate, String email,
			String pass, boolean isDeleted) {
		this.setId ( id);
		this.setGender(gender);
		this.setFirstname ( firstname);
		this.setLasttname ( lastname);
		this.setBirthdate ( birthdate);
		this.setEmail ( email);
		this.setDeleted ( isDeleted);
		this.setPass(pass);
		
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
		return String.format("%d : %s %s %s %s %s %s",getId(), 
				getGender().getTitle(),
				getFirstname(), getLasttname(), 
				Utils.date2String(this.getBirthdate(),"dd/MM/yyyy"),this.getEmail(),
				this.getPass());
	}

	private byte[] getEncryptPass() {
		return encryptPass;
	}

	private void setEncryptPass(byte[] encryptPass) {
		this.encryptPass = encryptPass;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		try {
			this.setEncryptPass(ToBlob.encrypt(pass));
		} catch (Exception e) {
			Utils.trace("catch setPass(String pass)");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.pass = pass;
	}


}
