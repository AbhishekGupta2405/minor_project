package com.minor_project.minor_project.repository;


import com.minor_project.minor_project.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
