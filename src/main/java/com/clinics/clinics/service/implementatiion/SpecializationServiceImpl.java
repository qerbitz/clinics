package com.clinics.clinics.service.implementatiion;

import com.clinics.clinics.entity.Specjalizacje;
import com.clinics.clinics.repository.SpecializationRepository;
import com.clinics.clinics.service.interf.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecializationServiceImpl implements SpecializationService {

    SpecializationRepository specializationRepository;

    @Autowired
    public SpecializationServiceImpl(SpecializationRepository specializationRepository){
      this.specializationRepository = specializationRepository;
    }

    @Override
    public List<Specjalizacje> getAllSpecializations() {
        return specializationRepository.findAll();
    }
}
