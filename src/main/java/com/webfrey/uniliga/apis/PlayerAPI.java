package com.webfrey.uniliga.apis;

import com.webfrey.uniliga.entities.Player;
import com.webfrey.uniliga.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/player")
public class PlayerAPI {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public List<Player> getAllPlayer(){
        return playerService.getPlayers();
    }

    @GetMapping("/{id}")
    public Player getPlayerById(@PathVariable int id){
        return playerService.getById(id);
    }

    @GetMapping("/name/{name}")
    public List<Player> getPlayerByName(@PathVariable String name){
        return playerService.getByName(name);
    }

    @PostMapping("/insert")
    public void insertPlayer(Player player){
        playerService.addPlayer(player);
        new RedirectView("/players");
    }
}
