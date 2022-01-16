package com.userfront.service.UserServiceImpl;

import com.userfront.dao.*;
import com.userfront.domain.tennis.CategoriePlace;
import com.userfront.service.CategoriePlaceService;
import com.userfront.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriePlaceServiceImpl implements CategoriePlaceService {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PrimaryTransactionDao primaryTransactionDao;
	
	@Autowired
	private SavingsTransactionDao savingsTransactionDao;
	
	@Autowired
	private PrimaryAccountDao primaryAccountDao;
	
	@Autowired
	private SavingsAccountDao savingsAccountDao;
	
	@Autowired
	private RecipientDao recipientDao;

    @Autowired
    private BilletDao billetDao;

    @Autowired
    private CategoriePlaceDao categoriePlaceDao;

    @Autowired
    private MatchTennisDao matchTennisDao;

    @Autowired
    private JoueurDao joueurDao;

    @Autowired
    private ArbitreDao arbitreDao;


    @Override
    public CategoriePlace saveCategoriePlace(CategoriePlace categoriePlace) {
        return categoriePlaceDao.save(categoriePlace);
    }

    @Override
    public CategoriePlace findCategoriePlaceById(Long id) {
        return categoriePlaceDao.findById(id);
    }

    @Override
    public void deleteCategoriePlaceById(Long id) {
        categoriePlaceDao.deleteById(id);
    }

    @Override
    public List<CategoriePlace> findCategoriePlaceList(Principal principal) {
        String username = principal.getName();
        List<CategoriePlace> categoriePlaceList = categoriePlaceDao.findAll().stream() 			//convert list to stream
                .filter(billet -> username.equals(billet.getUser().getUsername()))	//filters the line, equals to username
                .collect(Collectors.toList());

        return categoriePlaceList;
    }

    @Override
    public CategoriePlace findCategoriePlaceByBilletId(Long billetId) {
        return billetDao.findById(billetId).getCategoriePlaces().get(0);
    }


}
