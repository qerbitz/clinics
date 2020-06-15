package com.clinics.clinics.service.implementatiion;

import com.clinics.clinics.entity.*;
import com.clinics.clinics.entity.helpclasses.Details;
import com.clinics.clinics.entity.helpclasses.Med_Res_Count;
import com.clinics.clinics.entity.helpclasses.VisitsCount;
import com.clinics.clinics.repository.VisitsRepository;
import com.clinics.clinics.service.interf.VisitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class VisitsServiceImpl implements VisitsService {

    VisitsRepository visitsRepository;

    @Autowired
    public VisitsServiceImpl(VisitsRepository visitsRepository){
        this.visitsRepository = visitsRepository;
    }


    @Override
    public List<VisitsCount> getVisitsCountByRegion(java.util.Date date_from, java.util.Date date_to, String place, String street) {
        List<VisitsCount> visitsCount = new ArrayList<>();

        for (Object[] obj : visitsRepository.getVisitsCountAllClinics(date_from, date_to, place, street)){
            String place1 = String.valueOf(obj[0]);
            String street1 = String.valueOf(obj[1]);
            String count1 = String.valueOf(obj[2]);
            VisitsCount object = new VisitsCount();
            object.setPlace(place1);
            object.setStreet(street1);
            object.setCount(count1);
            visitsCount.add(object);
        }

        return visitsCount;
    }

    @Override
    public List<VisitsCount> getVisitsCountByRegion() {
        List<VisitsCount> visitsCount = new ArrayList<>();

        for (Object[] obj : visitsRepository.getVisitsCountAllClinics()){
            String place1 = String.valueOf(obj[0]);
            String street1 = String.valueOf(obj[1]);
            String count1 = String.valueOf(obj[2]);
            VisitsCount object = new VisitsCount();
            object.setPlace(place1);
            object.setStreet(street1);
            object.setCount(count1);
            visitsCount.add(object);
        }

        return visitsCount;
    }

    @Override
    public List<VisitsCount> getVisitsCountByRegions(String voievodship) {
        List<VisitsCount> visitsCount = new ArrayList<>();

        for (Object[] obj : visitsRepository.getVisitsCountAllClinic(voievodship)){
            String place1 = String.valueOf(obj[0]);
            String street1 = String.valueOf(obj[1]);
            String count1 = String.valueOf(obj[2]);
            VisitsCount object = new VisitsCount();
            object.setPlace(place1);
            object.setStreet(street1);
            object.setCount(count1);
            visitsCount.add(object);
        }

        return visitsCount;
    }

    @Override
    public List<Med_Res_Count> getMed_Res_Count() {
        List<Med_Res_Count> med_res_count = new ArrayList<>();

        for (Object[] obj : visitsRepository.getMed_Res_Count()){
            String place = String.valueOf(obj[0]);
            String street = String.valueOf(obj[1]);
            String count = String.valueOf(obj[2]);
            String count2 = String.valueOf(obj[3]);
            Med_Res_Count object = new Med_Res_Count();
            object.setPlace(place);
            object.setStreet(street);
            object.setCount_med(count);
            object.setCount_res(count2);
            med_res_count.add(object);
        }

        return med_res_count;
    }

    @Override
    public List<Visits> getVisitsByTime() {

        List<Visits> list = new ArrayList<>();

        for (Object[] obj : visitsRepository.getVisitsByTime()){

            Patients p = new Patients();
            p.setName(String.valueOf(obj[0]));
            p.setSurname(String.valueOf(obj[1]));

            Doctors doctor = new Doctors();
            doctor.setName(String.valueOf(obj[2]));
            doctor.setSurname(String.valueOf(obj[3]));

            Diagnosis diagnose = new Diagnosis();
            diagnose.setName(String.valueOf(obj[5]));

            Deadlines deadline = new Deadlines();
            String date = String.valueOf(obj[4]);
            deadline.setDate(Date.valueOf(date));


            Visits v = new Visits();
            String ajdi = String.valueOf(obj[6]);
            v.setId_visit(Integer.parseInt(ajdi));
            v.setId_patient(p);
            v.setId_doctor(doctor);
            v.setId_diagnosis(diagnose);
            v.setId_deadline(deadline);
            list.add(v);
        }

        return list;

    }

    @Override
    public List<Visits> getVisitsByDate(java.util.Date date_from, java.util.Date date_to, String place, String street) throws ParseException {
        List<Visits> list = new ArrayList<>();

        for (Object[] obj : visitsRepository.getVisitsByDate(date_from, date_to, place, street)){

            Patients p = new Patients();
            p.setName(String.valueOf(obj[0]));
            p.setSurname(String.valueOf(obj[1]));

            Doctors doctor = new Doctors();
            doctor.setName(String.valueOf(obj[2]));
            doctor.setSurname(String.valueOf(obj[3]));

            Diagnosis diagnose = new Diagnosis();
            diagnose.setName(String.valueOf(obj[5]));

            Deadlines deadline = new Deadlines();
            String date = String.valueOf(obj[4]);
            deadline.setDate(Date.valueOf(date));


            Visits v = new Visits();
            v.setId_patient(p);
            v.setId_doctor(doctor);
            v.setId_diagnosis(diagnose);
            v.setId_deadline(deadline);
            list.add(v);
        }

        return list;
    }

    @Override
    public List<Details> getDetailsInfo(int ajdi) {
        List<Details> list = new ArrayList<>();

        for (Object[] obj : visitsRepository.getDetailsInfo(ajdi)){

            Details d = new Details();
            d.setMedicine(String.valueOf(obj[0]));
            d.setResearch(String.valueOf(obj[1]));

            list.add(d);
        }

        return list;
    }
}
