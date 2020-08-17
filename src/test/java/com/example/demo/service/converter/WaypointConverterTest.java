package com.example.demo.service.converter;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.hamcrest.Matchers;
import org.junit.Test;

import com.example.demo.repo.entity.Waypoint;
import com.example.demo.rest.domain.WaypointModel;
import com.example.demo.service.xml.domain.XmlWpt;

public class WaypointConverterTest {

	@Test
	public void fromXmlToEntities_shouldReturnEmpyListEntities_givenNull() throws Exception {
		List<Waypoint> waypoints = WaypointConverter.fromXmlsToEntities(null);
		assertTrue(CollectionUtils.isEmpty(waypoints));
	}

	@Test
	public void fromXmlToEntities_shouldReturnEmpyListEntities_givenEmptyListXmlObjects() throws Exception {
		List<Waypoint> waypoints = WaypointConverter.fromXmlsToEntities(Collections.emptyList());
		assertTrue(CollectionUtils.isEmpty(waypoints));
	}

	@Test
	public void fromXmlsToEntities_shouldConvertToEntities_givenXmls() throws Exception {
		XmlWpt xmlWpt1 = new XmlWpt();
		xmlWpt1.setLat(42.2205377);
		xmlWpt1.setLon(-1.4564538);
		xmlWpt1.setName("Sorteamos por arriba");
		xmlWpt1.setSym("/static/wpt/Waypoint");

		XmlWpt xmlWpt2 = new XmlWpt();
		xmlWpt2.setLat(42.2208346);
		xmlWpt2.setLon(-1.4544232);
		xmlWpt2.setName("Senda");
		xmlWpt2.setSym("/static/wpt/Waypoint");

		List<Waypoint> waypoints = WaypointConverter.fromXmlsToEntities(Arrays.asList(xmlWpt1, xmlWpt2));
		assertThat(waypoints.size(), Matchers.is(2));

		Waypoint waypoint1 = waypoints.get(0);
		assertThat(waypoint1.getLatitude(), Matchers.is(xmlWpt1.getLat()));
		assertThat(waypoint1.getLongitude(), Matchers.is(xmlWpt1.getLon()));
		assertThat(waypoint1.getName(), Matchers.is(xmlWpt1.getName()));
		assertThat(waypoint1.getSym(), Matchers.is(xmlWpt1.getSym()));

		Waypoint waypoint2 = waypoints.get(1);
		assertThat(waypoint2.getLatitude(), Matchers.is(xmlWpt2.getLat()));
		assertThat(waypoint2.getLongitude(), Matchers.is(xmlWpt2.getLon()));
		assertThat(waypoint2.getName(), Matchers.is(xmlWpt2.getName()));
		assertThat(waypoint2.getSym(), Matchers.is(xmlWpt2.getSym()));
	}

	@Test
	public void fromEntitiesToModels_shouldConvertToModels_givenEntities() throws Exception {
		Waypoint waypoint1 = Waypoint.builder().latitude(42.2205377).longitude(-1.4564538).name("Sorteamos por arriba")
				.sym("/static/wpt/Waypoint").build();
		List<WaypointModel> waypointModels = WaypointConverter.fromEntitiesToModels(Arrays.asList(waypoint1));

		assertThat(waypointModels.size(), Matchers.is(1));
		WaypointModel waypointModel1 = waypointModels.get(0);
		assertThat(waypointModel1.getLat(), Matchers.is(waypoint1.getLatitude()));
		assertThat(waypointModel1.getLon(), Matchers.is(waypoint1.getLongitude()));
		assertThat(waypointModel1.getName(), Matchers.is(waypoint1.getName()));
		assertThat(waypointModel1.getSym(), Matchers.is(waypoint1.getSym()));
	}
}
