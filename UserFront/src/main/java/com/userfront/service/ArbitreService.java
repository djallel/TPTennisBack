package com.userfront.service;

import com.userfront.domain.tennis.Arbitre;

import java.security.Principal;
import java.util.List;

public interface ArbitreService {


    public Arbitre saveArbitre(Arbitre matchTennis) ;
    public Arbitre findArbitreById(Long id) ;
    public void deleteArbitreById(Long id);
    public List<Arbitre> findArbitreList(Principal principal) ;
}
