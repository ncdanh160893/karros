package com.example.demo.repo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TRACK")
public class Track {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	@OneToMany(mappedBy = "track")
	private List<TrackPoint> trackPoints;

	private Track() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TrackPoint> getTrackPoints() {
		return trackPoints;
	}

	public void setTrackPoints(List<TrackPoint> trackPoints) {
		this.trackPoints = trackPoints;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private String name;
		private List<TrackPoint> trackPoints;

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder trackPoints(List<TrackPoint> trackPoints) {
			this.trackPoints = trackPoints;
			return this;
		}

		public Track build() {
			Track track = new Track();
			track.name = this.name;
			track.trackPoints = this.trackPoints;
			return track;
		}
	}
}
