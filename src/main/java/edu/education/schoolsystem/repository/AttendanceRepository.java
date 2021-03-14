package edu.education.schoolsystem.repository;

import edu.education.schoolsystem.domains.studies.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    @Transactional
    void deleteAttendanceById(Long id);

//    @Transactional
//    String getAttendance(Long attendanceId);

    Optional<Attendance> findAttendanceById(Long id);
}
