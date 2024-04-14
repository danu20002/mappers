package com.danunaik.mappers.Controller;

import com.danunaik.mappers.Entity.Student;
import com.danunaik.mappers.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudensController {
    @Autowired
    private StudentService service;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Student>> getStudntById(@PathVariable Long id){
        Optional<Student> student=service.getStudentById(id);
        if(student !=null){
            return ResponseEntity.ok(student);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

   @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student createstudent=service.saveStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(createstudent);
   }
   @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        boolean deleted=service.deleteStudent(id);
        if(deleted){
         return    ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
   }

}
