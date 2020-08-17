package com.example.demo.service.converter;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

import com.example.demo.repo.entity.Link;
import com.example.demo.service.xml.domain.XmlLink;

public class LinkConverterTest {

	@Test
	public void fromXmlToEntity_shouldConvertFromXmlObjectToEntity_givenXmlObject() throws Exception {
		XmlLink xmlLink = new XmlLink();
		String href = "http://www.oruxmaps.com";
		String text = "OruxMaps";
		xmlLink.setHref(href);
		xmlLink.setText(text);
		Link entity = LinkConverter.fromXmlToEntity(xmlLink);

		assertNotNull(entity);
		assertThat(entity.getHref(), Matchers.is(href));
		assertThat(entity.getText(), Matchers.is(text));
	}
}
