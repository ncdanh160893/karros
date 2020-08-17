package com.example.demo.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.rest.domain.GpsDetailModel;
import com.example.demo.rest.domain.GpsModel;
import com.example.demo.service.api.GpsService;
import com.example.demo.service.xml.constant.Constants;

@RestController
@RequestMapping(path = "/gps", produces = MediaType.APPLICATION_JSON_VALUE)
public class GpsController {

	@Autowired
	private GpsService gpsService;

	@PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public void upload(@RequestParam("gps") MultipartFile gps) {
		gpsService.create(gps);
	}

	@GetMapping(value = "/latest")
	public Page<GpsModel> getLatestGpses(
			@RequestParam(name = "pageNumber", defaultValue = Constants.DEFAULT_PAGE) final int page,
			@RequestParam(name = "pageSize", defaultValue = Constants.DEFAULT_PAGE_SIZE) final int size) {
		return gpsService.getLatestGps(new PageRequest(page, size));
	}

	@GetMapping(value = "/{id}")
	public GpsDetailModel getDetail(@PathVariable("id") final Integer id) {
		return gpsService.getDetail(id);
	}
}
