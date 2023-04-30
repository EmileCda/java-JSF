package fr.emile.jsfthree.enums;



public enum ServiceLevel {
	
	BASIC("Basic"), MEDIUM("Medium"), PREMIUM("premium"),NULL("") ;
	
	private String serviceLevel;
	
	private ServiceLevel(String value) {
		this.serviceLevel = value;
	}
	
	public String getValue() {
		return this.serviceLevel;
	}
	
	public static ServiceLevel fromString(String text) {
		for (ServiceLevel service : ServiceLevel.values()) {
			if (service.serviceLevel.equalsIgnoreCase(text)) {
				return service;
			}
		}
		return null;
	}


}
