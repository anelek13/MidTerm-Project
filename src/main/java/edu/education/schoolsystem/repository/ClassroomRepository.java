package edu.education.schoolsystem.repository;

import edu.education.schoolsystem.domains.studies.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {

    @Transactional
    void deleteClassroomById(Long id);

    Optional<Classroom> findClassroomById(Long id);
}
