package com.springboot.inventory.service;

import com.springboot.inventory.entity.School;

import java.util.List;

public interface SchoolService {
    School createSchool(School school);

    School getSchoolById(Long schoolId);

    List<School> getAllSchools();

    School updateSchool(School school);

    void deleteSchool(Long schoolId);
}
