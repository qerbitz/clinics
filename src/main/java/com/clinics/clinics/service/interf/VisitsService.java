package com.clinics.clinics.service.interf;

import com.clinics.clinics.entity.helpclasses.Med_Res_Count;
import com.clinics.clinics.entity.helpclasses.VisitsCount;

import java.util.List;

public interface VisitsService {

    List<VisitsCount> getVisitsCountByRegion();

    List<Med_Res_Count> getMed_Res_Count();
}
