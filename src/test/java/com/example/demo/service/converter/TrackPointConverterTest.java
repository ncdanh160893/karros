package com.example.demo.service.converter;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.hamcrest.Matchers;
import org.junit.Test;

import com.example.demo.repo.entity.TrackPoint;
import com.example.demo.rest.domain.TrackPointModel;
import com.example.demo.service.utils.DateUtils;
import com.example.demo.service.xml.domain.XmlTrkpt;

public class TrackPointConverterTest {

	@Test
	public void fromXmlsToEntities_shouldReturnEmpyListEntities_givenNull() throws Exception {
		List<TrackPoint> trackPoints = TrackPointConverter.fromXmlsToEntities(null);
		assertTrue(CollectionUtils.isEmpty(trackPoints));
	}

	@Test
	public void fromXmlsToEntities_shouldReturnEmpyListEntities_givenEmptyListXmlObjects() throws Exception {
		List<TrackPoint> trackPoints = TrackPointConverter.fromXmlsToEntities(Collections.emptyList());
		assertTrue(CollectionUtils.isEmpty(trackPoints));
	}

	@Test
	public void fromXmlsToEntities_shouldConvertFromXmlTrackPointsToEntitites() throws Exception {
		XmlTrkpt xmlTrkpt1 = new XmlTrkpt();
		xmlTrkpt1.setLat(42.220683708460996);
		xmlTrkpt1.setLon(-1.4582070708274841);
		xmlTrkpt1.setEle(316.12912000000006);
		xmlTrkpt1.setTime("2017-10-22T09:43:38Z");

		XmlTrkpt xmlTrkpt2 = new XmlTrkpt();
		xmlTrkpt2.setLat(42.22059829568746);
		xmlTrkpt2.setLon(-1.4582258462905884);
		xmlTrkpt2.setEle(316.08144000000004);
		xmlTrkpt2.setTime("2017-10-22T09:43:46Z");

		List<TrackPoint> trackPoints = TrackPointConverter.fromXmlsToEntities(Arrays.asList(xmlTrkpt1, xmlTrkpt2));
		assertThat(trackPoints.size(), Matchers.is(2));

		TrackPoint trackPoint1 = trackPoints.get(0);
		assertThat(trackPoint1.getLatitude(), Matchers.is(xmlTrkpt1.getLat()));
		assertThat(trackPoint1.getLongitude(), Matchers.is(xmlTrkpt1.getLon()));
		assertThat(trackPoint1.getElevation(), Matchers.is(xmlTrkpt1.getEle()));
		assertThat(DateUtils.toUtcStringDate(trackPoint1.getTime()), Matchers.is(xmlTrkpt1.getTime()));

		TrackPoint trackPoint2 = trackPoints.get(1);
		assertThat(trackPoint2.getLatitude(), Matchers.is(xmlTrkpt2.getLat()));
		assertThat(trackPoint2.getLongitude(), Matchers.is(xmlTrkpt2.getLon()));
		assertThat(trackPoint2.getElevation(), Matchers.is(xmlTrkpt2.getEle()));
		assertThat(DateUtils.toUtcStringDate(trackPoint2.getTime()), Matchers.is(xmlTrkpt2.getTime()));
	}

	@Test
	public void fromEntitiesToModels_shouldConvertToModels_givenEntities() throws Exception {
		TrackPoint trackPoint1 = TrackPoint.builder().latitude(42.220683708460996).longitude(-1.4582070708274841)
				.elevation(316.12912000000006).time(DateUtils.toUtcDate("2017-10-22T09:43:38Z")).build();

		TrackPoint trackPoint2 = TrackPoint.builder().latitude(42.22059829568746).longitude(-1.4582258462905884)
				.elevation(316.08144000000004).time(DateUtils.toUtcDate("2017-10-22T09:43:46Z")).build();

		List<TrackPointModel> trackPointModels = TrackPointConverter
				.fromEntitiesToModels(Arrays.asList(trackPoint1, trackPoint2));

		TrackPointModel trackPointModel1 = trackPointModels.get(0);
		assertThat(trackPointModel1.getLat(), Matchers.is(trackPoint1.getLatitude()));
		assertThat(trackPointModel1.getLon(), Matchers.is(trackPoint1.getLongitude()));
		assertThat(trackPointModel1.getEle(), Matchers.is(trackPoint1.getElevation()));
		assertThat(trackPointModel1.getTime(), Matchers.is(DateUtils.toUtcStringDate(trackPoint1.getTime())));

		TrackPointModel trackPointModel2 = trackPointModels.get(1);
		assertThat(trackPointModel2.getLat(), Matchers.is(trackPoint2.getLatitude()));
		assertThat(trackPointModel2.getLon(), Matchers.is(trackPoint2.getLongitude()));
		assertThat(trackPointModel2.getEle(), Matchers.is(trackPoint2.getElevation()));
		assertThat(trackPointModel2.getTime(), Matchers.is(DateUtils.toUtcStringDate(trackPoint2.getTime())));
	}
}
