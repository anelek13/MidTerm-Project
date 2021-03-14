package edu.education.schoolsystem.repository;

import edu.education.schoolsystem.domains.studies.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {

    @Transactional
    void deleteLessonById(Long id);

    Optional<Lesson> findLessonById(Long id);
}
