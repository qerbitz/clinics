package com.clinics.clinics.service.implementatiion;

import com.clinics.clinics.entity.Doctors;
import com.clinics.clinics.repository.DoctorsRepository;
import com.clinics.clinics.service.interf.DoctorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorsServiceImpl implements DoctorsService {

    DoctorsRepository doctorsRepository;

    @Autowired
    public DoctorsServiceImpl(DoctorsRepository doctorsRepository) {
        this.doctorsRepository = doctorsRepository;
    }

    @Override
    public List<Doctors> getAllDoctors() {
        return doctorsRepository.findAll();
    }
}
