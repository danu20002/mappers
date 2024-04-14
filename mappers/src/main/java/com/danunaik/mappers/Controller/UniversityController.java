package com.danunaik.mappers.Controller;

import com.danunaik.mappers.Entity.Student;
import com.danunaik.mappers.Service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/universities")
public class UniversityController {

    @Autowired
    private UniversityService universityService;

    @PostMapping
    public ResponseEntity<Void> insertUniversity(@RequestParam(required = false) String name) {
        if (name == null) {
            return ResponseEntity.badRequest().build(); // Handle the case when 'name' parameter is missing
        }
        universityService.insertUniversity(name);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping("/totalStudents")
    public ResponseEntity<Integer> getTotalStudents() {
        int totalStudents = universityService.getTotalStudents();
        return ResponseEntity.ok(totalStudents);
    }

//    @GetMapping("/studentsByUniversity/{universityId}")
//    public ResponseEntity<List<Student>> getStudentsByUniversity(@PathVariable Long universityId) {
//        List<Student> students = universityService.getStudentsByUniversityUsingJoins(universityId);
//        return ResponseEntity.ok(students);
//    }

    // Add other CRUD API endpoints
}

