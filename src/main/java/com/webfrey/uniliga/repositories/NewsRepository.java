package com.webfrey.uniliga.repositories;

import com.webfrey.uniliga.entities.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Integer> {
}
