package com.example.demo.service.xml.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.example.demo.service.xml.constant.Constants;

@XmlRootElement(name = Constants.Element.TRK)
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlTrk {

	@XmlElement(namespace = Constants.TOPOGRAFIX_NS)
	private String name;

	@XmlElement(name = Constants.Element.TRKSEG, namespace = Constants.TOPOGRAFIX_NS)
	private XmlTrkseg trkseg;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public XmlTrkseg getTrkseg() {
		return trkseg;
	}

	public void setTrkseg(XmlTrkseg trkseg) {
		this.trkseg = trkseg;
	}

	public XmlTrk() {
	}

	public XmlTrk(String name, XmlTrkseg trkseg) {
		super();
		this.name = name;
		this.trkseg = trkseg;
	}
}
