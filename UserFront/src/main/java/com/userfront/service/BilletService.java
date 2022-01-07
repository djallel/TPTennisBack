package com.userfront.service;

import com.userfront.domain.*;
import com.userfront.domain.tennis.*;

import java.security.Principal;
import java.util.List;

public interface BilletService {

    public Billet saveBillet(Billet billet) ;

    public Billet findByBilletId(Long billetId) ;
    public void deleteByBilletId(Long billetId) ;
    public List<Billet> findBilletList(Principal principal) ;


}
