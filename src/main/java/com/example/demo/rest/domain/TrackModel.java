package com.example.demo.rest.domain;

import java.io.Serializable;
import java.util.List;

public class TrackModel implements Serializable {

	private static final long serialVersionUID = -8543644360929365300L;

	private String name;
	private List<TrackPointModel> trackPoints;

	private TrackModel() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TrackPointModel> getTrackPoints() {
		return trackPoints;
	}

	public void setTrackPoints(List<TrackPointModel> trackPoints) {
		this.trackPoints = trackPoints;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private String name;
		private List<TrackPointModel> trackPoints;

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder trackPoints(List<TrackPointModel> trackPoints) {
			this.trackPoints = trackPoints;
			return this;
		}

		public TrackModel build() {
			TrackModel trackModel = new TrackModel();
			trackModel.name = this.name;
			trackModel.trackPoints = this.trackPoints;
			return trackModel;
		}
	}
}
