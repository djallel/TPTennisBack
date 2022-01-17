package com.userfront.dao;

import com.userfront.domain.tennis.Emplacement;
import com.userfront.domain.tennis.Joueur;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmplacementDao extends CrudRepository<Emplacement, Long> {
    List<Emplacement> findAll();

    Emplacement findById(Long id);

    void deleteById(Long id);
}
