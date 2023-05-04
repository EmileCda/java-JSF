package fr.emile.jsfsix.enums;

import java.util.ArrayList;
import java.util.List;

public enum DevLang {
	
	JAVA("java"), PHP("php"), CSHARP("C#"),OTHER("autre") ,NULL("") ;
	
	private String stringValue;
	
	private DevLang(String value) {
		this.stringValue = value;
	}
	
	public String getValue() {
		return this.stringValue;
	}
	
	public static DevLang fromString(String text) {
		for (DevLang oneValue : DevLang.values()) {
			if (oneValue.stringValue.equalsIgnoreCase(text)) {
				return oneValue;
			}
		}
		return null;
	}

	
	
	public static String Lang2String (DevLang[] tabLang) {

		String stringReturn = ""; 
		for (DevLang devLang : tabLang) {
			stringReturn+=devLang.getValue() + ";";
		}
		return stringReturn ; 
		
	}
	
	public static String Lang2String (List<DevLang> langList) {
		String stringReturn = ""; 
		for (DevLang devLang : langList) {
			stringReturn+=devLang.getValue() + ";";
		}
		return stringReturn ; 
		
	}

	public static DevLang[] string2Array (String langList) {
		String lang[]=langList.split(";");
		DevLang langReturn[] = new DevLang[lang.length]; 
		int index = 0 ; 
		for (String oneLang : lang) {
			
			langReturn[index] = DevLang.fromString(oneLang) ;
			index++;
		}
		
		return langReturn ; 
	}

	public static List<DevLang> string2List (String langList) {
		String lang[]=langList.split(";");
		List<DevLang> listReturn = new ArrayList<DevLang>();
		
		for (String oneLang : lang) {
			
			listReturn.add(DevLang.fromString(oneLang) );
		}
		
		return listReturn ; 
	}
	
	public static List<DevLang> array2List (String[] langTab) {
		List<DevLang> listReturn = new ArrayList<DevLang>();
		for (String oneLang : langTab) {
			
			listReturn.add(DevLang.fromString(oneLang) );
		}
		return listReturn ; 
	}
	
	public static String[] list2array (List<DevLang> langList) {
		
		String langReturn[] = new String[langList.size()]; 
		int index = 0 ;
		for (DevLang devLang : langList) {
			langReturn[index] = devLang.getValue();
			index++;
		}
		return langReturn ; 
		
	}

	public static List<DevLang> stringList2LangList (List<String> langList) {
		List<DevLang> listReturn = new ArrayList<DevLang>();
		for (String devLang : langList) {
			listReturn.add(DevLang.fromString(devLang) );
		}
		return listReturn ; 
		
	}
	
}
