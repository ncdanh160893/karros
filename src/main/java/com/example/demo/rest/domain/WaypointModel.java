package com.example.demo.rest.domain;

import java.io.Serializable;

public class WaypointModel implements Serializable {

	private static final long serialVersionUID = 3854674724805540502L;

	private Double lat;

	private Double lon;

	private String name;

	private String sym;

	public WaypointModel() {
	}

	public WaypointModel(Double lat, Double lon, String name, String sym) {
		super();
		this.lat = lat;
		this.lon = lon;
		this.name = name;
		this.sym = sym;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSym() {
		return sym;
	}

	public void setSym(String sym) {
		this.sym = sym;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private Double lat;
		private Double lon;
		private String name;
		private String sym;

		public Builder lat(Double lat) {
			this.lat = lat;
			return this;
		}

		public Builder lon(Double lon) {
			this.lon = lon;
			return this;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder sym(String sym) {
			this.sym = sym;
			return this;
		}

		public WaypointModel build() {
			WaypointModel waypointModel = new WaypointModel();
			waypointModel.lat = this.lat;
			waypointModel.lon = this.lon;
			waypointModel.name = this.name;
			waypointModel.sym = this.sym;
			return waypointModel;
		}
	}
}
