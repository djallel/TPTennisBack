package com.userfront.service;

import com.userfront.domain.tennis.CategoriePlace;

import java.security.Principal;
import java.util.List;

public interface CategoriePlaceService {

    public CategoriePlace saveCategoriePlace(CategoriePlace categoriePlace) ;
    public CategoriePlace findCategoriePlaceById(Long id) ;
    public void deleteCategoriePlaceById(Long id);
    public List<CategoriePlace> findCategoriePlaceList(Principal principal) ;
    public CategoriePlace findCategoriePlaceByBilletId(Long id);



}
