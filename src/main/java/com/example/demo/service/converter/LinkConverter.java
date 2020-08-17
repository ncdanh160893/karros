package com.example.demo.service.converter;

import com.example.demo.repo.entity.Link;
import com.example.demo.service.xml.domain.XmlLink;

public class LinkConverter {

	private LinkConverter() {
	}

	public static Link fromXmlToEntity(XmlLink xmlLink) {
		return Link.builder().href(xmlLink.getHref()).text(xmlLink.getText()).build();
	}
}
