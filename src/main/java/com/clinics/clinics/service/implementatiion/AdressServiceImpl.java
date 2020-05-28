package com.clinics.clinics.service.implementatiion;

import com.clinics.clinics.entity.Adress;
import com.clinics.clinics.repository.AdressRepository;
import com.clinics.clinics.service.interf.AdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdressServiceImpl implements AdressService{

    AdressRepository adressRepository;

    @Autowired
    public AdressServiceImpl(AdressRepository adressRepository) {
        this.adressRepository = adressRepository;
    }

    @Override
    public List<String> getAllVoievodship() {
        return adressRepository.getAllVoievodship();
    }

    @Override
    public List<String> getAllPlaces() {
        return adressRepository.getAllPlaces();
    }
}
