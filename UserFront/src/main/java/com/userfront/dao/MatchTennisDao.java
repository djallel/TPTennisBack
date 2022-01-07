package com.userfront.dao;

import com.userfront.domain.tennis.MatchTennis;
import com.userfront.domain.tennis.Tournoi;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MatchTennisDao extends CrudRepository<MatchTennis, Long> {
    List<MatchTennis> findAll();

    MatchTennis findById(Long id);

    void deleteById(Long id);
}
