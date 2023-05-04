package fr.emile.jsfsix.backingbean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.emile.jsfsix.common.IConstant;
import fr.emile.jsfsix.entity.Student;
import fr.emile.jsfsix.enums.DevLang;
import fr.emile.jsfsix.enums.Gender;
import fr.emile.jsfsix.enums.Position;
import fr.emile.jsfsix.enums.ServiceLevel;
import fr.emile.jsfsix.utils.Utils;

@ManagedBean(name = "enlistBean", eager = true)
@SessionScoped
public class EnlistBean implements IConstant {

	private int id;
	private String firstname;
	private String lastname;
	private String gender;
	private String birthdate;
	private String email;
	private String serviceLevel;
	private String address;
	private String phone;
	private String position;
	private String available;
	private String number;
	private String street;
	private String zipCode;
	private String city;
	private String information;
	
	private boolean addMode;
	private Student student;
	private List<String> genderList;
	private List<String> serviceLevelList;
	private List<String> positionList;
	private List<String> availableList;
	private List<String> langListChoice;
	private List<String> langListSelected;


	public EnlistBean() {

		genderList = new ArrayList<String>();
		serviceLevelList = new ArrayList<String>();
		positionList = new ArrayList<String>();
		availableList = new ArrayList<String>();
		langListChoice = new ArrayList<String>();
		langListSelected = new ArrayList<String>();

		availableList.add("Oui");
		availableList.add("Non");

		for (Gender oneValue : Gender.values()) {
			if (oneValue == Gender.NULL)
				genderList.add("?");
			else
				genderList.add(oneValue.getValue());
		}

		for (ServiceLevel oneValue : ServiceLevel.values()) {
			if (oneValue == ServiceLevel.NULL)
				serviceLevelList.add("none");
			else
				serviceLevelList.add(oneValue.getValue());
		}

		for (Position oneValue : Position.values()) {
			if (oneValue == Position.NULL)
				positionList.add("?");
			else
				positionList.add(oneValue.getValue());
		}

		for (DevLang oneValue : DevLang.values()) {
			if (oneValue == DevLang.NULL)
				langListChoice.add("?");
			else
				langListChoice.add(oneValue.getValue());
		}

	}

	public EnlistBean(String firstname, String lastname, String gender, String birthdate, String email,
			String serviceLevel, Student student) {
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setGender(gender);
		this.setBirthdate(birthdate);
		this.setEmail(email);
		this.setServiceLevel(serviceLevel);
		this.setStudent(student);
	}
	
	public EnlistBean(Student student) {
		this(student.getFirstname(),
				student.getLastname(),
				student.getGender().getValue(),
				Utils.date2String(student.getBirthdate(),DATE_FORMAT),
				student.getEmail(),
				student.getServiceLevel().getValue(),
				student);
	}
		
			
	
	public void validateChange() {
		Student modStudent = new Student(
				this.getId(),
				this.getFirstname(),
				this.getLastname(),
				Gender.fromString(this.getGender()),
				Utils.string2Date(this.getBirthdate(),DATE_FORMAT),
				this.getEmail(),
				ServiceLevel.fromString(this.getServiceLevel()),
				this.getPhone(),
				Position.fromString(this.getPosition()),
				Boolean.parseBoolean(this.getAvailable())
				);
				
		modStudent.setDesiredLanguageList(DevLang.stringList2LangList(this.getLangListSelected()));
		modStudent.update();
		this.setAddMode(false);
		this.resetFields();
		System.out.println("validateChange");
		
		
	}
	public void resetFields()  {
		this.setFirstname("");
		this.setLastname("");
		this.setGender("");
		this.setBirthdate("");
		this.setEmail("");
		this.setServiceLevel("");
		this.setPhone("");
		this.setAddress("");
		this.setLangListSelected(null);
		
		
	}
	public void modify(AttendeeListBean attendeeListBean)  {
		List<String> myLangList = new ArrayList<String>();
		
		String tabLang[]=attendeeListBean.getLangList();
		
		for (String oneLang : tabLang) {
			myLangList.add(oneLang);
			
		}

		
		this.setId(attendeeListBean.getId());                                    
		this.setFirstname(attendeeListBean.getFirstname());                                    
		this.setLastname(attendeeListBean.getLastname());                                     
		this.setBirthdate(attendeeListBean.getBirthdate());     
		this.setEmail(attendeeListBean.getEmail());                                        
		this.setPhone(attendeeListBean.getPhone());                                        
		this.setAddress(attendeeListBean.getAddress());                                        
		this.setServiceLevel(attendeeListBean.getServiceLevel());
		this.setPosition(attendeeListBean.getPosition());
		this.setAvailable(attendeeListBean.getAvailable());                            
		this.setGender(attendeeListBean.getGender());                            
		this.setLangListSelected(myLangList);                            
		this.setStudent(student);                                                  
		this.setAddMode(true);
		
		
		
	}
	public void enroll() {

		Student student = new Student(DEFAULT_ID, this.getFirstname(), this.getLastname(),
				Gender.fromString(this.getGender()), Utils.string2Date(this.getBirthdate(), DATE_FORMAT),
				this.getEmail(), ServiceLevel.fromString(this.getServiceLevel()), this.getPhone(),
				Position.fromString(this.getPosition()), Boolean.valueOf(this.getAvailable())

		);

		for (String langString : langListSelected) {

			student.addLanguage(DevLang.fromString(langString));

		}

		student.add();
		this.resetFields();

	}

	public void addMod() {

		System.out.println("public void addMod()");
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getServiceLevel() {
		return serviceLevel;
	}

	public void setServiceLevel(String serviceLevel) {
		this.serviceLevel = serviceLevel;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public boolean isAddMode() {
		return addMode;
	}

	public boolean getAddMode() {
		return addMode;
	}

	public void setAddMode(boolean addMode) {
		this.addMode = addMode;
	}

	public List<String> getGenderList() {
		return genderList;
	}

	public void setGenderList(List<String> genderList) {
		this.genderList = genderList;
	}

	public List<String> getServiceLevelList() {
		return serviceLevelList;
	}

	public void setServiceLevelList(List<String> serviceLevelList) {
		this.serviceLevelList = serviceLevelList;
	}

	public List<String> getPositionList() {
		return positionList;
	}

	public void setPositionList(List<String> positionList) {
		this.positionList = positionList;
	}

	public List<String> getAvailableList() {
		return availableList;
	}

	public void setAvailableList(List<String> availableList) {
		this.availableList = availableList;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<String> getLangListChoice() {
		return this.langListChoice;
	}

	public void setLangListChoice(List<String> langListChoice) {
		this.langListChoice = langListChoice;
	}

	public List<String> getLangListSelected() {
		return this.langListSelected;
	}

	public void setLangListSelected(List<String> langListSelected) {
		this.langListSelected = langListSelected;
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



	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	
}
