package com.clinics.clinics.service.interf;

import com.clinics.clinics.entity.Doctors;
import com.clinics.clinics.entity.helpclasses.SpecializationCount;

import java.util.List;

public interface DoctorsService {

    List<Doctors> getAllDoctors();

    List<SpecializationCount> getSpecializationCount();
}
