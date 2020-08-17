package com.example.demo.service.xml.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.example.demo.service.xml.constant.Constants;

@XmlRootElement(name = Constants.Element.META_DATA)
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlMetadata {

	@XmlElement(namespace = Constants.TOPOGRAFIX_NS)
	private String name;

	@XmlElement(namespace = Constants.TOPOGRAFIX_NS)
	private String desc;

	@XmlElement(namespace = Constants.TOPOGRAFIX_NS)
	private String author;

	@XmlElement(name = Constants.Element.LINK, namespace = Constants.TOPOGRAFIX_NS)
	private XmlLink link;

	@XmlElement(namespace = Constants.TOPOGRAFIX_NS)
	private String time;

	public XmlMetadata() {
	}

	public XmlMetadata(String name, String desc, String author, XmlLink link, String time) {
		super();
		this.name = name;
		this.desc = desc;
		this.author = author;
		this.link = link;
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public XmlLink getLink() {
		return link;
	}

	public void setLink(XmlLink link) {
		this.link = link;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
