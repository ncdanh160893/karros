package com.example.demo.repo.api;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.repo.entity.Track;

public interface TrackRepository extends JpaRepository<Track, Integer> {
}
