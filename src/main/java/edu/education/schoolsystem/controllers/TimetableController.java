package edu.education.schoolsystem.controllers;

import edu.education.schoolsystem.domains.studies.Timetable;
import edu.education.schoolsystem.service.TimetableService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timetable")
public class TimetableController {

    private final TimetableService service;

    public TimetableController(TimetableService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Timetable>> getAllTimetable() {
        List<Timetable> timetables = service.findAllTimetables();
        return new ResponseEntity<>(timetables, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Timetable> getTimetableById(@PathVariable("id") Long id) {
        Timetable timetable = service.findById(id);
        return new ResponseEntity<>(timetable, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Timetable> addTimetable(@RequestBody Timetable timetable) {
        Timetable newTimetable = service.addTimetable(timetable);
        return new ResponseEntity<>(newTimetable, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Timetable> updateTimetable(@RequestBody Timetable timetable) {
        Timetable updateTimetable = service.updateTimetable(timetable);
        return new ResponseEntity<>(updateTimetable, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTimetable(@PathVariable("id") Long id) {
        service.deleteTimetable(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
