package com.example.demo.repo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "META_DATA")
public class MetaData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	@Column(columnDefinition = "NVARCHAR")
	private String description;

	private String author;

	private Date time;

	@OneToOne
	@JoinColumn(name = "LINK_ID")
	private Link link;

	private MetaData() {
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

	public Link getLink() {
		return link;
	}

	public void setLink(Link link) {
		this.link = link;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private Integer id;
		private String name;
		private String description;
		private String author;
		private Date time;
		private Link link;

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

		public Builder time(Date time) {
			this.time = time;
			return this;
		}

		public Builder link(Link link) {
			this.link = link;
			return this;
		}

		public MetaData build() {
			MetaData metaData = new MetaData();
			metaData.id = this.id;
			metaData.name = this.name;
			metaData.description = this.description;
			metaData.author = this.author;
			metaData.time = this.time;
			metaData.link = this.link;
			return metaData;
		}
	}
}
