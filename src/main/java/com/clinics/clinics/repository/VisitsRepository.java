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
            " and a.county like '%'" +
            " group by a.place, a.street" +
            " order by sumka desc")
    List<Object[]> getVisitsCountAllClinics();


    @Query("select a.place, a.street, count(m.id_medicine) as leki_count, count(r.name) as badania_count" +
            " from Adress a, Visits v, Clinics c, Medicines m, Research r, Vis_Med_Res vmr" +
            " where v.id_clinics.id_przychodni = c.id_przychodni" +
            " and c.id_adresu.id_adress = a.id_adress" +
            " and vmr.id_medicine.id_medicine = m.id_medicine" +
            " and vmr.id_visit.id_visit = v.id_visit" +
            " and vmr.id_research.id_research = r.id_research" +
            " and a.street like '%'" +
            " group by a.place, a.street" +
            " order by leki_count desc")
    List<Object[]> getMed_Res_Count();
}
