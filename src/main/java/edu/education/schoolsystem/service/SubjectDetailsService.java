package edu.education.schoolsystem.service;

import edu.education.schoolsystem.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectDetailsService {

    private final LessonRepository lessonRepository;

    @Autowired
    public SubjectDetailsService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

//    public String viewSubjectDetails(Long id) {
//
//    }
}
