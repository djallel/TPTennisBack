package com.userfront.service;

import com.userfront.domain.tennis.Emplacement;
import com.userfront.domain.tennis.Tournoi;

import java.security.Principal;
import java.util.List;

public interface EmplacementService {

    public Emplacement saveEmplacement(Emplacement emplacement) ;
    public Emplacement findEmplacementById(Long id) ;
    public void deleteEmplacementById(Long id);
    public List<Emplacement> findEmplacementList(Principal principal) ;
    public Emplacement findEmplacementByBilletId(Long id);



}
