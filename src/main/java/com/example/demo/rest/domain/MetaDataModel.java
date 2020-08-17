package com.example.demo.rest.domain;

import java.io.Serializable;

public class MetaDataModel implements Serializable {

	private static final long serialVersionUID = 2987277748914225924L;
	private String name;
	private String description;
	private String author;
	private String time;
	private LinkModel link;

	private MetaDataModel() {
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public LinkModel getLink() {
		return link;
	}

	public void setLink(LinkModel link) {
		this.link = link;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private String name;
		private String description;
		private String author;
		private String time;
		private LinkModel link;

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

		public Builder time(String time) {
			this.time = time;
			return this;
		}

		public Builder link(LinkModel link) {
			this.link = link;
			return this;
		}

		public MetaDataModel build() {
			MetaDataModel metaData = new MetaDataModel();
			metaData.name = this.name;
			metaData.description = this.description;
			metaData.author = this.author;
			metaData.time = this.time;
			metaData.link = this.link;
			return metaData;
		}
	}

	private MetaDataModel(Builder builder) {
		this.name = builder.name;
		this.description = builder.description;
		this.author = builder.author;
		this.time = builder.time;
		this.link = builder.link;
	}
}
