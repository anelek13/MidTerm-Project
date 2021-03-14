package edu.education.schoolsystem.service;

import edu.education.schoolsystem.domains.studies.Classroom;
import edu.education.schoolsystem.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomService {

    private final ClassroomRepository repository;

    @Autowired
    public ClassroomService(ClassroomRepository repository) {
        this.repository = repository;
    }

    public Classroom addClassroom(Classroom classroom) {
        return repository.save(classroom);
    }

    public Classroom updateClassroom(Classroom classroom) {
        return repository.save(classroom);
    }

    public void deleteClassroom(Long id) {
        repository.deleteClassroomById(id);
    }

    public Classroom findById(Long id) {
        return repository.findClassroomById(id)
                .orElseThrow(() -> new RuntimeException("Classroom by id " + id + " was not found"));
    }

    public List<Classroom> findAllClassroom() {
        return repository.findAll();
    }
}
