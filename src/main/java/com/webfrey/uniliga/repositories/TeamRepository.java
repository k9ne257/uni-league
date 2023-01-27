package com.webfrey.uniliga.repositories;

import com.webfrey.uniliga.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Integer> {
    List<Team> findByName(String name);
}
