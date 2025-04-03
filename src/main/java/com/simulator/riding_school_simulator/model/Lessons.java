package com.simulator.riding_school_simulator.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lessons {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private LocalDateTime dateTime;

    private int maxStudents;

    private int currentStudents = 0;

    private double price;

    private String lessonType; // e.g., Beginner, Advanced, Dressage

    private String teacherName;

    private String lessonStatus;

    @ElementCollection
    private List<String> horseAssigned;
}
