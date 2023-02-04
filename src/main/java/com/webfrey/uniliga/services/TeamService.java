package com.webfrey.uniliga.services;

import com.webfrey.uniliga.entities.Player;
import com.webfrey.uniliga.entities.Team;
import com.webfrey.uniliga.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public Team getById(int id){
        return teamRepository.findById(id).orElse(null);
    }

    public List<Team> getByName(String name){
        return teamRepository.findByName(name);
    }

    public void addTeam(Team team)  {
        System.out.println(team);
        teamRepository.save(team);
    }

    public void updateTeam(Team team) {
        Optional<Team> optionalTeam = teamRepository.findById(team.getId());
        if (optionalTeam.isPresent()){
            Team repoTeam = optionalTeam.get();
            repoTeam.setName(team.getName());
            repoTeam.setLogoPath(team.getLogoPath());
            repoTeam.setWins(team.getWins());
            repoTeam.setLosses(team.getLosses());
            repoTeam.setDraws(team.getDraws());
            teamRepository.save(repoTeam);
        }
    }

    public List<Team> getTeams() {
        return teamRepository.findAll();
    }

    public void deleteTeam(int id) {
        teamRepository.deleteById(id);

    }
}
