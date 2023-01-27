package com.webfrey.uniliga.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity


public class Match {

    @Id
    private String team_A;
    private String team_B;
    private LocalDate date;
    private LocalTime time;
    private String wins;
    private String losses;
    private int points;
    private String referee;

}
