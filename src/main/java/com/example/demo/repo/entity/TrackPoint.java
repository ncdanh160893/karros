package com.example.demo.repo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TRACK_POINT")
public class TrackPoint {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Double latitude;
	private Double longitude;
	private Double elevation;
	private Date time;

	private TrackPoint() {
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

	public Double getElevation() {
		return elevation;
	}

	public Date getTime() {
		return time;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

	@ManyToOne
	@JoinColumn(name = "TRACK_ID")
	private Track track;

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private Integer id;
		private Double latitude;
		private Double longitude;
		private Double elevation;
		private Date time;
		private Track track;

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

		public Builder elevation(Double elevation) {
			this.elevation = elevation;
			return this;
		}

		public Builder time(Date time) {
			this.time = time;
			return this;
		}

		public Builder track(Track track) {
			this.track = track;
			return this;
		}

		public TrackPoint build() {
			TrackPoint trackPoint = new TrackPoint();
			trackPoint.id = this.id;
			trackPoint.longitude = this.longitude;
			trackPoint.latitude = this.latitude;
			trackPoint.elevation = this.elevation;
			trackPoint.time = this.time;
			trackPoint.track = this.track;
			return trackPoint;
		}
	}
}
