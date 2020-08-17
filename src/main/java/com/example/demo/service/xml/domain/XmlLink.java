package com.example.demo.service.xml.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.example.demo.service.xml.constant.Constants;

@XmlRootElement(name = Constants.Element.LINK)
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlLink {

	@XmlAttribute
	private String href;

	@XmlElement(namespace = Constants.TOPOGRAFIX_NS)
	private String text;

	public XmlLink() {
	}

	public XmlLink(String href, String text) {
		super();
		this.href = href;
		this.text = text;
	}

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
}
