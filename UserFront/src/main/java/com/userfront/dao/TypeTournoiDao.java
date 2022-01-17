package com.userfront.dao;

import com.userfront.domain.tennis.Tournoi;
import com.userfront.domain.tennis.TypeTournoi;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TypeTournoiDao extends CrudRepository<TypeTournoi, Long> {
    List<TypeTournoi> findAll();

    TypeTournoi findById(Long id);

    void deleteById(Long id);
}
