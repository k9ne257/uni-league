package com.webfrey.uniliga.services;

import com.webfrey.uniliga.repositories.TeamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamsService {

    @Autowired
    private TeamsRepository teamsRepository;
}
