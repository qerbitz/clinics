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

    @Query("select distinct place from Adress" +
            " where place is not null")
    List<String> getAllPlaces();
}
