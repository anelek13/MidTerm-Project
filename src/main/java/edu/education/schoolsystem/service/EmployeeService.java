package edu.education.schoolsystem.service;

import edu.education.schoolsystem.domains.staff.Employee;
import edu.education.schoolsystem.exception.UserNotFoundException;
import edu.education.schoolsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    @Autowired
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }

    public Employee updateEmployee(Employee employee) {
        return repository.save(employee);
    }

    public void deleteEmployee(Long id) {
        repository.deleteEmployeeById(id);
    }

    public Employee findById(Long id) {
        return repository.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public List<Employee> findAllEmployees() {
        return repository.findAll();
    }
}
