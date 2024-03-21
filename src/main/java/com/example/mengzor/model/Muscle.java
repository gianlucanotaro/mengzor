package com.example.mengzor.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "muscle")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Muscle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
