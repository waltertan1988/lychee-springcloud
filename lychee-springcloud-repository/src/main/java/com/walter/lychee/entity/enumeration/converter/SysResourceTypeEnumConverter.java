package com.walter.lychee.entity.enumeration.converter;

import javax.persistence.AttributeConverter;

import com.walter.lychee.entity.enumeration.SysResourceTypeEnum;

public class SysResourceTypeEnumConverter implements AttributeConverter<SysResourceTypeEnum, String> {

	@Override
	public String convertToDatabaseColumn(SysResourceTypeEnum sysResourceTypeEnum) {
		return sysResourceTypeEnum.getCode();
	}

	@Override
	public SysResourceTypeEnum convertToEntityAttribute(String sysResourceType) {
		return SysResourceTypeEnum.valueOf(sysResourceType);
	}
}
