package com.example.demo.repo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "WAYPOINT")
public class Waypoint {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Double latitude;
	private Double longitude;
	private String name;
	private String sym;

	private Waypoint() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getName() {
		return name;
	}

	public String getSym() {
		return sym;
	}

	@ManyToOne
	@JoinColumn(name = "GPS_ID")
	private Gps gps;

	public void setGps(Gps gps) {
		this.gps = gps;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private Integer id;
		private Double latitude;
		private Double longitude;
		private String name;
		private String sym;
		private Gps gps;

		public Builder id(Integer id) {
			this.id = id;
			return this;
		}

		public Builder latitude(Double latitude) {
			this.latitude = latitude;
			return this;
		}

		public Builder longitude(Double longitude) {
			this.longitude = longitude;
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

		public Builder gps(Gps gps) {
			this.gps = gps;
			return this;
		}

		public Waypoint build() {
			Waypoint waypoint = new Waypoint();
			waypoint.id = this.id;
			waypoint.longitude = this.longitude;
			waypoint.latitude = this.latitude;
			waypoint.name = this.name;
			waypoint.sym = this.sym;
			waypoint.gps = this.gps;
			return waypoint;
		}
	}
}
