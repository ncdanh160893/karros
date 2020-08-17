package com.example.demo.service.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.rest.domain.GpsDetailModel;
import com.example.demo.rest.domain.GpsModel;

public interface GpsService {

	/**
	 * Creates and store gps into DB.
	 * 
	 * @param gps the uploaded file
	 */
	void create(MultipartFile gps);

	/**
	 * Returns latest GPSes.
	 * 
	 * @param pageable
	 * @return List of GPS
	 */
	Page<GpsModel> getLatestGps(Pageable pageable);

	/**
	 * Returns Detail of given GPS.
	 * @param gpsId the id of GPS
	 * @return Detail GPS
	 */
	GpsDetailModel getDetail(Integer gpsId);
}
