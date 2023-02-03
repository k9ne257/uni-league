package com.webfrey.uniliga.controller;

import com.webfrey.uniliga.entities.Team;
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

    @GetMapping("/teams")
    public String showAllTeams(Model model) {
        model.addAttribute("teams", teamService.getTeams());
        return "teams/team";
    }

    @GetMapping("/addTeam")
    public String addTeamPage(Model model) {
        model.addAttribute("teamPresent",false);
        return "teams/addTeam";
    }

    @GetMapping("/editTeam/{id}")
    public String editTeamPage(@PathVariable int id,Model model) {
        model.addAttribute("Team", teamService.getById(id));
        model.addAttribute("teamPresent",true);
        model.addAttribute("teamId",id);
        return "teams/addTeam";
    }

    @PostMapping("teams/insert")
    public RedirectView insertTeam(Team team, Model model){
        teamService.addTeam(team);
        return new RedirectView("/teams");
    }

    @PostMapping("teams/edit")
    public RedirectView updateTeamInfo(Team team, Model model){
        teamService.updateTeam(team);
        return new RedirectView("/teams");
    }

    @GetMapping("/deleteTeam/{id}")
    public RedirectView deleteTeam(@PathVariable int id) {
        teamService.deleteTeam(id);
        return new RedirectView("/teams");
    }
}
