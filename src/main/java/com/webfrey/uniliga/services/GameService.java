package com.webfrey.uniliga.services;

import com.webfrey.uniliga.entities.Game;
import com.webfrey.uniliga.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<Game> generateSeason(){
        List<Game> games = new ArrayList<Game>();
        return games;
    }

    void saveSeason(List<Game> games){
        games.forEach(game -> gameRepository.save(game));
    }
}
