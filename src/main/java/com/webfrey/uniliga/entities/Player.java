package com.webfrey.uniliga.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Player {
    @Id
//    @Generated(GenerationType.IDENTITY)
    private int id;
    private String name;
    private String nickName;
    private String team;

}
