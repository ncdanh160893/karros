package com.example.demo.service.converter;

import com.example.demo.repo.entity.Link;
import com.example.demo.repo.entity.MetaData;
import com.example.demo.rest.domain.LinkModel;
import com.example.demo.rest.domain.MetaDataModel;
import com.example.demo.service.utils.DateUtils;
import com.example.demo.service.xml.domain.XmlMetadata;

public class MetadataConverter {

	private MetadataConverter() {
	}

	public static MetaData fromXmlToEntity(XmlMetadata xmlMetadata) {
		return MetaData.builder().name(xmlMetadata.getName()).description(xmlMetadata.getDesc())
				.author(xmlMetadata.getAuthor()).time(DateUtils.toUtcDate(xmlMetadata.getTime())).build();
	}

	public static MetaDataModel fromEntityToModel(MetaData metaData) {
		return MetaDataModel.builder().name(metaData.getName()).description(metaData.getDescription())
				.author(metaData.getAuthor()).time(DateUtils.toUtcStringDate(metaData.getTime()))
				.link(fromLinkEntityToLinkModel(metaData.getLink())).build();
	}

	private static LinkModel fromLinkEntityToLinkModel(Link link) {
		return LinkModel.builder().href(link.getHref()).text(link.getText()).build();
	}
}
