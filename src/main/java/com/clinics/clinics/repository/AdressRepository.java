package com.clinics.clinics.repository;

import com.clinics.clinics.entity.Adress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdressRepository extends JpaRepository<Adress, Integer> {


    @Query("select distinct voivodeship from Adress" +
            " where voivodeship is not null")
    List<String> getAllVoievodship();

    @Query("select a.place, a.street, a.nr_house from Adress a, Clinics c" +
            " where a.place is not null" +
            " and c.id_adresu.id_adress = a.id_adress" +
            " and a.voivodeship like :voievodship")
    List<Object[]> getAllPlaces(String voievodship);
}
