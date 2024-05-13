package com.gestiondepartement.Service;

import com.gestiondepartement.Entity.Students;
import com.gestiondepartement.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService{
    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Students> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Students addStudent(Students student) {
        return studentRepository.save(student);
    }

    @Override
    public Students getStudentById(long studentId) {
        Students students = studentRepository.findByStudentId(studentId);
        return students;
    }

    @Override
    public Students updateStudent(Students student) {
        return studentRepository.saveAndFlush(student);
    }

    @Override
    public void deleteStudent(long studentId) {
        studentRepository.deleteById(studentId);
    }
}
