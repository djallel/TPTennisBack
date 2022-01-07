package com.userfront.dao;

import com.userfront.domain.tennis.Billet;
import com.userfront.domain.tennis.Tournoi;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TournoiDao extends CrudRepository<Tournoi, Long> {
    List<Tournoi> findAll();

    Tournoi findById(Long id);

    void deleteById(Long id);
}
