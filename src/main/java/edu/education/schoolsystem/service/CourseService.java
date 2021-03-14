package edu.education.schoolsystem.service;
;
import edu.education.schoolsystem.domains.studies.Course;
import edu.education.schoolsystem.exception.CourseNotFoundException;
import edu.education.schoolsystem.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository repository;

    @Autowired
    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public Course addCourse(Course course) {
        return repository.save(course);
    }

    public Course updateCourse(Course course) {
        return repository.save(course);
    }

    public void deleteCourse(Long id) {
        repository.deleteCourseById(id);
    }

    public Course findById(Long id) {
        return repository.findCourseById(id)
                .orElseThrow(() -> new CourseNotFoundException("Course by id " + id + " was not found"));
    }

    public List<Course> findAllCourses() {
        return repository.findAll();
    }
}
