package fr.emile.jsfsix.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.emile.jsfsix.common.IConstant;
import fr.emile.jsfsix.enums.DevLang;
import fr.emile.jsfsix.enums.Gender;
import fr.emile.jsfsix.enums.Position;
import fr.emile.jsfsix.enums.ServiceLevel;
import fr.emile.jsfsix.model.dao.IStudentDao;
import fr.emile.jsfsix.model.dao.StudentDao;
import fr.emile.jsfsix.utils.Utils;

public class Student extends Person implements IConstant {

	private ServiceLevel serviceLevel;
	private Position currentPosition;
	private boolean isAvailable;
	private Address address;
	
	private List<DevLang> desiredLanguageList;

	public Student(int id, String firstname, String lastname, Gender gender, Date birthdate, String email,
			ServiceLevel serviceLevel, String phone, Position currentPosition, String langList,boolean isAvailable) {

		super(id, firstname, lastname, gender, birthdate, email, phone);
		
		this.setServiceLevel(serviceLevel);
		this.setCurrentPosition(currentPosition);
		this.setAvailable(isAvailable);
		desiredLanguageList = new ArrayList<DevLang>();


		String tabLang[] = langList.split(FIELD_SEPARATOR);

		for (String langTxt : tabLang) {

			this.addLanguage(DevLang.fromString(langTxt));

		}
	
	}

		


	public Student() throws SQLException {

	}

	public Student(ResultSet resultSet) throws SQLException {

		this(resultSet.getInt("id"), resultSet.getString("firstname"), resultSet.getString("lastname"),
				Gender.fromString(resultSet.getString("gender")), Utils.toJavaDate(resultSet.getDate("birthdate")),
				resultSet.getString("email"), ServiceLevel.fromString(resultSet.getString("service_level")),
				resultSet.getString("phone"), Position.fromString(resultSet.getString("position")),
				resultSet.getString("lang_list"),resultSet.getBoolean("is_delete")

		);

	}

	public void update() {
		final IStudentDao myStudentDao = new StudentDao();
		try {
			myStudentDao.Update(this);
		} catch (Exception e) {
			System.out.println("'catch update");
			e.printStackTrace();
		}
	}

	public void remove() {
		final IStudentDao myStudentDao = new StudentDao();
		try {
			myStudentDao.delete(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void add() {
// call DAO in order to put into database
		final IStudentDao myStudentDao = new StudentDao();

		try {
			myStudentDao.add(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void addLanguage(DevLang lang) {
		this.getDesiredLanguageList().add(lang);
	}

	public ServiceLevel getServiceLevel() {
		return serviceLevel;
	}

	public void setServiceLevel(ServiceLevel serviceLevel) {
		this.serviceLevel = serviceLevel;
	}

	public Position getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(Position currentPosition) {
		this.currentPosition = currentPosition;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public List<DevLang> getDesiredLanguageList() {
		return desiredLanguageList;
	}

	public void setDesiredLanguageList(List<DevLang> desiredLanguageList) {
		this.desiredLanguageList = desiredLanguageList;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
