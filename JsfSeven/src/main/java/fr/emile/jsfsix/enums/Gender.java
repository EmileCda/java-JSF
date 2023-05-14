package fr.emile.jsfsix.enums;



public enum Gender {
	
	MALE("Homme"), FEMALE("Femme"), AUTRE("other"),NULL("") ;
	
	private String stringValue;
	
	private Gender(String value) {
		this.stringValue = value;
	}
	
	public String getValue() {
		return this.stringValue;
	}
	
	public static Gender fromString(String text) {
		for (Gender oneValue : Gender.values()) {
			if (oneValue.stringValue.equalsIgnoreCase(text)) {
				return oneValue;
			}
		}
		return null;
	}


}
