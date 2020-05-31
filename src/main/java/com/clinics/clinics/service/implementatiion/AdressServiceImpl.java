package com.clinics.clinics.service.implementatiion;

import com.clinics.clinics.entity.*;
import com.clinics.clinics.repository.AdressRepository;
import com.clinics.clinics.service.interf.AdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
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
    public List<Adress> getAllPlaces(String voievodship) {
        List<Adress> taka = new ArrayList<>();;

        for (Object[] obj : adressRepository.getAllPlaces(voievodship)){

            Adress adres = new Adress();
            adres.setPlace(String.valueOf(obj[0]));
            adres.setStreet(String.valueOf(obj[1]));
            adres.setNr_house(String.valueOf(obj[2]));

            taka.add(adres);
        }


        return taka;
    }
}
