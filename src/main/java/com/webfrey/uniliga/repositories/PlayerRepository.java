package com.webfrey.uniliga.repositories;

import com.webfrey.uniliga.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

    List<Player> findByName(String name);
}
