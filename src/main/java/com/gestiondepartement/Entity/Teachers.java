package com.gestiondepartement.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name="teacher")
public class Teachers implements Serializable {

    private static final long serialVersion =1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="teacherId")
    private Long teacherId;

    @Column(name="username")
    private String username;

    @Column(name="email")
    private String email;

    @Column (name="department")
    private String department;

    public long getTeacherId() {
        return teacherId;
    }
    public void SetTeacherId(long teacherId) {
        this.teacherId=teacherId;
    }
    public String getusername(){
        return username;
    }
    public void setUsername(String name) {
        this.username=name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email=email;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department=department;
    }

    public void setId(Long id) {
        this.teacherId = id;
    }
}
