package com.webfrey.uniliga.services;

import com.webfrey.uniliga.entities.Player;
import com.webfrey.uniliga.repositories.PlayerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PlayerServiceTest {


    @Mock
    private PlayerRepository playerRepository;
    private PlayerService playerService;

    @BeforeEach
    void setUp() {
        playerService = new PlayerService(playerRepository);
    }

    @Test
    void getPlayers() {
        playerService.getPlayers();
        verify(playerRepository).findAll();
    }

    @Test
    void getById() {
        int id = 1;
        playerService.getById(id);
        verify(playerRepository).findById(id);
    }

    @Test
    void getByName() {
        String name = "Joe Jogan";
        playerService.getByName(name);
        verify(playerRepository).findByName(name);
    }

    @Test
    void addPlayer() {
        Player player = new Player(4, "Joe Roper", "reaper", "Chicago", 17);

        playerService.addPlayer(player);

        ArgumentCaptor<Player> playerArgumentCaptor = ArgumentCaptor.forClass(Player.class);

        verify(playerRepository).save(playerArgumentCaptor.capture());

        Player capturedPlayer = playerArgumentCaptor.getValue();

        assertThat(capturedPlayer).isEqualTo(player);
    }

    @Test
    void updatePlayer() {
    }

    @Test
    void deletePlayer() {
    }
}