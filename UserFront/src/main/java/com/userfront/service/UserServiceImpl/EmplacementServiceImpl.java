package com.userfront.service.UserServiceImpl;

import com.userfront.dao.*;
import com.userfront.domain.tennis.Emplacement;
import com.userfront.service.EmplacementService;
import com.userfront.service.EmplacementService;
import com.userfront.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmplacementServiceImpl implements EmplacementService {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RecipientDao recipientDao;

    @Autowired
    private BilletDao billetDao;

    @Autowired
    private EmplacementDao emplacementDao;

    @Autowired
    private MatchTennisDao matchTennisDao;

    @Autowired
    private JoueurDao joueurDao;

    @Autowired
    private ArbitreDao arbitreDao;


    @Override
    public Emplacement saveEmplacement(Emplacement emplacement) {
        return emplacementDao.save(emplacement);
    }

    @Override
    public Emplacement findEmplacementById(Long id) {
        return emplacementDao.findById(id);
    }

    @Override
    public void deleteEmplacementById(Long id) {
        emplacementDao.deleteById(id);
    }

    @Override
    public List<Emplacement> findEmplacementList(Principal principal) {
        String username = principal.getName();
        List<Emplacement> emplacementList = emplacementDao.findAll().stream() 			//convert list to stream
                .filter(billet -> username.equals(billet.getUser().getUsername()))	//filters the line, equals to username
                .collect(Collectors.toList());

        return emplacementList;
    }

    @Override
    public Emplacement findEmplacementByBilletId(Long billetId) {
        if (!billetDao.findById(billetId).getEmplacements().isEmpty()){
            return billetDao.findById(billetId).getEmplacements().get(0);
        }
        return new Emplacement();
    }


}
