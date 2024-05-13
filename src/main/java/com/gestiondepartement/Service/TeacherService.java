package com.gestiondepartement.Service;

import com.gestiondepartement.Entity.Students;
import com.gestiondepartement.Entity.Teachers;

import java.util.List;

public interface TeacherService {
    List<Teachers> getAllTeacher();
    Teachers addTeacher(Teachers teacher);
    Teachers getTeacherById(long teacherId);
    Teachers updateTeacher(Teachers teacher);
    void deleteTeacher(long teacherId);
}
