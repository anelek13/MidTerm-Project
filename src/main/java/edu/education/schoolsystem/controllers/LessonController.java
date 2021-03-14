package edu.education.schoolsystem.controllers;

import edu.education.schoolsystem.domains.studies.Lesson;
import edu.education.schoolsystem.service.LessonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lesson")
public class LessonController {

    private final LessonService service;

    public LessonController(LessonService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Lesson>> getAllLessons() {
        List<Lesson> lessons = service.findAllLessons();
        return new ResponseEntity<>(lessons, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Lesson> getLessonById(@PathVariable("id") Long id) {
        Lesson lesson = service.findById(id);
        return new ResponseEntity<>(lesson, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Lesson> addLesson(@RequestBody Lesson lesson) {
        Lesson newLesson = service.addLesson(lesson);
        return new ResponseEntity<>(newLesson, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Lesson> updateLesson(@RequestBody Lesson lesson) {
        Lesson updateLesson = service.updateLesson(lesson);
        return new ResponseEntity<>(updateLesson, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteLesson(@PathVariable("id") Long id) {
        service.deleteLesson(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
