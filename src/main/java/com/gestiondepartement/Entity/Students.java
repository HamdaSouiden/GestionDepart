package com.gestiondepartement.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name="student")
public class Students implements Serializable {

    private static final long serialVersion =1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="studentId")
    private Long studentId;

    @Column(name="username")
    private String username;

    @Column(name="email")
    private String email;

    public long getStudentId() {
        return studentId;
    }
    public void SetStudentId(long studentId) {
        this.studentId=studentId;
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

    public void setId(Long id) {
        this.studentId = id;
    }
}
