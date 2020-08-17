package com.example.demo.utils;

import static org.junit.Assert.assertThat;

import java.util.Date;

import org.hamcrest.Matchers;
import org.junit.Test;

import com.example.demo.service.utils.DateUtils;

public class DateUtilsTest {

	@Test
	public void toUtcDate_toUtcStringDate_shouldConvertFromStringToDateAndViceVersa_givenStringDate() throws Exception {
		Date date = DateUtils.toUtcDate("2017-10-22T10:41:33Z");
		assertThat(DateUtils.toUtcStringDate(date), Matchers.is("2017-10-22T10:41:33Z"));
	}
}
