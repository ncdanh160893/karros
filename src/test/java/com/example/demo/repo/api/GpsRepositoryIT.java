package com.example.demo.repo.api;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertThat;

import com.example.demo.repo.entity.Gps;

@Profile({ "test" })
@SpringBootTest
@RunWith(SpringRunner.class)
public class GpsRepositoryIT {

	@Autowired
	private GpsRepository gpsRepository;

	@Test
	@Sql("/sql/create_gps.sql")
	public void getLatestGpses_shouldReturnLatestGpses_givenPageRequest() throws Exception {
		List<Gps> gps = gpsRepository.getLatestGpses(new PageRequest(0, 3)).getContent();
		assertThat(gps.size(), Matchers.is(3));
		assertThat(gps.get(0).getId(), Matchers.is(4));
		assertThat(gps.get(1).getId(), Matchers.is(5));
		assertThat(gps.get(2).getId(), Matchers.is(2));
	}
}
