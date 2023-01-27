package com.webfrey.uniliga.repositories;

import com.webfrey.uniliga.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

}
