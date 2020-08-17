package com.example.demo.rest.domain;

import java.io.Serializable;

public class LinkModel implements Serializable {

	private static final long serialVersionUID = -4870937781750359421L;

	private LinkModel() {
	}

	private String href;
	private String text;

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private String href;
		private String text;

		public Builder href(String href) {
			this.href = href;
			return this;
		}

		public Builder text(String text) {
			this.text = text;
			return this;
		}

		public LinkModel build() {
			LinkModel link = new LinkModel();
			link.href = this.href;
			link.text = this.text;
			return link;
		}
	}
}
