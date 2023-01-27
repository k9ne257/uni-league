package com.webfrey.uniliga.services;

import com.webfrey.uniliga.entities.Player;
import com.webfrey.uniliga.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    public Player getById(int id){
        return playerRepository.findById(id).orElse(null);
    }

    public List<Player> getByName(String name){
        return playerRepository.findByName(name);
    }

    public void addPlayer(Player player) {
        playerRepository.save(player);
    }
}
