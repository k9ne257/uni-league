package com.webfrey.uniliga.controller;

import com.webfrey.uniliga.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/players")
    public String showAll(Model model) {
        model.addAttribute("players", playerService.getPlayers());
        return "player";
    }
}
