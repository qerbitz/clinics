package com.clinics.clinics.service.interf;

import com.clinics.clinics.entity.Adress;

import java.util.List;

public interface AdressService {

    List<String> getAllVoievodship();

    List<Adress> getAllPlaces(String voievodship);

}
