package fr.emile.fabricdos.common;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import fr.emile.fabricdos.entity.Employee;
import fr.emile.fabricdos.enums.Gender;

public class DataTest implements IConstant {

	private static List<String> firstnameList;
	private static List<String> lastnameList;
	private static List<String> numberTypeList;
	private static List<String> streetNameList;
	private static List<String> cityList;
	private static List<String> streetTypeList;
	private static List<String> domainList;
	private static List<String> domainExtensionList;
	private static List<String> specialiteList;
	private static List<String> positionList;

	// ---------------------------------------------------------------------------------------------------
	public static Employee genEmployee() {

		String firstName = DataTest.firstname();
		String lastname = DataTest.lastname();

		return new Employee(firstName, lastname, DataTest.position(), DataTest.email(firstName, lastname));

	}
//	// ---------------------------------------------------------------------------------------------------

	//// ---------------------------------------------------------------------------------------------------
	public static String email(String firstname, String lastname) {

		return Utils.stripAccent(String.format("%s.%s@%s.%s", firstname.toLowerCase(), lastname.toLowerCase(),
				DataTest.domain(), DataTest.domainExtension()));

	}

//	// ---------------------------------------------------------------------------------------------------
//	public static Student genStudent() {
//
//		String firstName = DataTest.firstname();
//		String lastname = DataTest.lastname(); 
//		
//		return new Student(firstName, lastname,DataTest.email(firstName,lastname),				
//				Utils.randInt(10, 50), DataTest.specialite());
//
//	}
//	// ---------------------------------------------------------------------------------------------------
//		public static User genUser() {
//
//			Date startDate = Utils.string2Date("01/01/1900", "dd/MM/yyyy");
//			Date endDate = Utils.string2Date("01/01/2023", "dd/MM/yyyy");
////				
//			Gender gender = DataTest.gender();
//			String firstname = DataTest.firstname(gender);
//			String lastname = DataTest.lastname();
//
//			return new User(gender, firstname, lastname, DataTest.date(startDate, endDate),
//					DataTest.email(firstname, lastname));
//		}
//
//	//---------------------------------------------------------------------------------------------------
//		public static Address genAddress() {
//
//			return new Address(DataTest.number(), DataTest.numberType(), DataTest.streetType(), DataTest.street(),
//					DataTest.city(), DataTest.zipcode());
//		}
//

	// ---------------------------------------------------------------------------------------------------
	public static String position() {
		if (positionList == null) {
			positionList = new ArrayList<String>();

			ResourceBundle myResource = ResourceBundle.getBundle("testData"); // retreive data from Dbase.properties
			String propertieValue = myResource.getString("position");
			String propertieArray[] = propertieValue.split(";");
			for (String value : propertieArray) {

				positionList.add(value.toLowerCase());
			}
		}
		int position = Utils.randInt(0, positionList.size() - 1);

		return Utils.stripAccent(positionList.get(position));
	}

	// ---------------------------------------------------------------------------------------------------
	public static String specialite() {
		if (specialiteList == null) {
			specialiteList = new ArrayList<String>();

			ResourceBundle myResource = ResourceBundle.getBundle("testData"); // retreive data from Dbase.properties
			String propertieValue = myResource.getString("specialite");
			String propertieArray[] = propertieValue.split(";");

			for (String value : propertieArray) {

				specialiteList.add(value.toLowerCase());
			}
		}
		int position = Utils.randInt(0, specialiteList.size() - 1);

		return Utils.stripAccent(specialiteList.get(position));
	}

	// ---------------------------------------------------------------------------------------------------

//---------------------------------------------------------------------------------------------------
	public static String firstname() {

		return DataTest.firstname(Gender.OTHERS);

	}

// ---------------------------------------------------------------------------------------------------
	public static String domainExtension() {
		if (domainExtensionList == null) {
			domainExtensionList = new ArrayList<String>();

			ResourceBundle myResource = ResourceBundle.getBundle("testData"); // retreive data from Dbase.properties
			String propertieValue = myResource.getString("domain.extension");
			String propertieArray[] = propertieValue.split(";");

			for (String value : propertieArray) {

				domainExtensionList.add(value.toLowerCase());
			}
		}
		int position = Utils.randInt(0, domainExtensionList.size() - 1);

		return Utils.stripAccent(domainExtensionList.get(position));

	}

// ---------------------------------------------------------------------------------------------------
	public static String domain() {
		if (domainList == null) {
			domainList = new ArrayList<String>();

			ResourceBundle myResource = ResourceBundle.getBundle("testData"); // retreive data from Dbase.properties
			String propertieValue = myResource.getString("domain");
			String propertieArray[] = propertieValue.split(";");

			for (String value : propertieArray) {

				domainList.add(value.toLowerCase());
			}
		}
		int position = Utils.randInt(0, domainList.size() - 1);

		return Utils.stripAccent(domainList.get(position));

	}

