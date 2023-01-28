package com.webfrey.uniliga.apis;

import com.webfrey.uniliga.entities.News;
import com.webfrey.uniliga.entities.Player;
import com.webfrey.uniliga.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/news")

public class NewsAPI {

    @Autowired
    private NewsService newsService;

    @GetMapping("/{id}")
    public News getNewsById(@PathVariable int id){
        return newsService.getById(id);
    }

}
