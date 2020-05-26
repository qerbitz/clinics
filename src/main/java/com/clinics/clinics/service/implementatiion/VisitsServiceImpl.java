package com.clinics.clinics.service.implementatiion;

import com.clinics.clinics.entity.helpclasses.Med_Res_Count;
import com.clinics.clinics.entity.helpclasses.VisitsCount;
import com.clinics.clinics.repository.VisitsRepository;
import com.clinics.clinics.service.interf.VisitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<VisitsCount> getVisitsCountByRegion() {
        List<VisitsCount> visitsCount = new ArrayList<>();

        for (Object[] obj : visitsRepository.getVisitsCountAllClinics()){
            String place = String.valueOf(obj[0]);
            String street = String.valueOf(obj[1]);
            String count = String.valueOf(obj[2]);
            VisitsCount object = new VisitsCount();
            object.setPlace(place);
            object.setStreet(street);
            object.setCount(count);
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
}
