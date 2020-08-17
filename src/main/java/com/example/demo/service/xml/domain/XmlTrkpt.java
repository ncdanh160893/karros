package com.example.demo.service.xml.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.example.demo.service.xml.constant.Constants;

@XmlRootElement(name = Constants.Element.TRKPT)
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlTrkpt {

	@XmlAttribute
	private Double lat;

	@XmlAttribute
	private Double lon;

	@XmlElement(namespace = Constants.TOPOGRAFIX_NS)
	private Double ele;

	@XmlElement(namespace = Constants.TOPOGRAFIX_NS)
	private String time;

	public XmlTrkpt() {
	}

	public XmlTrkpt(Double lat, Double lon, Double ele, String time) {
		super();
		this.lat = lat;
		this.lon = lon;
		this.ele = ele;
		this.time = time;
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

	public Double getEle() {
		return ele;
	}

	public void setEle(Double ele) {
		this.ele = ele;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
