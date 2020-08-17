package com.example.demo.repo.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.repo.entity.Gps;

public interface GpsRepository extends JpaRepository<Gps, Integer> {

	@Query(value = "SELECT g FROM Gps g ORDER BY g.createdTime DESC")
	Page<Gps> getLatestGpses(Pageable pageable);
}
