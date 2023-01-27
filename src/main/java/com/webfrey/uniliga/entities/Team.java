package com.webfrey.uniliga.entities;

<<<<<<< HEAD:src/main/java/com/webfrey/uniliga/entities/Teams.java
import jakarta.persistence.*;
=======
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
>>>>>>> 1352dc1cf8ed3ca0de3c07792665341aee22239a:src/main/java/com/webfrey/uniliga/entities/Team.java
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String logoPath;
    private int wins;
    private int losses;
    private int draws;

    @Transient
    private List<Player> player;

}
