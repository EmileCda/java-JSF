package fr.emile.laze.test;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.emile.laze.common.IConstant;
import fr.emile.laze.utils.Utils;

public class DataTest implements IConstant {
	
	
	private static List<String> firstnameList ; 
	private static List<String> lastnameList ; 
	private static List<String> numberTypeList ; 
	private static List<String> streetNameList ; 
	private static List<String> cityList ; 
	private static List<String> zipcodeList ;

	
	
//---------------------------------------------------------------------------------------------------
	public static String firstName() {
		if (firstnameList == null) {
			firstnameList = new ArrayList<String>();

			ResourceBundle  myResource = ResourceBundle.getBundle("testData"); // retreive data from Dbase.properties
			String propertieValue = myResource.getString("FirstName");
			String propertieArray[]=propertieValue.split(";");
			
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

			ResourceBundle  myResource = ResourceBundle.getBundle("testData"); // retreive data from Dbase.properties
			String propertieValue = myResource.getString("LastName");
			String propertieArray[]=propertieValue.split(";");
			
			for (String value : propertieArray) {
				
				lastnameList.add(Utils.firstToUpper(value));
			}
		}
		int position = Utils.randInt(0, lastnameList.size() - 1);
		
		return lastnameList.get(position);
	}

//---------------------------------------------------------------------------------------------------
	public static String numberType() {
		if (numberTypeList == null) {
			numberTypeList = new ArrayList<String>();

			ResourceBundle  myResource = ResourceBundle.getBundle("testData"); // retreive data from Dbase.properties
			String propertieValue = myResource.getString("NumberType");
			String propertieArray[]=propertieValue.split(";");
			
			for (String value : propertieArray) {
				
				numberTypeList.add(Utils.firstToUpper(value));
			}
		}
		int position = Utils.randInt(0, numberTypeList.size() - 1);
		
		return numberTypeList.get(position);
	}

//---------------------------------------------------------------------------------------------------
	
	public static String streetNameList() {
		if (streetNameList == null) {
			streetNameList = new ArrayList<String>();

			ResourceBundle  myResource = ResourceBundle.getBundle("testData"); // retreive data from Dbase.properties
			String propertieValue = myResource.getString("StreetName");
			String propertieArray[]=propertieValue.split(";");
			
			for (String value : propertieArray) {
				
				streetNameList.add(Utils.firstToUpper(value));
			}
		}
		int position = Utils.randInt(0, streetNameList.size() - 1);
		
		return streetNameList.get(position);
	}

//---------------------------------------------------------------------------------------------------
	public static String city() {
		if (cityList == null) {
			cityList = new ArrayList<String>();

			ResourceBundle  myResource = ResourceBundle.getBundle("testData"); // retreive data from Dbase.properties
			String propertieValue = myResource.getString("CityName");
			String propertieArray[]=propertieValue.split(";");
			
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
	public static String number() {
		
		return String.format("%d %s", Utils.randInt(0,999),DataTest.numberType());
	}

//---------------------------------------------------------------------------------------------------
	
}
