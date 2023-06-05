package com.springboot.inventory.serviceImpl;

import com.springboot.inventory.entity.School;
import com.springboot.inventory.repository.SchoolRepository;
import com.springboot.inventory.service.SchoolService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SchoolServiceImpl implements SchoolService {
    private SchoolRepository schoolRepository;
    @Override
    public School createSchool(School school) {
        return schoolRepository.save(school);
    }

    @Override
    public School getSchoolById(Long schoolId) {
        Optional<School> optionalSchool = schoolRepository.findById(schoolId);
        return optionalSchool.get();
    }

    @Override
    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    @Override
    public School updateSchool(School school) {
        School existingSchool = schoolRepository.findById(school.getId()).get();
        existingSchool.setSchoolName(school.getSchoolName());
        existingSchool.setLocation(school.getLocation());
        existingSchool.setLevel(school.getLevel());
        School updatedSchool = schoolRepository.save(existingSchool);
        return updatedSchool;
    }

    @Override
    public void deleteSchool(Long schoolId) {
        schoolRepository.deleteById(schoolId);

    }
}
