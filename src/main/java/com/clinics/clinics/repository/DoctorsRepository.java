package com.clinics.clinics.repository;

import com.clinics.clinics.entity.Doctors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorsRepository extends JpaRepository<Doctors, Integer> {
}
