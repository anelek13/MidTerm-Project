package edu.education.schoolsystem.service;

import edu.education.schoolsystem.domains.studies.Timetable;
import edu.education.schoolsystem.repository.TimetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimetableService {

    private final TimetableRepository repository;

    @Autowired
    public TimetableService(TimetableRepository repository) {
        this.repository = repository;
    }

    public Timetable addTimetable(Timetable timetable) {
        return repository.save(timetable);
    }

    public Timetable updateTimetable(Timetable timetable) {
        return repository.save(timetable);
    }

    public void deleteTimetable(Long id) {
        repository.deleteTimetableById(id);
    }

    public Timetable findById(Long id) {
        return repository.findTimetableById(id)
                .orElseThrow(() -> new RuntimeException("Timetable by id " + id + " was not found"));
    }

    public List<Timetable> findAllTimetables() {
        return repository.findAll();
    }
}
