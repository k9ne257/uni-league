package com.webfrey.uniliga.repositories;

import com.webfrey.uniliga.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Integer> {
}
