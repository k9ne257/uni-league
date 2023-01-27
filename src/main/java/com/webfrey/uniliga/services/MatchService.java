package com.webfrey.uniliga.services;

import com.webfrey.uniliga.repositories.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class MatchService {

    @Autowired
    private MatchRepository matchRepository;
}
