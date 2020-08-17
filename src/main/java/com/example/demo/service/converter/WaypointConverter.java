package com.example.demo.service.converter;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;

import com.example.demo.repo.entity.Waypoint;
import com.example.demo.rest.domain.WaypointModel;
import com.example.demo.service.xml.domain.XmlWpt;

public class WaypointConverter {

	private WaypointConverter() {
	}

	private static Waypoint fromXmlToEntity(XmlWpt xmlWpt) {
		return Waypoint.builder().name(xmlWpt.getName()).sym(xmlWpt.getSym()).longitude(xmlWpt.getLon())
				.latitude(xmlWpt.getLat()).build();
	}

	public static List<Waypoint> fromXmlsToEntities(List<XmlWpt> xmlWpts) {
		if (CollectionUtils.isEmpty(xmlWpts)) {
			return Collections.emptyList();
		}

		return xmlWpts.stream().map(WaypointConverter::fromXmlToEntity).collect(Collectors.toList());
	}

	private static WaypointModel fromEntityToModel(Waypoint waypoint) {
		return WaypointModel.builder().lat(waypoint.getLatitude()).lon(waypoint.getLongitude()).name(waypoint.getName())
				.sym(waypoint.getSym()).build();
	}

	public static List<WaypointModel> fromEntitiesToModels(List<Waypoint> waypoints) {
		if (CollectionUtils.isEmpty(waypoints)) {
			return Collections.emptyList();
		}
		return waypoints.stream().map(WaypointConverter::fromEntityToModel).collect(Collectors.toList());
	}
}
