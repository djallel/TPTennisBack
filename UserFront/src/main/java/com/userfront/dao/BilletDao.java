package com.userfront.dao;

import java.util.List;

import com.userfront.domain.tennis.Tournoi;
import org.springframework.data.repository.CrudRepository;

import com.userfront.domain.tennis.Billet;

public interface BilletDao extends CrudRepository<Billet, Long> {
    List<Billet> findAll();

    Billet findById(Long billetId);

    void deleteById(Long billetId);
}
