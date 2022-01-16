package com.userfront.service;

import com.userfront.domain.tennis.CategorieBillet;

import java.security.Principal;
import java.util.List;

public interface CategorieBilletService {

    public CategorieBillet saveCategorieBillet(CategorieBillet categorieBillet) ;
    public CategorieBillet findCategorieBilletById(Long id) ;
    public void deleteCategorieBilletById(Long id);
    public List<CategorieBillet> findCategorieBilletList(Principal principal) ;
    public CategorieBillet findCategorieBilletByBilletId(Long id);



}
