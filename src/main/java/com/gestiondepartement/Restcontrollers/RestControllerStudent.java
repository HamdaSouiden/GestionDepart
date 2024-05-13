package com.gestiondepartement.Restcontrollers;

import com.gestiondepartement.Entity.Students;
import com.gestiondepartement.Service.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/student")
public class RestControllerStudent {
    @Autowired
    private StudentServiceImp studentServiceImp;

    @GetMapping("/all")
    public List<Students> getallStudents(){
        return studentServiceImp.getAllStudents();
    }

    @PostMapping("/save")
    public Students addStudent(@RequestBody Students student){
        return studentServiceImp.addStudent(student);
    }

    @GetMapping("/getone/{id}")
    public Students getOneStudent(@PathVariable Long id){
        return studentServiceImp.getStudentById(id);
    }

    @PutMapping("/update/{id}")
    public Students updateStudent(@PathVariable Long id, @RequestBody Students student){
        Students student1 = studentServiceImp.getStudentById(id);
        if (student1 != null){
            student.setId(id);
            return studentServiceImp.updateStudent(student);
        }else {
            throw new RuntimeException("Failled !!");
        }
    }

    @DeleteMapping("/delete/{id}")
    public HashMap<String, String> deleteStudent(@PathVariable Long id){
        HashMap<String, String> message = new HashMap<>();

        if (studentServiceImp.getStudentById(id) == null){
            message.put("etat", "student not found");
            return message;
        }
        try {
            studentServiceImp.deleteStudent(id);
            message.put("etat", "student deleted");
            return message;
        }catch (Exception e){
            message.put("etat", "student not deleted");
            return message;
        }
    }
}
