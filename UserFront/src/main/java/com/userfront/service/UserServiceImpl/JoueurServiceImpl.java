package com.userfront.service.UserServiceImpl;

import com.userfront.dao.*;
import com.userfront.domain.*;
import com.userfront.domain.tennis.*;
import com.userfront.service.JoueurService;
import com.userfront.service.TournoiService;
import com.userfront.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoueurServiceImpl implements JoueurService {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RecipientDao recipientDao;

    @Autowired
    private BilletDao billetDao;

    @Autowired
    private TournoiDao tournoiDao;

    @Autowired
    private MatchTennisDao matchTennisDao;

    @Autowired
    private JoueurDao joueurDao;

    @Autowired
    private ArbitreDao arbitreDao;


    @Override
    public Joueur saveJoueur(Joueur joueur) {
        return joueurDao.save(joueur);
    }

    @Override
    public Joueur findJoueurById(Long id) {
        return joueurDao.findById(id);
    }

    @Override
    public void deleteJoueurById(Long id) {
        joueurDao.deleteById(id);
    }

    @Override
    public List<Joueur> findJoueurList(Principal principal) {
        String username = principal.getName();
        List<Joueur> joueurList = joueurDao.findAll().stream() 			//convert list to stream
                .filter(joueur -> username.equals(joueur.getUser().getUsername()))	//filters the line, equals to username
                .collect(Collectors.toList());

        return joueurList;
    }


}
