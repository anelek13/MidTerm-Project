package edu.education.schoolsystem.repository;

import edu.education.schoolsystem.domains.studies.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Transactional
    void deleteCourseById(Long id);

    Optional<Course> findCourseById(Long id);
}
