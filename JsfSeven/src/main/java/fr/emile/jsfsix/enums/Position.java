package fr.emile.jsfsix.enums;

public enum Position {

	SERVICE_AGENT("Agent de service"), TECNICIAN("Technicien"), 
	CASHIER("Caissier"),UNEMPLOYED("au chômage"),OTHER("Autre") ,NULL("") ;
	
	private String position;
	
	
	private Position(String value) {
		this.position = value;
	}
	
	public String getValue() {
		return this.position;
	}
	
	public static Position fromString(String text) {
		for (Position onePosition : Position.values()) {
			if (onePosition.position.equalsIgnoreCase(text)) {
				return onePosition;
			}
		}
		return null;
	}

	
}


