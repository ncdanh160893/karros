package com.example.demo.service.xml.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.example.demo.service.xml.constant.Constants;

@XmlRootElement(name = Constants.Element.TRKSEG)
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlTrkseg {

	@XmlElement(name = Constants.Element.TRKPT, namespace = Constants.TOPOGRAFIX_NS)
	private List<XmlTrkpt> trkpts;

	public XmlTrkseg() {
	}

	public XmlTrkseg(List<XmlTrkpt> trkpts) {
		super();
		this.trkpts = trkpts;
	}

	public List<XmlTrkpt> getTrkpts() {
		return trkpts;
	}

	public void setTrkpts(List<XmlTrkpt> trkpts) {
		this.trkpts = trkpts;
	}
}
