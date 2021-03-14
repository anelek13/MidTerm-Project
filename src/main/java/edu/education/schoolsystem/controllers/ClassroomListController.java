package edu.education.schoolsystem.controllers;

import edu.education.schoolsystem.domains.studies.ClassroomList;
import edu.education.schoolsystem.service.ClassroomListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classroomList")
public class ClassroomListController {

    private final ClassroomListService service;

    public ClassroomListController(ClassroomListService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClassroomList>> getAllClassroomList() {
        List<ClassroomList> lists = service.findAllClassroomLists();
        return new ResponseEntity<>(lists, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ClassroomList> getClassroomListById(@PathVariable("id") Long id) {
        ClassroomList list = service.findById(id);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ClassroomList> addClassroomList(@RequestBody ClassroomList list) {
        ClassroomList newList = service.addClassroomList(list);
        return new ResponseEntity<>(newList, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ClassroomList> updateClassroomList(@RequestBody ClassroomList list) {
        ClassroomList updateList = service.updateClassroomList(list);
        return new ResponseEntity<>(updateList, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteClassroomList(@PathVariable("id") Long id) {
        service.deleteClassroomList(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
