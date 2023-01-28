package com.webfrey.uniliga.services;

import com.webfrey.uniliga.entities.News;
import com.webfrey.uniliga.entities.Player;
import com.webfrey.uniliga.repositories.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsService {
    @Autowired
    private NewsRepository newsRepository;

    public News getById(int id){
        return newsRepository.findById(id).orElse(null);
    }
}
