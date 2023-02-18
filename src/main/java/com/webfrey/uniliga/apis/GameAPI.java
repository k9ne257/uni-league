package com.webfrey.uniliga.apis;

import com.webfrey.uniliga.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/game")
public class GameAPI {

    @Autowired
    private GameService gameService;

}
