package edu.education.schoolsystem.controllers;

import edu.education.schoolsystem.domains.studies.Classroom;
import edu.education.schoolsystem.service.ClassroomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classroom")
public class ClassroomController {

    private final ClassroomService service;

    public ClassroomController(ClassroomService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Classroom>> getAllClassroom() {
        List<Classroom> classrooms = service.findAllClassroom();
        return new ResponseEntity<>(classrooms, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Classroom> getClassroomById(@PathVariable("id") Long id) {
        Classroom classroom = service.findById(id);
        return new ResponseEntity<>(classroom, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Classroom> addClassroom(@RequestBody Classroom classroom) {
        Classroom newClassrooms = service.addClassroom(classroom);
        return new ResponseEntity<>(newClassrooms, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Classroom> updateClassroom(@RequestBody Classroom classroom) {
        Classroom updateClassroom = service.updateClassroom(classroom);
        return new ResponseEntity<>(updateClassroom, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteClassroom(@PathVariable("id") Long id) {
        service.deleteClassroom(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
