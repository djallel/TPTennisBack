package com.userfront.dao;

import com.userfront.domain.tennis.Arbitre;
import com.userfront.domain.tennis.Joueur;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArbitreDao extends CrudRepository<Arbitre, Long> {
    List<Arbitre> findAll();

    Arbitre findById(Long id);

    void deleteById(Long id);
}
