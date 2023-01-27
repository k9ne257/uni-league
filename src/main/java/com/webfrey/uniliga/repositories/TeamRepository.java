package com.webfrey.uniliga.repositories;

import com.webfrey.uniliga.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer> {
}
