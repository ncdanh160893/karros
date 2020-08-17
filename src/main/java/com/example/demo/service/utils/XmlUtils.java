package com.example.demo.service.utils;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public final class XmlUtils {

	private XmlUtils() {
	}

	@SuppressWarnings("unchecked")
	public static <T> T unmarshalFromInputStream(Class<T> clazz, InputStream in) {
		try {
			final JAXBContext context = JAXBContext.newInstance(clazz);
			final Unmarshaller um = context.createUnmarshaller();
			return (T) um.unmarshal(in);
		} catch (JAXBException e) {
			throw new IllegalArgumentException("Could not unmarshal file", e);
		}
	}
}
