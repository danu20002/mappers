package com.danunaik.mappers.Service;

import com.danunaik.mappers.Entity.Student;
import com.danunaik.mappers.Entity.University;
import com.danunaik.mappers.Repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityService {
    @Autowired
    private UniversityRepository universityRepository;


    public  void insertUniversity(String name){
        universityRepository.insertUniversity(name);
    }

    public int getTotalStudents(){
        return universityRepository.getTotalStudents();
    }

    public List<Student> getStudentsbySubquery(University university){
        return universityRepository.findStudentsByUniversityusingSubQuery(university);

    }

//    public  List<Student> getstudentsbyJoins(Long universityId){
//        return universityRepository.findStudentByUniversityUsingJoins(universityId);
//    }
}
