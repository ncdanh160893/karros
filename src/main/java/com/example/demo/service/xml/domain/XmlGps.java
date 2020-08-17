package com.example.demo.service.xml.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.example.demo.service.xml.constant.Constants;

@XmlRootElement(name = Constants.Element.GPX, namespace = Constants.TOPOGRAFIX_NS)
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlGps {

	@XmlElement(name = Constants.Element.META_DATA, namespace = Constants.TOPOGRAFIX_NS)
	private XmlMetadata metadata;

	@XmlElement(name = Constants.Element.WPT, namespace = Constants.TOPOGRAFIX_NS)
	private List<XmlWpt> wpts;

	@XmlElement(name = Constants.Element.TRK, namespace = Constants.TOPOGRAFIX_NS)
	private XmlTrk trk;

	public XmlGps() {
	}

	public XmlGps(XmlMetadata metadata, List<XmlWpt> wpts, XmlTrk trk) {
		super();
		this.metadata = metadata;
		this.wpts = wpts;
		this.trk = trk;
	}

	public XmlMetadata getMetadata() {
		return metadata;
	}

	public void setMetadata(XmlMetadata metadata) {
		this.metadata = metadata;
	}

	public List<XmlWpt> getWpts() {
		return wpts;
	}

	public void setWpts(List<XmlWpt> wpts) {
		this.wpts = wpts;
	}

	public XmlTrk getTrk() {
		return trk;
	}

	public void setTrk(XmlTrk trk) {
		this.trk = trk;
	}
}
