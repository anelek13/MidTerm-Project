package edu.education.schoolsystem.service;

import edu.education.schoolsystem.domains.studies.Attendance;
import edu.education.schoolsystem.exception.AttendanceNotFoundException;
import edu.education.schoolsystem.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService {

    private final AttendanceRepository repository;

    @Autowired
    public AttendanceService(AttendanceRepository repository) {
        this.repository = repository;
    }

    public Attendance addAttendance(Attendance attendance) {
        return repository.save(attendance);
    }

    public Attendance updateAttendance(Attendance attendance) {
        return repository.save(attendance);
    }

    public void deleteAttendance(Long id) {
        repository.deleteAttendanceById(id);
    }

    public Attendance findById(Long id) {
        return repository.findAttendanceById(id)
                .orElseThrow(() -> new AttendanceNotFoundException("Attendance by id " + id + " was not found"));
    }

    public List<Attendance> findAllAttendances() {
        return repository.findAll();
    }
}
