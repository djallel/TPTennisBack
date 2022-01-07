package com.userfront.service;

import com.userfront.domain.tennis.Arbitre;
import com.userfront.domain.tennis.Joueur;

import java.security.Principal;
import java.util.List;

public interface JoueurService {


    public Joueur saveJoueur(Joueur matchTennis) ;
    public Joueur findJoueurById(Long id) ;
    public void deleteJoueurById(Long id);
    public List<Joueur> findJoueurList(Principal principal) ;


}
