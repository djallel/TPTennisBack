package com.userfront.service;

import com.userfront.domain.tennis.Tournoi;
import com.userfront.domain.tennis.TypeTournoi;

import java.lang.reflect.Type;
import java.security.Principal;
import java.util.List;

public interface TypeTournoiService {

    public TypeTournoi saveTypeTournoi(TypeTournoi typeTournoi) ;
    public TypeTournoi findTypeTournoiById(Long id) ;
    public void deleteTypeTournoiById(Long id);
    public List<TypeTournoi> findTypeTournoiList(Principal principal) ;
    public TypeTournoi findTypeTournoiByBilletId(Long id);
    public TypeTournoi findTypeTournoiByTournoiId(Long id);



}
