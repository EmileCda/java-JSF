package fr.emile.jsfsix.enums;



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


}
