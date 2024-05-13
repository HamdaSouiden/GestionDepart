package com.gestiondepartement.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name="admin")
public class Admin implements Serializable {

    private static final long serialVersion =1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="adminId")
    private Long adminId;

    @Column(name="username")
    private String username;

    @Column(name="email")
    private String email;

    public long getAdminId() {
        return adminId;
    }
    public void SetAdminId(long adminId) {
        this.adminId=adminId;
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
}