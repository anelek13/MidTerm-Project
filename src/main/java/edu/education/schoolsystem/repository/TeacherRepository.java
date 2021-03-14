package edu.education.schoolsystem.repository;

import edu.education.schoolsystem.domains.staff.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Transactional
    void deleteTeacherById(Long id);

    Optional<Teacher> findTeacherById(Long id);
}
