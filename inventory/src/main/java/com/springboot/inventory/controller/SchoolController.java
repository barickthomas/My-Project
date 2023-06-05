package com.springboot.inventory.controller;

import com.springboot.inventory.entity.School;
import com.springboot.inventory.service.SchoolService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/school")
public class SchoolController {
    private SchoolService schoolService;

    @PostMapping
    public ResponseEntity<School> createSchool(@RequestBody School school){
        School savedSchool = schoolService.createSchool(school);
        return new ResponseEntity<>(savedSchool, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<School> getSchoolById(@PathVariable("id") Long schoolId,@RequestBody School school){
        School school1 = schoolService.getSchoolById(schoolId);
        return new ResponseEntity<>(school,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<School>> getAllSchools(){
        List<School> schools = schoolService.getAllSchools();
        return new ResponseEntity<>(schools,HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<School> updateSchool(@PathVariable("id") Long schoolId, @RequestBody School school){
        school.setId(schoolId);
        School updatedSchool = schoolService.updateSchool(school);
        return  new ResponseEntity<>(updatedSchool,HttpStatus.OK);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSchool(@PathVariable("id") Long schoolId){
        schoolService.deleteSchool(schoolId);
        return new ResponseEntity<>("School Deleted successfully",HttpStatus.OK);
    }
}
