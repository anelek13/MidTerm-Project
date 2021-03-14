package edu.education.schoolsystem.service;

import edu.education.schoolsystem.domains.studies.Lesson;
import edu.education.schoolsystem.exception.LessonNotFoundException;
import edu.education.schoolsystem.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {

    private final LessonRepository repository;

    @Autowired
    public LessonService(LessonRepository repository) {
        this.repository = repository;
    }

    public Lesson addLesson(Lesson lesson) {
        return repository.save(lesson);
    }

    public Lesson updateLesson(Lesson lesson) {
        return repository.save(lesson);
    }

    public void deleteLesson(Long id) {
        repository.deleteLessonById(id);
    }

    public Lesson findById(Long id) {
        return repository.findLessonById(id)
                .orElseThrow(() -> new LessonNotFoundException("Lesson by id " + id + " was not found"));
    }

    public List<Lesson> findAllLessons() {
        return repository.findAll();
    }
}
