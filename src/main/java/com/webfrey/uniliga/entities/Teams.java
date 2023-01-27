package com.webfrey.uniliga.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teams {

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
