package com.example.demo.rest.domain;

import java.io.Serializable;
import java.util.List;

public class GpsDetailModel implements Serializable {

	private static final long serialVersionUID = 450799823370024940L;

	private MetaDataModel metaData;
	private TrackModel track;
	private List<WaypointModel> waypoints;
	private String createdTime;

	private GpsDetailModel() {
	}

	public MetaDataModel getMetaData() {
		return metaData;
	}

	public void setMetaData(MetaDataModel metaData) {
		this.metaData = metaData;
	}

	public TrackModel getTrack() {
		return track;
	}

	public void setTrack(TrackModel track) {
		this.track = track;
	}

	public List<WaypointModel> getWaypoints() {
		return waypoints;
	}

	public void setWaypoints(List<WaypointModel> waypoints) {
		this.waypoints = waypoints;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private MetaDataModel metaData;
		private TrackModel track;
		private List<WaypointModel> waypoints;
		private String createdTime;

		public Builder metaData(MetaDataModel metaData) {
			this.metaData = metaData;
			return this;
		}

		public Builder track(TrackModel track) {
			this.track = track;
			return this;
		}

		public Builder waypoints(List<WaypointModel> waypoints) {
			this.waypoints = waypoints;
			return this;
		}

		public Builder createdTime(String createdTime) {
			this.createdTime = createdTime;
			return this;
		}

		public GpsDetailModel build() {
			GpsDetailModel gpsDetail = new GpsDetailModel();
			gpsDetail.metaData = this.metaData;
			gpsDetail.track = this.track;
			gpsDetail.waypoints = this.waypoints;
			gpsDetail.createdTime = this.createdTime;
			return gpsDetail;
		}
	}
}
