package com.example.demo.service.converter;

import com.example.demo.repo.entity.Track;
import com.example.demo.rest.domain.TrackModel;

public class TrackConverter {

	private TrackConverter() {
	}

	public static TrackModel fromEntityToModel(Track track) {
		return TrackModel.builder().name(track.getName())
				.trackPoints(TrackPointConverter.fromEntitiesToModels(track.getTrackPoints())).build();
	}
}
