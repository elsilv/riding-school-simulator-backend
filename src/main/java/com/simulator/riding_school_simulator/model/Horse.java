package com.simulator.riding_school_simulator.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Horse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String pictureUrl;
    private String size;
    private String character;
    private int price;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

}