package com.gestiondepartement.Repository;

import com.gestiondepartement.Entity.Students;
import com.gestiondepartement.Entity.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teachers, Long> {
    Teachers findByTeacherId(long teacherId);
}
