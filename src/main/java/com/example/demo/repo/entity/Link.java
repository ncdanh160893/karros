package com.example.demo.repo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LINK")
public class Link {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String href;
	private String text;

	private Link() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHref() {
		return href;
	}

	public String getText() {
		return text;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private Integer id;
		private String href;
		private String text;

		public Builder id(Integer id) {
			this.id = id;
			return this;
		}

		public Builder href(String href) {
			this.href = href;
			return this;
		}

		public Builder text(String text) {
			this.text = text;
			return this;
		}

		public Link build() {
			Link link = new Link();
			link.id = this.id;
			link.href = this.href;
			link.text = this.text;
			return link;
		}
	}
}
