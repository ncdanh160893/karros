package com.example.demo.utils;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.io.InputStream;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;

import com.example.demo.service.utils.XmlUtils;
import com.example.demo.service.xml.domain.XmlGps;
import com.example.demo.service.xml.domain.XmlLink;
import com.example.demo.service.xml.domain.XmlMetadata;
import com.example.demo.service.xml.domain.XmlTrk;
import com.example.demo.service.xml.domain.XmlTrkpt;
import com.example.demo.service.xml.domain.XmlWpt;

public class XmlUtilsTest {

	@Test
	public void unmarshalFromInputStream_shouldUnmarshalXmlFile_givenInputStreamOfXmlFile() throws Exception {
		InputStream in = XmlUtilsTest.class.getResourceAsStream("/data_test/gps_sample.gpx");
		XmlGps xmlGpx = XmlUtils.unmarshalFromInputStream(XmlGps.class, in);
		assertNotNull(xmlGpx);
		assertMetaData(xmlGpx.getMetadata());
		assertWaypoints(xmlGpx.getWpts());
		assertTrack(xmlGpx.getTrk());
	}

	private void assertMetaData(XmlMetadata xmlMetadata) {
		assertNotNull(xmlMetadata);
		assertThat(xmlMetadata.getName(), Matchers.is("Bardenas Reales: Piskerra y el Paso de los Ciervos"));
		assertThat(xmlMetadata.getAuthor(), Matchers.is("Kaka"));
		assertThat(xmlMetadata.getTime(), Matchers.is("2017-10-22T09:41:33Z"));

		XmlLink xmlLink = xmlMetadata.getLink();
		assertThat(xmlLink.getHref(), Matchers.is("http://www.oruxmaps.com"));
		assertThat(xmlLink.getText(), Matchers.is("OruxMaps"));
	}

	private void assertWaypoints(List<XmlWpt> xmlWpts) {
		assertThat(xmlWpts.size(), Matchers.is(2));
		XmlWpt xmlWpt1 = xmlWpts.get(0);
		assertThat(xmlWpt1.getLat(), Matchers.is(42.2205377));
		assertThat(xmlWpt1.getLon(), Matchers.is(-1.4564538));
		assertThat(xmlWpt1.getName(), Matchers.is("Sorteamos por arriba"));
		assertThat(xmlWpt1.getSym(), Matchers.is("/static/wpt/Waypoint"));

	}

	private void assertTrack(XmlTrk xmlTrk) {
		assertThat(xmlTrk.getName(), Matchers.is("Example GPX Document"));
		assertThat(xmlTrk.getTrkseg().getTrkpts().size(), Matchers.is(2));
		XmlTrkpt xmlTrkpt1 = xmlTrk.getTrkseg().getTrkpts().get(0);
		assertThat(xmlTrkpt1.getLat(), Matchers.is(42.2208895));
		assertThat(xmlTrkpt1.getLon(), Matchers.is(-1.4580696));
		assertThat(xmlTrkpt1.getEle(), Matchers.is(315.86));
		assertThat(xmlTrkpt1.getTime(), Matchers.is("2017-10-22T09:41:38Z"));
	}
}
