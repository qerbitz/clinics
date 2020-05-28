package com.clinics.clinics.service.interf;

import com.clinics.clinics.entity.Visits;
import com.clinics.clinics.entity.helpclasses.Med_Res_Count;
import com.clinics.clinics.entity.helpclasses.VisitsCount;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface VisitsService {

    List<VisitsCount> getVisitsCountByRegion();

    List<Med_Res_Count> getMed_Res_Count();

    List<Visits> getVisitsByTime();

    List<Visits> getVisitsByDate(Date date_from, Date date_to) throws ParseException;
}