	// ---------------------------------------------------------------------------------------------------
	public static String firstname(Gender gender) {

//		Utils.trace(gender.getValue());
		if (firstnameList == null) {
			firstnameList = new ArrayList<String>();

			ResourceBundle myResource = ResourceBundle.getBundle("testData"); // retreive data from Dbase.properties
			String propertieValue = myResource.getString("FirstName." + gender.getValue());
			String propertieArray[] = propertieValue.split(";");

			for (String value : propertieArray) {

				firstnameList.add(Utils.firstToUpper(value));
			}
		}
		int position = Utils.randInt(0, firstnameList.size() - 1);

		return firstnameList.get(position);
	}

//---------------------------------------------------------------------------------------------------
	public static String lastname() {
		if (lastnameList == null) {
			lastnameList = new ArrayList<String>();

			ResourceBundle myResource = ResourceBundle.getBundle("testData"); // retreive data from Dbase.properties
			String propertieValue = myResource.getString("LastName");
			String propertieArray[] = propertieValue.split(";");

			for (String value : propertieArray) {

				lastnameList.add(Utils.firstToUpper(value));
			}
		}
		int position = Utils.randInt(0, lastnameList.size() - 1);

		return lastnameList.get(position);
	}

//---------------------------------------------------------------------------------------------------
	public static String numberType() {

		Utils.trace("numberType");
		if (numberTypeList == null) {
			numberTypeList = new ArrayList<String>();

			ResourceBundle myResource = ResourceBundle.getBundle("testData"); // retreive data from Dbase.properties
			String propertieValue = myResource.getString("NumberType");
			Utils.trace(propertieValue);
			String propertieArray[] = propertieValue.split(";");
			for (String value : propertieArray) {

				numberTypeList.add(value);
			}
		}
		int position = Utils.randInt(0, numberTypeList.size() - 1);
		Utils.trace(String.format("%d %d", position, numberTypeList.size()));
		Utils.trace(numberTypeList.get(position));

		return numberTypeList.get(position);
	}

	// ---------------------------------------------------------------------------------------------------

	public static String street() {
		if (streetNameList == null) {
			streetNameList = new ArrayList<String>();

			ResourceBundle myResource = ResourceBundle.getBundle("testData"); // retreive data from Dbase.properties
			String propertieValue = myResource.getString("StreetName");
			String propertieArray[] = propertieValue.split(";");

			for (String value : propertieArray) {

				streetNameList.add(Utils.firstToUpper(value));
			}
		}
		int position = Utils.randInt(0, streetNameList.size() - 1);

		return streetNameList.get(position);
	}

	// ---------------------------------------------------------------------------------------------------

	public static String streetType() {
		if (streetTypeList == null) {
			streetTypeList = new ArrayList<String>();

			ResourceBundle myResource = ResourceBundle.getBundle("testData"); // retreive data from Dbase.properties
			String propertieValue = myResource.getString("StreetType");
			String propertieArray[] = propertieValue.split(";");

			for (String value : propertieArray) {

				streetTypeList.add(Utils.firstToUpper(value));
			}
		}
		int position = Utils.randInt(0, streetTypeList.size() - 1);

		return streetTypeList.get(position);
	}

//---------------------------------------------------------------------------------------------------
	public static String city() {
		if (cityList == null) {
			cityList = new ArrayList<String>();

			ResourceBundle myResource = ResourceBundle.getBundle("testData"); // retreive data from Dbase.properties
			String propertieValue = myResource.getString("CityName");
			String propertieArray[] = propertieValue.split(";");

			for (String value : propertieArray) {

				cityList.add(Utils.firstToUpper(value));
			}
		}
		int position = Utils.randInt(0, cityList.size() - 1);

		return cityList.get(position);
	}

//---------------------------------------------------------------------------------------------------

	public static String zipcode() {

		return String.format("%05d", Utils.randInt(1000, 99999));
	}

//---------------------------------------------------------------------------------------------------
	public static Integer number() {
		return Utils.randInt(1, 999);
	}

//---------------------------------------------------------------------------------------------------
	public static String numberString() {

		String numberType = DataTest.numberType();

		if (numberType.equals("")) {
			return String.format("%d", Utils.randInt(0, 999));
		}

		return String.format("%d %s", Utils.randInt(0, 999), numberType);
	}

	// ---------------------------------------------------------------------------------------------------
	public static Date date(Date lowerDate, Date upperDate) {

		Date randomDate = null;
		LocalDate localDate = null;

		LocalDate loDate = Utils.date2localDate(lowerDate);
		LocalDate upDate = Utils.date2localDate(upperDate);
		long periode = loDate.until(upDate, ChronoUnit.DAYS);
		int nbDays = Utils.randInt(0, (int) periode);
		localDate = loDate.plusDays(nbDays);

		return Utils.localDate2Date(localDate);
	}

	// ---------------------------------------------------------------------------------------------------
	public static Gender gender() {

		Gender[] genderTab = Gender.values();

		int genderSize = Gender.values().length;

		int genderRandom = Utils.randInt(0, genderSize - 2); // do not user last value : Null

		return genderTab[genderRandom];
	}

	// ---------------------------------------------------------------------------------------------------
	public static LocalDate localDate(LocalDate lowerDate, LocalDate upperDate) {
//			Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		long periode = lowerDate.until(upperDate, ChronoUnit.DAYS);

		int nbDays = Utils.randInt(0, (int) periode);

		Utils.trace(String.format("%s %s %d %d", upperDate.toString(), lowerDate.toString(), periode, nbDays));

		return lowerDate.plusDays(nbDays);
	}

//---------------------------------------------------------------------------------------------------

}
