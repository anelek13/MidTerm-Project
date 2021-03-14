package edu.education.schoolsystem.service;

import edu.education.schoolsystem.domains.Student;
import edu.education.schoolsystem.domains.studies.Attendance;
import edu.education.schoolsystem.exception.AttendanceNotFoundException;
import edu.education.schoolsystem.exception.UserNotFoundException;
import edu.education.schoolsystem.repository.AttendanceRepository;
import edu.education.schoolsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttendanceReportService {

    private final AttendanceRepository attendanceRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public AttendanceReportService(AttendanceRepository attendanceRepository, StudentRepository studentRepository) {
        this.attendanceRepository = attendanceRepository;
        this.studentRepository = studentRepository;
    }

    public String getAttendanceReportById(Long attendanceId) {
        Attendance attendance = attendanceRepository.findAttendanceById(attendanceId)
                .orElseThrow(() -> new AttendanceNotFoundException("Attendance by id " + attendanceId + " was not found"));

        Student student = studentRepository.findById(attendance.getStudentId())
                .orElseThrow(() -> new UserNotFoundException("Student by id" + attendance.getStudentId() + " was not found"));

        return getReport(attendance, student);
    }

    public List<String> getAllAttendanceReport() {
        List<Attendance> attendances = attendanceRepository.findAll();

        List<String> reports = new ArrayList<>();

        for (Attendance a : attendances) {
            if (a.getStudentId() != null) {
                Student student = studentRepository.findStudentById(a.getStudentId()).orElseThrow();

                String report = getReport(a, student);

                reports.add(report);
            }
        }

        return reports;
    }

    private String getReport(Attendance attendance, Student student) {
        return "Student: " + student.getFirstname() + " " + student.getLastname() +
                ", Status: " + attendance.isStatus() +
                ", Date: " + attendance.getDate() +
                ", Grade:" + attendance.getGrade();
    }
}
