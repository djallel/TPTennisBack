package com.userfront.service;

import com.userfront.domain.tennis.Arbitre;
import com.userfront.domain.tennis.Joueur;
import com.userfront.domain.tennis.MatchTennis;
import com.userfront.domain.tennis.Tournoi;

import java.security.Principal;
import java.util.List;

public interface TournoiService {

    public Tournoi saveTournoi(Tournoi tournoi) ;
    public Tournoi findTournoiById(Long id) ;
    public void deleteTournoiById(Long id);
    public List<Tournoi> findTournoiList(Principal principal) ;
    public Tournoi findTournoiByBilletId(Long id);



}
