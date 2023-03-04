package com.webfrey.uniliga.repositories;

import com.webfrey.uniliga.entities.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PlayerRepositoryTest {

    @Autowired
    private PlayerRepository playerRepository;

    @Test
    void checkFindByNameExists() {

        //      Arrange
        String name = "Joe Roper";
        Player player = new Player(4, name, "reaper", "Chicago", 17);
        playerRepository.save(player);

        //      Act
        List<Player> result = playerRepository.findByName(name);
        boolean match = result.stream().anyMatch(p -> p.getName().equals(name));

        //      Assert
        assertThat(match).isTrue();
    }

    @Test
    void checkFindByNameDoesNotExists() {

        //      Arrange
        String name = "Joe Roper";

        //      Act
        List<Player> result = playerRepository.findByName(name);
        boolean match = result.stream().anyMatch(p -> p.getName().equals(name));

        //      Assert
        assertThat(match).isFalse();
    }
}