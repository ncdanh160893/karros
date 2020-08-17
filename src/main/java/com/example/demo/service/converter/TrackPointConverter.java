package com.example.demo.service.converter;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;

import com.example.demo.repo.entity.TrackPoint;
import com.example.demo.rest.domain.TrackPointModel;
import com.example.demo.service.utils.DateUtils;
import com.example.demo.service.xml.domain.XmlTrkpt;

public class TrackPointConverter {

	public TrackPointConverter() {
	}

	private static TrackPoint fromXmlToEntity(XmlTrkpt xmlTrkpt) {
		return TrackPoint.builder().longitude(xmlTrkpt.getLon()).latitude(xmlTrkpt.getLat())
				.elevation(xmlTrkpt.getEle()).time(DateUtils.toUtcDate(xmlTrkpt.getTime())).build();
	}

	public static List<TrackPoint> fromXmlsToEntities(List<XmlTrkpt> xmlTrkpts) {
		if (CollectionUtils.isEmpty(xmlTrkpts)) {
			return Collections.emptyList();
		}
		return xmlTrkpts.stream().map(TrackPointConverter::fromXmlToEntity).collect(Collectors.toList());
	}

	private static TrackPointModel fromEntityToModel(TrackPoint trackPoint) {
		return TrackPointModel.builder().lat(trackPoint.getLatitude()).lon(trackPoint.getLongitude())
				.ele(trackPoint.getElevation()).time(DateUtils.toUtcStringDate(trackPoint.getTime())).build();
	}

	public static List<TrackPointModel> fromEntitiesToModels(List<TrackPoint> trackPoints) {
		if (CollectionUtils.isEmpty(trackPoints)) {
			return Collections.emptyList();
		}
		return trackPoints.stream().map(TrackPointConverter::fromEntityToModel).collect(Collectors.toList());
	}
}
