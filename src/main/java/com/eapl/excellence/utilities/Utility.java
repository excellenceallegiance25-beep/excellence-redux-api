package com.eapl.excellence.utilities;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.stereotype.Component;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Component
public class Utility {

	private static final DateTimeFormatter INPUT_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	private static final DateTimeFormatter DB_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public String printJson(Object response) {
		ExclusionStrategy strategy = new ExclusionStrategy() {
			@Override
			public boolean shouldSkipField(FieldAttributes field) {
				return false;
			}

			@Override
			public boolean shouldSkipClass(Class<?> clazz) {
				return false;
			}
		};

		Gson gson = new GsonBuilder().addSerializationExclusionStrategy(strategy).setPrettyPrinting().create();

		return gson.toJson(response);

	}

	public String generateOTP() {
		SecureRandom random = new SecureRandom();
		int otp = 100000 + random.nextInt(900000);
		return String.valueOf(otp);
	}

	public String formatDate(String dateString) {
		if (dateString == null || dateString.trim().isEmpty()) {
			return null;
		}
		try {
			// Try to parse as dd-MM-yyyy
			LocalDate date = LocalDate.parse(dateString.trim(), INPUT_FORMATTER);
			return date.format(DB_FORMATTER); // Convert to yyyy-MM-dd
		} catch (DateTimeParseException e1) {
			try {
				// Try to parse as yyyy-MM-dd
				LocalDate date = LocalDate.parse(dateString.trim(), DB_FORMATTER);
				return date.format(DB_FORMATTER);
			} catch (DateTimeParseException e2) {
				// Return as-is, let PostgreSQL handle the error
				return dateString.trim();
			}
		}
	}

	public Integer parseLeaveId(Object leaveId) {
		if (leaveId == null) {
			return null;
		}
		try {
			if (leaveId instanceof Integer) {
				return (Integer) leaveId;
			} else if (leaveId instanceof String) {
				String str = ((String) leaveId).trim();
				if (str.isEmpty()) {
					return null;
				}
				return Integer.parseInt(str);
			} else if (leaveId instanceof Number) {
				return ((Number) leaveId).intValue();
			}
			return null;
		} catch (NumberFormatException e) {
			return null;
		}
	}

	public Object parseTotalDays(String totalDays) {
		if (totalDays == null || totalDays.trim().isEmpty()) {
			return null;
		}
		try {
			return Double.parseDouble(totalDays.trim());
		} catch (NumberFormatException e) {
			return totalDays.trim(); // Let PostgreSQL handle conversion error
		}
	}
}
