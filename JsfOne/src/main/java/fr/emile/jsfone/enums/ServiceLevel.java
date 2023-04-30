package fr.emile.jsfone.enums;

public enum ServiceLevel {
	
	BASIC("Basic"), MEDIUM("Medium"), PREMIUM("Premium");

	private String serviceLevel;

	private ServiceLevel(String serviceLevel) {
		this.serviceLevel = serviceLevel;
	}

	public String getValue() {
		return this.serviceLevel;
	}

	public static ServiceLevel fromString(String serviceLevel) {
		for (ServiceLevel myServiceLevel : ServiceLevel.values()) {
			if (myServiceLevel.serviceLevel.equalsIgnoreCase(serviceLevel)) {
				return myServiceLevel;
			}
		}
		return null;
	}

}
