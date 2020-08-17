package com.example.demo.service.converter;

import com.example.demo.repo.entity.Gps;
import com.example.demo.repo.entity.MetaData;
import com.example.demo.rest.domain.GpsModel;
import com.example.demo.service.utils.DateUtils;

public class GpsConverter {

	private GpsConverter() {
	}

	public static GpsModel fromEntityToModel(Gps gps) {
		MetaData metaData = gps.getMetaData();
		return GpsModel.builder().id(gps.getId()).name(metaData.getName()).description(metaData.getDescription())
				.author(metaData.getAuthor()).createdTime(DateUtils.toUtcStringDate(gps.getCreatedTime())).build();
	}
}
