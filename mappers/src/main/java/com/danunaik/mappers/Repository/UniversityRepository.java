package com.danunaik.mappers.Repository;

import com.danunaik.mappers.Entity.Student;
import com.danunaik.mappers.Entity.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversityRepository extends JpaRepository<University,Long> {
      @Procedure("insert_university")
     void insertUniversity(String name);

      @Query(value = "SELECT COUNT(*) FROM student",nativeQuery = true)
      int getTotalStudents();
      @Query(value = "SELECT s FROM Student s WHERE s.university=:university")
      List<Student> findStudentsByUniversityusingSubQuery(@Param("university") University university);

//      @Query(value = "SELECT s FROM Student s JOIN FETCH s.university u WHERE u.id= :university")
//    List<Student> findStudentByUniversityUsingJoins(@Param("universityId") Long universityId);
}
