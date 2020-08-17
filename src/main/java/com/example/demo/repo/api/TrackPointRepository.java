package com.example.demo.repo.api;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.repo.entity.TrackPoint;

public interface TrackPointRepository extends JpaRepository<TrackPoint, Integer> {
}
