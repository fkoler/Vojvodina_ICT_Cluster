package com.iktobuka.homework.util;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class LocalDateSerializer extends JsonSerializer<LocalDate> {

	private static final DateTimeFormatter formatter = DateTimeFormatter
			.ofPattern("dd-MM-yyyy");

	@Override
	public void serialize(
			LocalDate value, 
			JsonGenerator gen, 
			SerializerProvider serializers
		) throws IOException {
		gen.writeString(value.format(formatter));
	}
}
