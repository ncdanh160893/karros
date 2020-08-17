package com.example.demo.repo.api;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.repo.entity.MetaData;

public interface MetaDataRepository extends JpaRepository<MetaData, Integer> {
}
