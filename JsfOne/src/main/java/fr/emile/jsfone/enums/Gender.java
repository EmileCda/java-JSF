package fr.emile.jsfone.enums;

public enum Gender {
	MALE("Homme"), FEMALE("Femme"), UNDEFINED("indéterminé");

	private String gender;

	private Gender(String gender) {
		this.gender = gender;
	}

	public String getValue() {
		return this.gender;
	}

	public static Gender fromString(String gender) {
		for (Gender myGender : Gender.values()) {
			if (myGender.gender.equalsIgnoreCase(gender)) {
				return myGender;
			}
		}
		return null;
	}
}
