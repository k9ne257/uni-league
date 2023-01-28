package com.webfrey.uniliga.controller;

import com.webfrey.uniliga.entities.Player;
import com.webfrey.uniliga.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class PlayerController {

    @Autowired
    private PlayerService playerService;


    @GetMapping("/players")
    public String showAllPlayers(Model model) {
        model.addAttribute("players", playerService.getPlayers());
        return "player";
    }

    @GetMapping("/addPlayer")
    public String addPlayerPage(Model model) {
        model.addAttribute("playerPresent",false);
        return "addPlayer";
    }

    @GetMapping("/editPlayer/{id}")
    public String editPlayerPage(@PathVariable int id,Model model) {
        model.addAttribute("player",playerService.getById(id));
        model.addAttribute("playerPresent",true);
        return "addPlayer";
    }

    @PostMapping("players/insert")
    public RedirectView insertPlayer(Player player, Model model){
        playerService.addPlayer(player);
        return new RedirectView("/players");
    }

    @PostMapping("players/edit")
    public String updatePlayerInfo(Player player){
        playerService.updatePlayer(player);
        return "players";
    }

    @GetMapping("/deletePlayer/{id}")
    public RedirectView deletePlayer(@PathVariable int id) {
        playerService.deletePlayer(id);
        return new RedirectView("/players");

    }
}
