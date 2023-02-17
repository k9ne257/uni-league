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
public class DashboardController {

    @Autowired
    private PlayerService playerService;


    @GetMapping("/dashboard")
    public String showAllPlayers(Model model) {
        return "dashboard";
    }


}
