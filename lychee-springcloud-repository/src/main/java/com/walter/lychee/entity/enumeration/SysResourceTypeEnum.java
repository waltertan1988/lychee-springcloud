package com.walter.lychee.entity.enumeration;

public enum SysResourceTypeEnum {

	MENU("MENU"),
	ACTION("ACTION");
	
	private String code;
	
	SysResourceTypeEnum(String code){
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}

	@Override
	public String toString() {
		return code;
	}
}
