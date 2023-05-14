package fr.emile.jsfsix.backingbean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.emile.jsfsix.common.IConstant;
import fr.emile.jsfsix.entity.Address;
import fr.emile.jsfsix.entity.Student;
import fr.emile.jsfsix.enums.DevLang;
import fr.emile.jsfsix.model.dao.IStudentDao;
import fr.emile.jsfsix.model.dao.StudentDao;
import fr.emile.jsfsix.utils.Utils;


@ManagedBean(name = "attendeeListBean", eager = true)
@SessionScoped
public class DisplayEnlistBean implements IConstant  {
	private int id;
	private String firstname;
	private String lastname;
	private String email;
	private String gender;
	private String birthdate;
	private String serviceLevel;
	private String address;
	private String phone;
	private String position;
	private String available;
	private String langList[];

	List<DisplayEnlistBean> attendeeList ; 
	
	
	public DisplayEnlistBean(int id,String firstname, String lastname, String email, String gender, 
			String birthdate, String serviceLevel,
			String address, String phone, String position, String available, String langList[]
			) {
		this.setId ( id);
		this.setFirstname ( firstname);
		this.setLastname ( lastname);
		this.setEmail ( email);
		this.setGender(gender);
		this.setBirthdate ( birthdate);
		this.setServiceLevel ( serviceLevel);
		this.setAddress ( address);
		this.setPhone ( phone);
		this.setPosition ( position);
		this.setAvailable ( available);
		this.setLangList ( langList);
		this.attendeeList = new ArrayList<DisplayEnlistBean>();
	}


	public DisplayEnlistBean() {
		
		this.attendeeList = new ArrayList<DisplayEnlistBean>();
		
		if (this.getAttendeeList().size()<=0 ) {
			
			this.initAttendeeList();
		}
		
		
	}

	public void initAttendeeList() {
		final IStudentDao myStudentDao = new StudentDao();
		try {
			List<Student> studentList = new ArrayList<Student>();
			
			studentList = myStudentDao.get();
			
			
			
			for (Student student : studentList) {
			
				
				String AdressList= "" ;
				
				for (Address address : student.getAddressList()) {
					
//					AdressList+= String.format("%s,%s %s %s<br/>A\n", 
//										address.getNumber(),
//										address.getStreet(),
//										address.getZipCode(),
//										address.getCity());
					
					AdressList+= address.toString() + "<br />";
				}
				
				DisplayEnlistBean attendee  = new DisplayEnlistBean(
						student.getId(),
						student.getFirstname(),
						student.getLastname(),
						student.getEmail(),
						student.getGender().getValue(),
						Utils.date2String(student.getBirthdate(),DATE_FORMAT),
						student.getServiceLevel().getValue(),
						AdressList,
						student.getPhone(),
						student.getCurrentPosition().getValue(),
						Boolean.toString(student.isAvailable()),
						DevLang.list2array(student.getDesiredLanguageList()));
						
				
				this.getAttendeeList().add(attendee);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	
	
	public void reload() {
		
		System.out.println("public void reload()");
		this.getAttendeeList().clear();
		this.initAttendeeList() ;
		
	}
	
	
	public void modify(Student AttendeeListBean){
		
		
		
	}
	public void delete(DisplayEnlistBean AttendeeListBean){
		
		this.getAttendeeList().remove(AttendeeListBean);
		try {
			Student student = new Student();
			student.setId(AttendeeListBean.getId());
			student.remove();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
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


	public String getBirthdate() {
		return birthdate;
	}


	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}


	public String getServiceLevel() {
		return serviceLevel;
	}


	public void setServiceLevel(String serviceLevel) {
		this.serviceLevel = serviceLevel;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
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


	public String[] getLangList() {
		return this.langList;
	}


	public void setLangList(String langList[]) {
		this.langList = langList;
	}


	public List<DisplayEnlistBean> getAttendeeList() {
		return attendeeList;
	}


	public void setAttendeeList(List<DisplayEnlistBean> attendeeList) {
		this.attendeeList = attendeeList;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}



}
