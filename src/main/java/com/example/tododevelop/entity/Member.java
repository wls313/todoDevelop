package com.example.tododevelop.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "member")
@Getter
public class Member extends Time{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false , unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    public Member() {

    }

    public Member(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }


    public void updateMember(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public void updatePassword(String password) {
        this.password = password;
    }
}
