package edu.education.schoolsystem.service;

import edu.education.schoolsystem.domains.staff.Teacher;
import edu.education.schoolsystem.exception.UserNotFoundException;
import edu.education.schoolsystem.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository repository;

    @Autowired
    public TeacherService(TeacherRepository repository) {
        this.repository = repository;
    }

    public Teacher addTeacher(Teacher teacher) {
        return repository.save(teacher);
    }

    public Teacher updateTeacher(Teacher teacher) {
        return repository.save(teacher);
    }

    public void deleteTeacher(Long id) {
        repository.deleteTeacherById(id);
    }

    public Teacher findById(Long id) {
        return repository.findTeacherById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public List<Teacher> findAllTeachers() {
        return repository.findAll();
    }
}
