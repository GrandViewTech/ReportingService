package com.lidsys.application.common.integration.datasource.entity.bo.converters;

import javax.persistence.AttributeConverter;

import org.apache.commons.codec.binary.Base64;

public class EncryptedColumnConverter implements AttributeConverter<String, String>
	{
		
		@Override
		public String convertToDatabaseColumn(String attribute)
			{
				if (attribute != null && attribute.trim().length() > 0)
					{
						return Base64.encodeBase64String(attribute.getBytes());
					}
				return null;
			}
			
		@Override
		public String convertToEntityAttribute(String dbData)
			{
				if (dbData != null && dbData.trim().length() > 0)
					{
						return new String(Base64.decodeBase64(dbData.getBytes()));
					}
				return null;
			}
			
	}
