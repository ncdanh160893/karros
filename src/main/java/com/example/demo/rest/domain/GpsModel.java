package com.example.demo.rest.domain;

import java.io.Serializable;

public class GpsModel implements Serializable {

	private static final long serialVersionUID = -8221477449279555804L;

	private Integer id;
	private String name;
	private String description;
	private String author;
	private String createdTime;

	private GpsModel() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
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
		private Integer id;
		private String name;
		private String description;
		private String author;
		private String createdTime;

		public Builder id(Integer id) {
			this.id = id;
			return this;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder description(String description) {
			this.description = description;
			return this;
		}

		public Builder author(String author) {
			this.author = author;
			return this;
		}

		public Builder createdTime(String createdTime) {
			this.createdTime = createdTime;
			return this;
		}

		public GpsModel build() {
			GpsModel gpsModel = new GpsModel();
			gpsModel.id = this.id;
			gpsModel.name = this.name;
			gpsModel.description = this.description;
			gpsModel.author = this.author;
			gpsModel.createdTime = this.createdTime;
			return gpsModel;
		}
	}
}
