package com.example.demo.repo.api;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.repo.entity.Waypoint;

public interface WaypointRepository extends JpaRepository<Waypoint, Integer> {
}
