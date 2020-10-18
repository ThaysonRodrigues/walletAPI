package com.wallet.enums;

public enum TypeEnum {

	EN("ENTRADA"),
	SD("SAIDA");
	
	private final String value;
	
	TypeEnum(String value){
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public static TypeEnum getEnum(String value) {
		for(TypeEnum t : values()) {
			if(value.equals(t.getValue())) {
				return t;
			}
		}
		
		return null;
	}
	
}
