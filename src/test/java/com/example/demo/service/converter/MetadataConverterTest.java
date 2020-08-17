package com.example.demo.service.converter;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

import com.example.demo.repo.entity.Link;
import com.example.demo.repo.entity.MetaData;
import com.example.demo.rest.domain.MetaDataModel;
import com.example.demo.service.utils.DateUtils;
import com.example.demo.service.xml.domain.XmlMetadata;

public class MetadataConverterTest {

	@Test
	public void fromXmlToEntity_shouldConvertToEntity_givenXml() throws Exception {
		XmlMetadata xmlMetadata = new XmlMetadata();
		xmlMetadata.setName("Bardenas Reales: Piskerra y el Paso de los Ciervos");
		xmlMetadata.setDesc("Este espectacular Parque Natural semidesértico");
		xmlMetadata.setAuthor("KAKA");
		xmlMetadata.setTime("2017-10-22T10:41:33Z");

		MetaData metaData = MetadataConverter.fromXmlToEntity(xmlMetadata);
		assertThat(metaData.getName(), Matchers.is(xmlMetadata.getName()));
		assertThat(metaData.getDescription(), Matchers.is(xmlMetadata.getDesc()));
		assertThat(metaData.getAuthor(), Matchers.is(xmlMetadata.getAuthor()));
		assertNotNull(metaData.getTime());
	}

	@Test
	public void fromEntityToModel_shouldConvertToModel_givenEntity() throws Exception {
		MetaData metaData = MetaData.builder().name("Bardenas Reales: Piskerra y el Paso de los Ciervos")
				.description("Este espectacular Parque Natural semidesértico").author("KAKA")
				.time(DateUtils.toUtcDate("2017-10-22T10:41:33Z")).link(Link.builder().build()).build();
		MetaDataModel metaDataModel = MetadataConverter.fromEntityToModel(metaData);
		assertThat(metaDataModel.getName(), Matchers.is(metaData.getName()));
		assertThat(metaDataModel.getDescription(), Matchers.is(metaData.getDescription()));
		assertThat(metaDataModel.getAuthor(), Matchers.is(metaData.getAuthor()));
		assertNotNull(metaDataModel.getTime());

	}
}
