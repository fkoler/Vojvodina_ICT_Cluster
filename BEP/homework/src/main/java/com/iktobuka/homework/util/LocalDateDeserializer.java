package com.iktobuka.homework.util;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class LocalDateDeserializer extends JsonDeserializer<LocalDate> {

	private static final DateTimeFormatter formatter = DateTimeFormatter
			.ofPattern("dd-MM-yyyy");

	@Override
	public LocalDate deserialize(
			JsonParser p, 
			DeserializationContext ctxt
		)
			throws IOException, JsonProcessingException {
		return LocalDate.parse(p.getValueAsString(), formatter);
	}
}
