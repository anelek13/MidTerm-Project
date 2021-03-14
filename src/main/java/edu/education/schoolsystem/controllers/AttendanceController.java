package edu.education.schoolsystem.controllers;

import edu.education.schoolsystem.domains.studies.Attendance;
import edu.education.schoolsystem.service.AttendanceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    private final AttendanceService service;

    public AttendanceController(AttendanceService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Attendance>> getAllAttendances() {
        List<Attendance> attendances = service.findAllAttendances();
        return new ResponseEntity<>(attendances, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Attendance> getAttendanceById(@PathVariable("id") Long id) {
        Attendance attendance = service.findById(id);
        return new ResponseEntity<>(attendance, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Attendance> addAttendance(@RequestBody Attendance attendance) {
        Attendance newAttendance = service.addAttendance(attendance);
        return new ResponseEntity<>(newAttendance, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Attendance> updateAttendance(@RequestBody Attendance attendance) {
        Attendance updateAttendance = service.updateAttendance(attendance);
        return new ResponseEntity<>(updateAttendance, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAttendance(@PathVariable("id") Long id) {
        service.deleteAttendance(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
