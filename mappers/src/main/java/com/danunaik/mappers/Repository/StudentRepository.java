package com.danunaik.mappers.Repository;

import com.danunaik.mappers.Entity.Student;
import com.danunaik.mappers.Entity.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
  List<Student> findByUniversity(University university);
}
