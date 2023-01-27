package com.webfrey.uniliga.repositories;

import com.webfrey.uniliga.entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Integer> {
}
