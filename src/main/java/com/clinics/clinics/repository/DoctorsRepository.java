package com.clinics.clinics.repository;

import com.clinics.clinics.entity.Doctors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorsRepository extends JpaRepository<Doctors, Integer> {

    @Query("select l.name, l.surname, count(s.name) " +
            "from Doctors l, Specialization s, Specialization_doctor sl" +
            " where sl.id_doctor = l.id_doctor and s.id_specialization = sl.specialization" +
            " group by l.name, l.surname")
    List<Doctors> findByquantity();
}
