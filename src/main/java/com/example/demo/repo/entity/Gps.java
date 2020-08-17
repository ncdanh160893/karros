package com.example.demo.repo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "GPS")
public class Gps {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne
	@JoinColumn(name = "META_DATA_ID")
	private MetaData metaData;

	@OneToMany(mappedBy = "gps")
	private List<Waypoint> waypoints;

	@OneToOne
	@JoinColumn(name = "TRACK_ID")
	private Track track;

	private Date createdTime;

	private Gps() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public MetaData getMetaData() {
		return metaData;
	}

	public void setMetaData(MetaData metaData) {
		this.metaData = metaData;
	}

	public List<Waypoint> getWaypoints() {
		return waypoints;
	}

	public void setWaypoints(List<Waypoint> waypoints) {
		this.waypoints = waypoints;
	}

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private int id;
		private MetaData metaData;
		private List<Waypoint> waypoints;
		private Track track;
		private Date createdTime;

		public Builder id(int id) {
			this.id = id;
			return this;
		}

		public Builder metaData(MetaData metaData) {
			this.metaData = metaData;
			return this;
		}

		public Builder waypoints(List<Waypoint> waypoints) {
			this.waypoints = waypoints;
			return this;
		}

		public Builder tracks(Track track) {
			this.track = track;
			return this;
		}

		public Builder createdTime(Date createdTime) {
			this.createdTime = createdTime;
			return this;
		}

		public Gps build() {
			Gps gps = new Gps();
			gps.id = this.id;
			gps.metaData = this.metaData;
			gps.waypoints = this.waypoints;
			gps.track = this.track;
			gps.createdTime = this.createdTime;
			return gps;
		}
	}

}
