package com.clinics.clinics.repository;

import com.clinics.clinics.entity.Doctors;
import com.clinics.clinics.entity.helpclasses.SpecializationCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public interface DoctorsRepository extends JpaRepository<Doctors, Integer> {

    @Query("select l.name, l.surname, count(s.name) as sumka" +
            " from Doctors l, Specialization s, Specialization_doctor sl" +
            " where  l.id_doctor = sl.id_doctor.id_doctor and s.id_specialization = sl.specialization.id_specialization" +
            " group by l.name, l.surname" +
            " order by sumka desc")
    List<Object[]> getSpecializationCount();



}
