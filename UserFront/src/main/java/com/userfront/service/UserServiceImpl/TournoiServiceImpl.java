package com.userfront.service.UserServiceImpl;

import com.userfront.dao.*;
import com.userfront.domain.*;
import com.userfront.domain.tennis.*;
import com.userfront.service.TournoiService;
import com.userfront.service.TransactionService;
import com.userfront.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TournoiServiceImpl implements TournoiService {
	
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
    private TournoiDao tournoiDao;

    @Autowired
    private MatchTennisDao matchTennisDao;

    @Autowired
    private JoueurDao joueurDao;

    @Autowired
    private ArbitreDao arbitreDao;


    @Override
    public Tournoi saveTournoi(Tournoi tournoi) {
        return tournoiDao.save(tournoi);
    }

    @Override
    public Tournoi findTournoiById(Long id) {
        return tournoiDao.findById(id);
    }

    @Override
    public void deleteTournoiById(Long id) {
        tournoiDao.deleteById(id);
    }

    @Override
    public List<Tournoi> findTournoiList(Principal principal) {
        String username = principal.getName();
        List<Tournoi> tournoiList = tournoiDao.findAll().stream() 			//convert list to stream
                .filter(billet -> username.equals(billet.getUser().getUsername()))	//filters the line, equals to username
                .collect(Collectors.toList());

        return tournoiList;
    }

    @Override
    public Tournoi findTournoiByBilletId(Long billetId) {
        if(!billetDao.findById(billetId).getTournois().isEmpty()){
            return billetDao.findById(billetId).getTournois().get(0);
        }
        return new Tournoi();
    }


}
