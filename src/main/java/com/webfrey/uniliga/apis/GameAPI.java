package com.webfrey.uniliga.apis;

import com.webfrey.uniliga.entities.Game;
import com.webfrey.uniliga.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/game")
public class GameAPI {

    @Autowired
    private GameService gameService;

    @GetMapping("/{season}")
    public List<Game> getSeasongame(@PathVariable String season){
        return gameService.generateSeason();
    }
}
