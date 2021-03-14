package edu.education.schoolsystem.service;

import edu.education.schoolsystem.domains.studies.ClassroomList;
import edu.education.schoolsystem.repository.ClassroomListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomListService {

    private final ClassroomListRepository repository;

    @Autowired
    public ClassroomListService(ClassroomListRepository repository) {
        this.repository = repository;
    }

    public ClassroomList addClassroomList(ClassroomList list) {
        return repository.save(list);
    }

    public ClassroomList updateClassroomList(ClassroomList list) {
        return repository.save(list);
    }

    public void deleteClassroomList(Long id) {
        repository.deleteClassroomListById(id);
    }

    public ClassroomList findById(Long id) {
        return repository.findClassroomListById(id)
                .orElseThrow(() -> new RuntimeException("ClassroomList by id " + id + " was not found"));
    }

    public List<ClassroomList> findAllClassroomLists() {
        return repository.findAll();
    }
}
