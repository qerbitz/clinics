package com.clinics.clinics.repository;

import com.clinics.clinics.entity.Medicines;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicinesRepository extends JpaRepository<Medicines, Integer> {
}
