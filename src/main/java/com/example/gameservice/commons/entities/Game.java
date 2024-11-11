package com.example.gameservice.commons.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Games")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Integer userId;
}
