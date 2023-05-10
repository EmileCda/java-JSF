package fr.emile.dove.entity;

import fr.emile.dove.common.IConstant;

public class Student implements IConstant {

	private Integer id;
	private String firstname;
	private String lastname;
	private Integer age;
	private String speciality;

	public Student() {
		
		this(DEFAULT_ID,"","",DEFAULT_AGE,"");
	}
	
	public Student( String firstname, String lastname, Integer age, String speciality) {
		this(DEFAULT_ID,firstname,lastname,age,speciality);
	}
	
	public Student(Integer id, String firstname, String lastname, Integer age, String speciality) {
		this.setId ( id);
		this.setFirstname ( firstname);
		this.setLastname ( lastname);
		this.setAge ( age);
		this.setSpeciality ( speciality);
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
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
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
		this.speciality = speciality;
	}

	@Override
	public String toString() {
		return String.format("id:%d %s %s %d : %s", getId(), getFirstname(), getLastname(), getAge(), getSpeciality());

	}

}
