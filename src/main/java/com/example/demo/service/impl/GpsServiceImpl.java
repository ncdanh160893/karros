package com.example.demo.service.impl;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.repo.api.GpsRepository;
import com.example.demo.repo.api.LinkRepository;
import com.example.demo.repo.api.MetaDataRepository;
import com.example.demo.repo.api.TrackPointRepository;
import com.example.demo.repo.api.TrackRepository;
import com.example.demo.repo.api.WaypointRepository;
import com.example.demo.repo.entity.Gps;
import com.example.demo.repo.entity.Link;
import com.example.demo.repo.entity.MetaData;
import com.example.demo.repo.entity.Track;
import com.example.demo.repo.entity.TrackPoint;
import com.example.demo.repo.entity.Waypoint;
import com.example.demo.rest.domain.GpsDetailModel;
import com.example.demo.rest.domain.GpsModel;
import com.example.demo.rest.domain.MetaDataModel;
import com.example.demo.rest.domain.TrackModel;
import com.example.demo.rest.domain.WaypointModel;
import com.example.demo.service.api.GpsService;
import com.example.demo.service.converter.GpsConverter;
import com.example.demo.service.converter.LinkConverter;
import com.example.demo.service.converter.MetadataConverter;
import com.example.demo.service.converter.TrackConverter;
import com.example.demo.service.converter.TrackPointConverter;
import com.example.demo.service.converter.WaypointConverter;
import com.example.demo.service.exception.GpsNotFoundException;
import com.example.demo.service.utils.DateUtils;
import com.example.demo.service.utils.XmlUtils;
import com.example.demo.service.xml.domain.XmlGps;
import com.example.demo.service.xml.domain.XmlMetadata;
import com.example.demo.service.xml.domain.XmlTrk;
import com.example.demo.service.xml.domain.XmlTrkpt;
import com.example.demo.service.xml.domain.XmlTrkseg;
import com.example.demo.service.xml.domain.XmlWpt;

@Service
public class GpsServiceImpl implements GpsService {

	@Autowired
	private LinkRepository linkRepo;

	@Autowired
	private GpsRepository gpsRepo;

	@Autowired
	private TrackPointRepository trackPointRepo;

	@Autowired
	private WaypointRepository waypointRepo;

	@Autowired
	private TrackRepository trackRepo;

	@Autowired
	private MetaDataRepository metaDataRepo;

	@Override
	@Transactional
	public void create(MultipartFile gpsFile) {
		XmlGps xmlGpx = null;
		try {
			xmlGpx = XmlUtils.unmarshalFromInputStream(XmlGps.class, gpsFile.getInputStream());
		} catch (IOException e) {
			throw new IllegalArgumentException("Invalid file", e);
		}
		Optional<Link> createdLink = createLink(xmlGpx);
		MetaData createdMetaData = createMetaData(createdLink, xmlGpx);
		Track createdTrack = createTrack(xmlGpx);
		Gps createdGps = createGps(createdMetaData, createdTrack, xmlGpx);
		createWaypoints(createdGps, xmlGpx);
	}

	private Optional<Link> createLink(XmlGps xmlGpx) {
		XmlMetadata xmlMetadata = xmlGpx.getMetadata();
		Optional<Link> createdLink = Optional.ofNullable(xmlMetadata.getLink()).map(LinkConverter::fromXmlToEntity)
				.map(linkRepo::save);
		return createdLink;
	}

	private MetaData createMetaData(Optional<Link> createdLink, XmlGps xmlGpx) {
		MetaData metaData = MetadataConverter.fromXmlToEntity(xmlGpx.getMetadata());
		createdLink.ifPresent(metaData::setLink);
		return metaDataRepo.save(metaData);
	}

	private Gps createGps(MetaData createdMetaData, Track createdTrack, XmlGps xmlGpx) {
		Gps gps = Gps.builder().metaData(createdMetaData).tracks(createdTrack)
				.createdTime(Calendar.getInstance().getTime()).build();
		Gps createdGps = gpsRepo.save(gps);
		return createdGps;
	}

	private void createWaypoints(Gps createdGps, XmlGps xmlGpx) {
		List<XmlWpt> xmlWpts = xmlGpx.getWpts();
		if (CollectionUtils.isEmpty(xmlWpts)) {
			return;
		}

		List<Waypoint> waypoints = WaypointConverter.fromXmlsToEntities(xmlWpts);
		waypoints.stream().forEach(waypoint -> waypoint.setGps(createdGps));
		waypointRepo.save(waypoints);
	}

	private Track createTrack(XmlGps xmlGpx) {
		XmlTrk trk = xmlGpx.getTrk();
		XmlTrkseg xmlTrkseg = trk.getTrkseg();
		List<XmlTrkpt> trkpts = xmlTrkseg.getTrkpts();

		Track track = Track.builder().name(trk.getName()).build();
		Track createdTrack = trackRepo.save(track);

		List<TrackPoint> trackPoints = TrackPointConverter.fromXmlsToEntities(trkpts);
		trackPoints.stream().forEach(trackPoint -> trackPoint.setTrack((createdTrack)));
		trackPointRepo.save(trackPoints);
		return createdTrack;
	}

	@Override
	public Page<GpsModel> getLatestGps(Pageable pageable) {
		return gpsRepo.getLatestGpses(pageable).map(GpsConverter::fromEntityToModel);
	}

	@Override
	@Transactional(readOnly = true)
	public GpsDetailModel getDetail(Integer gpsId) {
		Assert.notNull(gpsId, "Id must not be null");
		Gps gps = gpsRepo.findOne(gpsId);
		if (Objects.isNull(gps)) {
			throw new GpsNotFoundException("Not found gps");
		}
		MetaDataModel metaDataModel = MetadataConverter.fromEntityToModel(gps.getMetaData());
		TrackModel trackModel = TrackConverter.fromEntityToModel(gps.getTrack());
		List<WaypointModel> waypointModels = WaypointConverter.fromEntitiesToModels(gps.getWaypoints());
		return GpsDetailModel.builder().metaData(metaDataModel).track(trackModel).waypoints(waypointModels)
				.createdTime(DateUtils.toUtcStringDate(gps.getCreatedTime())).build();
	}
}
