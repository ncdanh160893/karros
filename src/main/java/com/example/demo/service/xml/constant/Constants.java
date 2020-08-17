package com.example.demo.service.xml.constant;

public class Constants {

	private Constants() {
	}

	public static final String DEFAULT_PAGE = "0";
	public static final String DEFAULT_PAGE_SIZE = "20";

	public static final String TOPOGRAFIX_NS = "http://www.topografix.com/GPX/1/1";

	public class Element {
		public static final String GPX = "gpx";
		public static final String META_DATA = "metadata";
		public static final String WPT = "wpt";
		public static final String TRK = "trk";
		public static final String LINK = "link";
		public static final String TRKSEG = "trkseg";
		public static final String TRKPT = "trkpt";
	}
}
