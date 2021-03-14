package edu.education.schoolsystem.repository;

import edu.education.schoolsystem.domains.studies.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface TimetableRepository extends JpaRepository<Timetable, Long> {

    @Transactional
    void deleteTimetableById(Long id);

    Optional<Timetable> findTimetableById(Long id);
}
