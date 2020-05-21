package com.clinics.clinics.service.interf;

import com.clinics.clinics.entity.helpclasses.VisitsCount;

import java.util.List;

public interface VisitsService {

    List<VisitsCount> getVisitsCountByRegion();
}
