package com.lidsys.application.search.entity.bo.common.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class Boolean2StringColumnConverter implements AttributeConverter<Boolean, String>
	{
		
		@Override
		public String convertToDatabaseColumn(Boolean value)
			{
				return (value != null && value) ? "YES" : "NO";
			}
			
		@Override
		public Boolean convertToEntityAttribute(String value)
			{
				return "YES".equals(value);
			}
			
	}