package com.example.demo.service.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.util.Assert;

public class DateUtils {

	private static final String UTC_DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z'";

	private DateUtils() {
	}

	private static Date toDate(String dateString, String pattern) {
		final DateFormat format = new SimpleDateFormat(pattern);
		format.setLenient(false);
		Date date = null;
		Assert.hasText(dateString, "Date must not be empty");
		try {
			date = format.parse(dateString);
		} catch (ParseException ex) {
			throw new IllegalArgumentException("Wrong date format", ex);
		}
		return date;
	}

	public static Date toUtcDate(String dateString) {
		return toDate(dateString, UTC_DATE_PATTERN);
	}

	private static String toStringDate(final Date date, final String pattern) {
		Assert.notNull(date, "Date must not be null");
		Assert.hasText(pattern, "Pattern must be not empty");
		return new SimpleDateFormat(pattern).format(date);
	}

	public static String toUtcStringDate(final Date date) {
		return toStringDate(date, UTC_DATE_PATTERN);
	}
}
