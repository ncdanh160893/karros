package com.example.demo.service.xml.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.example.demo.service.xml.constant.Constants;

@XmlRootElement(name = Constants.Element.WPT)
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlWpt {

	@XmlAttribute
	private Double lat;

	@XmlAttribute
	private Double lon;

	@XmlElement(namespace = Constants.TOPOGRAFIX_NS)
	private String name;

	@XmlElement(namespace = Constants.TOPOGRAFIX_NS)
	private String sym;

	public XmlWpt() {
	}

	public XmlWpt(Double lat, Double lon, String name, String sym) {
		super();
		this.lat = lat;
		this.lon = lon;
		this.name = name;
		this.sym = sym;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSym() {
		return sym;
	}

	public void setSym(String sym) {
		this.sym = sym;
	}
}
