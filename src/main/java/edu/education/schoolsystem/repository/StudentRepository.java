package edu.education.schoolsystem.repository;

import edu.education.schoolsystem.domains.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Transactional
    void deleteStudentById(Long id);

    Optional<Student> findStudentById(Long id);
}
