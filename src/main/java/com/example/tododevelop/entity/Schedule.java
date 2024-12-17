package com.example.tododevelop.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "schedule")
@Getter
public class Schedule extends Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "longtext")
    private String contents;

    @Column(nullable = false)
    private String username;

    public Schedule() {

    }

    public Schedule(String title, String contents, String username) {
        this.title = title;
        this.contents = contents;
        this.username = username;
    }

}
