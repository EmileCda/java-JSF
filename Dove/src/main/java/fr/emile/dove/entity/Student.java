package fr.emile.dove.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import fr.emile.dove.common.IConstant;
import fr.emile.dove.utils.Utils;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Student",propOrder ={
		"firstname","lastname","age","email","speciality"
		
})
@Entity
@Table(name = "student")
@XmlRootElement

public class Student implements IConstant {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@XmlTransient
	private Integer id;
	@XmlElement(required = true)
	private String firstname;
	@XmlElement(required = true)
	private String lastname;
	@XmlElement(required = true)
	@Column(nullable=false, unique=true)
	private String email;
	@XmlElement(required = true)
	private String speciality;

	
	@XmlElement(required = true)
	private Integer age;

	@XmlTransient
	private Boolean isCorrect ;
	
	public Student() {
		
		this(DEFAULT_ID,"","","",DEFAULT_AGE,"");
	}
	
	public Student( String firstname, String lastname,  String email, Integer age, String speciality) {
		this(DEFAULT_ID,firstname,lastname,email,age,speciality);
	}
	
	public Student(Integer id, String firstname, String lastname, String email, Integer age, String speciality) {
		this.setIsCorrect(true);
		this.setId ( id);
		this.setFirstname ( firstname);
		this.setLastname ( lastname);
		this.setAge ( age);
		this.setSpeciality ( speciality);
		this.setEmail ( email);
	}

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
		this.setIsCorrect(firstname.isEmpty());
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.setIsCorrect(lastname.isEmpty());
		
		this.lastname = lastname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.setIsCorrect(speciality.isEmpty());

		this.speciality = speciality;
	}

	@Override
	public String toString() {
		return String.format("id:%d %s %s %d : %s", getId(), getFirstname(), getLastname(), getAge(), getSpeciality());

	}

	public Boolean getIsCorrect() {
		return this.isCorrect();
	}

	public Boolean isCorrect() {
		if (this.getFirstname().isEmpty() ||
		this.getLastname().isEmpty()) {

			this.setIsCorrect(false);
			
		}
		return this.isCorrect;
	}

	public void setIsCorrect(Boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
