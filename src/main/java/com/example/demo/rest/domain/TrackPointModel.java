package com.example.demo.rest.domain;

import java.io.Serializable;

public class TrackPointModel implements Serializable {

	private static final long serialVersionUID = 5419041518744153676L;

	private Double lat;

	private Double lon;

	private Double ele;

	private String time;

	public TrackPointModel() {
	}

	public TrackPointModel(Double lat, Double lon, Double ele, String time) {
		super();
		this.lat = lat;
		this.lon = lon;
		this.ele = ele;
		this.time = time;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}

	public Double getEle() {
		return ele;
	}

	public void setEle(Double ele) {
		this.ele = ele;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private Double lat;
		private Double lon;
		private Double ele;
		private String time;

		public Builder lat(Double lat) {
			this.lat = lat;
			return this;
		}

		public Builder lon(Double lon) {
			this.lon = lon;
			return this;
		}

		public Builder ele(Double ele) {
			this.ele = ele;
			return this;
		}

		public Builder time(String time) {
			this.time = time;
			return this;
		}

		public TrackPointModel build() {
			TrackPointModel trackPointModel = new TrackPointModel();
			trackPointModel.lat = this.lat;
			trackPointModel.lon = this.lon;
			trackPointModel.ele = this.ele;
			trackPointModel.time = this.time;
			return trackPointModel;
		}
	}
}
