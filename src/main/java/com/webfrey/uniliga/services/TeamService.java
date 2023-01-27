package com.webfrey.uniliga.services;

import com.webfrey.uniliga.entities.Player;
import com.webfrey.uniliga.entities.Team;
import com.webfrey.uniliga.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
