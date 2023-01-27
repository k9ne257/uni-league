package com.webfrey.uniliga.apis;

import com.webfrey.uniliga.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/match")
public class MatchAPI {

    @Autowired
    private MatchService matchService;
}
