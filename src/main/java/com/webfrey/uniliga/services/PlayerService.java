package com.webfrey.uniliga.services;

import com.webfrey.uniliga.entities.Player;
import com.webfrey.uniliga.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void updatePlayer(Player player) {
        Optional<Player> optionalPlayer = playerRepository.findById(player.getId());
        if (optionalPlayer.isPresent()){
            Player repoPlayer = optionalPlayer.get();
            System.out.println(repoPlayer.getId());
            repoPlayer.setName(player.getName());
            repoPlayer.setNickName(player.getNickName());
            repoPlayer.setTeam(player.getTeam());
            repoPlayer.setGamesPlayed(player.getGamesPlayed());
            playerRepository.save(repoPlayer);
        }
    }

    public void deletePlayer(int id) {
        playerRepository.deleteById(id);
    }
}
