package com.webfrey.uniliga.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
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
//    @Generated(GenerationType.IDENTITY)
    private int id;
    private String name;
    private String logoPath;
    private int wins;
    private int losses;
    private int draws;

    @Transient
    private List<Player> player;

}
