package com.userfront.service;

import com.userfront.domain.tennis.Arbitre;
import com.userfront.domain.tennis.Joueur;
import com.userfront.domain.tennis.MatchTennis;

import java.security.Principal;
import java.util.List;

public interface MatchTennisService {

    public MatchTennis saveMatchTennis(MatchTennis matchTennis) ;
    public MatchTennis findMatchTennisById(Long id) ;
    public void deleteMatchTennisById(Long id);
    public List<MatchTennis> findMatchTennisList(Principal principal) ;


}
