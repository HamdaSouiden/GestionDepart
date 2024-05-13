package com.gestiondepartement.Service;

import com.gestiondepartement.Entity.Students;

import java.util.List;

public interface StudentService {
    List<Students> getAllStudents();
    Students addStudent (Students student);
    Students getStudentById(long studentId);
    Students updateStudent(Students student);
    void deleteStudent(long studentId);
}