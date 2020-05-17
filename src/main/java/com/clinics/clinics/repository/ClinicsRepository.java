package com.clinics.clinics.repository;

import com.clinics.clinics.entity.Clinics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicsRepository extends JpaRepository<Clinics, Integer> {
}
