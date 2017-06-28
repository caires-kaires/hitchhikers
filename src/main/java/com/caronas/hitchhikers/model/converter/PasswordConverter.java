package com.caronas.hitchhikers.model.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.springframework.util.DigestUtils;

@Converter
public class PasswordConverter implements AttributeConverter<String, String> {

	public static String toMd5(String password) {
		return DigestUtils.md5DigestAsHex(password.getBytes());
	}

	@Override
	public String convertToDatabaseColumn(String password) {
		return PasswordConverter.toMd5(password);
	}

	@Override
	public String convertToEntityAttribute(String passwordDb) {
		return passwordDb;
	}

}
