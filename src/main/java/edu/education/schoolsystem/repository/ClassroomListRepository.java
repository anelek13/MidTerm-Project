package edu.education.schoolsystem.repository;

import edu.education.schoolsystem.domains.studies.ClassroomList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface ClassroomListRepository extends JpaRepository<ClassroomList, Long> {

    @Transactional
    void deleteClassroomListById(Long id);

    Optional<ClassroomList> findClassroomListById(Long id);
}
