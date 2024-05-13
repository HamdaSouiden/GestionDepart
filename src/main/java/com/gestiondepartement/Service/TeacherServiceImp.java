package com.gestiondepartement.Service;

import com.gestiondepartement.Entity.Students;
import com.gestiondepartement.Entity.Teachers;
import com.gestiondepartement.Repository.StudentRepository;
import com.gestiondepartement.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImp implements TeacherService{
    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public List<Teachers> getAllTeacher() {
        return teacherRepository.findAll();
    }

    @Override
    public Teachers addTeacher(Teachers teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teachers getTeacherById(long teacherId) {
        Teachers teachers = teacherRepository.findByTeacherId(teacherId);
        return teachers;
    }

    @Override
    public Teachers updateTeacher(Teachers teacher) {
        return teacherRepository.saveAndFlush(teacher);
    }

    @Override
    public void deleteTeacher(long teacherId) {
        teacherRepository.deleteById(teacherId);
    }
}
