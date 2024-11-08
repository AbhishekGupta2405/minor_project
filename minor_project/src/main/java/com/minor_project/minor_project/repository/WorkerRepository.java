package com.minor_project.minor_project.repository;

import com.minor_project.minor_project.Entity.Worker;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
