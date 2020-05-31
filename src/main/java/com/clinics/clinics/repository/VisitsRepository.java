package com.clinics.clinics.repository;

import com.clinics.clinics.entity.Vis_Med_Res;
import com.clinics.clinics.entity.Visits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface VisitsRepository extends JpaRepository<Visits, Integer> {

    @Query("select a.place, a.street, count(v.id_visit) as sumka" +
            " from Adress a, Visits v, Clinics c, Deadlines dl" +
            " where v.id_clinics.id_clinic = c.id_clinic" +
            " and c.id_adresu.id_adress = a.id_adress" +
            " and v.id_deadline.id_deadline = dl.id_deadline" +
            " and a.place like :place" +
            " and a.street like :street" +
            " and dl.date between :date1 and :date2" +
            " group by a.place, a.street" +
            " order by sumka desc")
    List<Object[]> getVisitsCountAllClinics(@Param("date1") Date date1, @Param("date2") Date date2, @Param("place") String place, @Param("street") String street);


    @Query("select a.place, a.street, count(v.id_visit) as sumka" +
            " from Adress a, Visits v, Clinics c" +
            " where v.id_clinics.id_clinic = c.id_clinic" +
            " and c.id_adresu.id_adress = a.id_adress" +
            " and a.county like '%'" +
            " group by a.place, a.street" +
            " order by sumka desc")
    List<Object[]> getVisitsCountAllClinics();


    @Query("select a.place, a.street, count(m.id_medicine) as leki_count, count(r.name) as badania_count" +
            " from Adress a, Visits v, Clinics c, Medicines m, Research r, Vis_Med_Res vmr" +
            " where v.id_clinics.id_clinic = c.id_clinic" +
            " and c.id_adresu.id_adress = a.id_adress" +
            " and vmr.id_medicine.id_medicine = m.id_medicine" +
            " and vmr.id_visit.id_visit = v.id_visit" +
            " and vmr.id_research.id_research = r.id_research" +
            " and a.street like '%'" +
            " group by a.place, a.street" +
            " order by leki_count desc")
    List<Object[]> getMed_Res_Count();


    @Query("select p.name, p.surname, d.name, d.surname, dl.date, dia.name" +
            " from Patients p, Visits v, Doctors d, Deadlines dl, Diagnosis dia, Clinics c, Adress a" +
            " where v.id_patient.id_patient = p.id_patient" +
            " and v.id_doctor.id_doctor = d.id_doctor" +
            " and v.id_deadline.id_deadline = dl.id_deadline" +
            " and v.id_diagnosis.id_diagnosis = dia.id_diagnosis" +
            " and v.id_clinics.id_clinic = c.id_clinic" +
            " and c.id_adresu.id_adress = a.id_adress" +
            " and a.county like '%'" +
            " order by dl.date desc")
    List<Object[]> getVisitsByTime();



    @Query("select p.name, p.surname, d.name, d.surname, dl.date, dia.name" +
            " from Patients p, Visits v, Doctors d, Deadlines dl, Diagnosis dia, Clinics c, Adress a" +
            " where v.id_patient.id_patient = p.id_patient" +
            " and v.id_doctor.id_doctor = d.id_doctor" +
            " and v.id_deadline.id_deadline = dl.id_deadline" +
            " and v.id_diagnosis.id_diagnosis = dia.id_diagnosis" +
            " and v.id_clinics.id_clinic = c.id_clinic" +
            " and c.id_adresu.id_adress = a.id_adress" +
            " and a.place like :place" +
            " and a.street like :street" +
            " and dl.date between :date1 and :date2" +
            " order by dl.date desc")
    List<Object[]> getVisitsByDate(@Param("date1") Date date1, @Param("date2") Date date2, @Param("place") String place, @Param("street") String street);



    @Query("select d.name, m.name, r.name" +
            " from Diagnosis d, Medicines m, Research r, Visits v, Vis_Med_Res vmr" +
            " where v.id_diagnosis = d.id_diagnosis" +
            " and v.id_visit = vmr.id_visit.id_visit" +
            " and m.id_medicine = vmr.id_medicine.id_medicine" +
            " and r.id_research = vmr.id_research.id_research" +
            " and vmr.id_visit = 1")
    List<Object[]> getDetailsInfo(@Param("id_visit") int ajdi);

}