package com.clinics.clinics.repository;

import com.clinics.clinics.entity.Visits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitsRepository extends JpaRepository<Visits, Integer> {

    @Query("select a.place, a.street, count(v.id_visit) as sumka" +
            " from Adress a, Visits v, Clinics c" +
            " where v.id_clinics.id_przychodni = c.id_przychodni" +
            " and c.id_adresu.id_adress = a.id_adress" +
            " and a.county like 'P%'" +
            " group by a.place, a.street" +
            " order by sumka desc")
    List<Object[]> getVisitsCountAllClinics();
}
