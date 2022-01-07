package com.userfront.dao;

import com.userfront.domain.tennis.Joueur;
import com.userfront.domain.tennis.Tournoi;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JoueurDao extends CrudRepository<Joueur, Long> {
    List<Joueur> findAll();

    Joueur findById(Long id);

    void deleteById(Long id);
}
