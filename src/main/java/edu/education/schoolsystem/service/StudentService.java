package edu.education.schoolsystem.service;

import edu.education.schoolsystem.domains.Student;
import edu.education.schoolsystem.exception.UserNotFoundException;
import edu.education.schoolsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student addStudent(Student student) {
        return repository.save(student);
    }

    public Student updateStudent(Student student) {
        return repository.save(student);
    }

    public void deleteStudent(Long id) {
        repository.deleteStudentById(id);
    }

    public Student findById(Long id) {
        return repository.findStudentById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public List<Student> findAllStudents() {
        return repository.findAll();
    }
}
