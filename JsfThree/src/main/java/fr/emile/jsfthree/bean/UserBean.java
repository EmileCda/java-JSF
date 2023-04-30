package fr.emile.jsfthree.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import fr.emile.jsfthree.entity.User;
import fr.emile.jsfthree.model.dao.IUserDao;
import fr.emile.jsfthree.model.dao.UserDao;

@ManagedBean(name = "userBean")
public class UserBean {
	private String firstname;
	private String lastname;
	private String dateOfBirth;
	private String email;
	private String password;
	private String genderText;
	private String serviceLevel;
	private String addresstext;
	private String phoneText;
	private String currentPosition;
	private String available;
	public  String[] desiredLanguageList= {"PHP","C#","java","C/C++"};
	

	
	
	
	private static List<User> userList = new ArrayList<User>();
	
	static {
		
		userList.add(new User("ZZandrée", "deGaule", "femme", "17/11/1277", "andrée@ddeGaulee.fr", "Basic"));
		userList.add(new User("Paul", "Andrieux", "homme", "12/06/1965", "paul.andrieu@dommile.fr", "Medium"));
		userList.add(new User("Benoit", "Leclerc", "homme", "27/10/1977", "Benoit@dommile.fr", "Premium"));
		
	}
	
	
	public UserBean() {
		this("","","","","","","");
	}

	public UserBean(String firstname, String lastname, String dateOfBirth, String email, String password,
		String genderText, String serviceLevel) {

		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setDateOfBirth(dateOfBirth);
		this.setEmail(email);
		this.setPassword(password);
		this.setGenderText(genderText);
		this.setServiceLevel(serviceLevel);
		
		final IUserDao myUserDao = new UserDao();
		
		try {
//			List<User> userDbList  = new ArrayList<User>();
//			userDbList = myUserDao.get();
//			System.out.printf("userDbList.size : %d\n",userDbList.size());
//			
//			for (User user : userDbList) {
//				this.add(user);
//			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String[] getDesiredLanguageList() {
		return desiredLanguageList;
	}

	public void setDesiredLanguageList(String[] desiredLanguageList) {
		this.desiredLanguageList = desiredLanguageList;
	}



	
	public String createAccount() {

		
		User user = new User(this.getFirstname(), this.getLastname(), this.getGenderText(), this.getDateOfBirth(),
				this.getEmail(), this.getServiceLevel());
		this.add(user);
		System.out.printf("createAccount(User user) : %s :\n", user);
		System.out.printf("userList.size(): [%d]\n",userList.size());
		
		return "createAccount";
	}
	
	public String delete(User user) {

		System.out.printf("public String  delete(User user) : %s", user);

		this.getUserList().remove(user);
		return "delete";
	}
	
	public boolean add(User user) {
		System.out.printf("public boolean add(User user)\n");

		return this.getUserList().add(user);
	}

	
	public String getFirstname() {
		return this.firstname;
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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGenderText() {
		return genderText;
	}

	public void setGenderText(String genderText) {
		this.genderText = genderText;
	}

	public String getServiceLevel() {
		return serviceLevel;
	}

	public void setServiceLevel(String serviceLevel) {
		this.serviceLevel = serviceLevel;
	}

	public List<User> getUserList() {
		return UserBean.userList;
	}


	public String getAddresstext() {
		return addresstext;
	}

	public void setAddresstext(String addresstext) {
		this.addresstext = addresstext;
	}


	public String getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(String currentPosition) {
		this.currentPosition = currentPosition;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}



	public String getPhoneText() {
		return phoneText;
	}

	public void setPhoneText(String phoneText) {
		this.phoneText = phoneText;
	}	
	@Override
	public String toString() {
		return "UserBean [getFirstname()=" + getFirstname() + ", getLastname()=" + getLastname() + ", getDateOfBirth()="
				+ getDateOfBirth() + ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword()
				+ ", getGenderText()=" + getGenderText() + ", getServiceLevel()=" + getServiceLevel() + "]";
	}



}
