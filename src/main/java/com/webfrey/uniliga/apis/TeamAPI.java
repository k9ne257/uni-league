package com.webfrey.uniliga.apis;

import com.webfrey.uniliga.entities.Player;
import com.webfrey.uniliga.entities.Team;
import com.webfrey.uniliga.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/teams")

public class TeamAPI {

    @Autowired
    private TeamService teamService;

    @GetMapping("/{id}")
    public Team getTeamsById(@PathVariable int id){
        return teamService.getById(id);
    }

    @GetMapping("/name/{name}")
    public List<Team> getteamByName(@PathVariable String name){
        return teamService.getByName(name);
    }
}
