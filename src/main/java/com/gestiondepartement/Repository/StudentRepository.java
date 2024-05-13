package com.gestiondepartement.Repository;

import com.gestiondepartement.Entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Students, Long> {
    Students findByStudentId(long studentId);
}
