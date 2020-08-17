package com.example.demo.repo.api;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.repo.entity.Link;

public interface LinkRepository extends JpaRepository<Link, Integer> {
}
