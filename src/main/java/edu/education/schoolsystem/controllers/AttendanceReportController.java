package edu.education.schoolsystem.controllers;

import edu.education.schoolsystem.domains.studies.Attendance;
import edu.education.schoolsystem.domains.studies.Course;
import edu.education.schoolsystem.service.AttendanceReportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/attendance/report")
public class AttendanceReportController {

    private final AttendanceReportService service;

    public AttendanceReportController(AttendanceReportService service) {
        this.service = service;
    }

    @GetMapping("/find/{id}")
    public String getAttendanceReportById(@PathVariable("id") Long id) {
        String report = service.getAttendanceReportById(id);
        return report;
    }

    @GetMapping("/all")
    public ResponseEntity<List<String>> getAllAttendanceReport() {
        List<String> reports = service.getAllAttendanceReport();
        return new ResponseEntity<>(reports, HttpStatus.OK);
    }
}
