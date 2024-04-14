package com.danunaik.mappers.Service;

import com.danunaik.mappers.Entity.Student;
import com.danunaik.mappers.Repository.StudentRepository;
import com.danunaik.mappers.Repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
   @Autowired
    private StudentRepository studentRepository;

   public Student saveStudent(Student student){
       return studentRepository.save(student);
   }
   public List<Student> getAllStudents(){
       return studentRepository.findAll();
   }
   public Optional<Student> getStudentById(Long id){
       return studentRepository.findById(id);
   }
   public  boolean deleteStudent(Long id){
      studentRepository.deleteById(id);
      return true;
   }

}
