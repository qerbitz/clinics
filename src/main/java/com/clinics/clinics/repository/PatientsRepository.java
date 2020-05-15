package com.clinics.clinics.repository;

import com.clinics.clinics.entity.Patients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientsRepository extends JpaRepository<Patients, Integer> {
}
