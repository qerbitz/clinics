package com.clinics.clinics.service.implementatiion;

import com.clinics.clinics.entity.Doctors;
import com.clinics.clinics.entity.helpclasses.SpecializationCount;
import com.clinics.clinics.repository.DoctorsRepository;
import com.clinics.clinics.service.interf.DoctorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
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

    @Override
    public List<SpecializationCount> getSpecializationCount() {

        List<SpecializationCount> specializationCount = new ArrayList<>();

        for (Object[] obj : doctorsRepository.getSpecializationCount()){
            String name = String.valueOf(obj[0]);
            String surname = String.valueOf(obj[1]);
            String count = String.valueOf(obj[2]);
            //System.out.println(name);
            //System.out.println(surname);
            // System.out.println(count);
            SpecializationCount tak = new SpecializationCount();
            tak.setName(name);
            tak.setSurname(surname);
            tak.setSumka(count);
            specializationCount.add(tak);
        }

        return specializationCount;

    }
}
