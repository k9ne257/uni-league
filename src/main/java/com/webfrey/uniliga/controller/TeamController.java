package com.webfrey.uniliga.controller;

import com.webfrey.uniliga.entities.Player;
import com.webfrey.uniliga.entities.Team;
import com.webfrey.uniliga.services.PlayerService;
import com.webfrey.uniliga.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

public class TeamController {
    @Autowired
    private TeamService teamService;

    @GetMapping("/team")
    public String showAllTeam(Model model) {
        model.addAttribute("teams", teamService.getTeams());
        return "team";
    }

    @GetMapping("/addTeam")
    public String addTeamPage() {
        return "addTeam";
    }

    @GetMapping("/editTeam/{id}")
    public String editTeamPage(@PathVariable int id, Model model) {
        model.addAttribute("team",teamService.getById(id));
        return "addTeam";
    }

    @PostMapping("team/insert")
    public RedirectView insertTeam(Team team, Model model){
        teamService.addTeam(team);
        return new RedirectView("/teams");
    }

    @PostMapping("teams/edit")
    public String updateTeamInfo(Team team){
        teamService.updateTeam(team);
        return "teams";
    }
}
