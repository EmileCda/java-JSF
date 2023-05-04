package fr.emile.jsfsix.backingbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.emile.jsfsix.entity.Student;
import fr.emile.jsfsix.entity.User;




@ManagedBean(name = "enrollmentBean", eager = true)
@SessionScoped
public class ZEnrollmentBean {

	private static boolean isInstanced = false;
	private static List<User> userList ;

	
	private int id;
	private String firstname;
	private String lastname;
	private String gender;
	private String birthdate;
	private String email;
	private String serviceLevel;
	private String address;
	private String information;
	private boolean addMode;
	private List<User> userListDisplay;

	public ZEnrollmentBean() {
		if (!ZEnrollmentBean.isInstanced()) {
			System.out.println("ici");
			ZEnrollmentBean.setInstanced( true);
			userList = new ArrayList<>();

			userList.add(new User("Louis","Laforge","20/12/2000","Homme","emmed@ememd.fr" ));
			userList.add(new User("Benoit","Leclerc","27/10/1977","Homme","Benoit@eerimed.fr" ));
			userList.add(new User("Laura","Treich","7/10/1997","Femme","Laura@yaLaura.fr" ));
			userList.add(new User("rené","sent des pieds","12/3/2007","Homme","erenez@esandd.fr" ));

		}
		userListDisplay = new ArrayList<>();
		userListDisplay  = userList ;
		this.setInformation(String.format("[%d]--[%d] \n",userList.size(),userListDisplay.size()));
		System.out.println("ici");
	}
	public ZEnrollmentBean(String firstname, String lastname, String gender, String email, String serviceLevel) {
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setGender(gender);
		this.setEmail(email);
		this.setServiceLevel(serviceLevel);
		this.setInformation("tout va bien ");
		this.setAddress("1, rue truc ");
		this.setAddMode(true);
	}

	public void addStudent() {

		this.setInformation("public void addStudent()");
		User user = new User(
				this.getFirstname(),
				this.getLastname(),
				this.getGender(),
				this.getEmail(),
				this.getServiceLevel());
		ZEnrollmentBean.getUserList().add(user);

	}

	public void delete() {
		this.setInformation("void delete()");
	}


	public void delete(User user) {

		this.setInformation("void delete(User user) vraiment");
		ZEnrollmentBean.getUserList().remove(user);


	}

	public String getAddress() {
		return address;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getGender() {
		return gender;
	}

	public int getId() {
		return id;
	}

	public String getInformation() {
		return information;
	}

	public String getLastname() {
		return lastname;
	}

	public String getServiceLevel() {
		return serviceLevel;
	}


	public List<User> getUserListDisplay() {
		return userListDisplay;
	}

	public void modify(User user) {
		this.setInformation("void modify()");

		this.setFirstname(user.getFirstname());
		this.setLastname(user.getLastname());
		this.setGender(String.format("%d", user.getGender()));

		
		this.setEmail(user.getEmail());
		
		this.setServiceLevel(String.format("%d",user.getServiceLevel()));
		this.setId(user.getServiceLevel());
		this.setBirthdate(user.getBirthDateText());

		this.setId(ZEnrollmentBean.getUserList().indexOf(user));
		this.setAddMode(true);


	}


	public void setAddress(String address) {
		this.address = address;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setId(int id) {
		this.id = id;
	}


	public void setInformation(String information) {
		this.information = information;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setServiceLevel(String serviceLevel) {
		this.serviceLevel = serviceLevel;
	}

	public  void setUserList(List<User> userList) {
		ZEnrollmentBean.userList = userList;
	}

	public void setUserListDisplay(List<User> userListDisplay) {
		this.userListDisplay = userListDisplay;
	}

	public void validateChange() {
		this.setInformation("modifyStudent");
		User user = new User(
				this.getFirstname(),
				this.getLastname(),
				this.getBirthdate(),
				this.getGender(),
				this.getEmail()
				);
		ZEnrollmentBean.getUserList().set(this.getId(),user);


	}

	public static List<User> getUserList() {
		return userList;
	}
	public static boolean isInstanced() {
		return isInstanced;
	}
	public static void setInstanced(boolean isInstanced) {
		ZEnrollmentBean.isInstanced = isInstanced;
	}
	public boolean isAddMode() {
		return addMode;
	}
	public boolean getAddMode() {
		return addMode;
	}
	public void setAddMode(boolean isAddMode) {
		this.addMode = isAddMode;
	}

}
