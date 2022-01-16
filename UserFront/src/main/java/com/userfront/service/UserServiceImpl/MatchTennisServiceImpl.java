package com.userfront.service.UserServiceImpl;

import com.userfront.dao.*;
import com.userfront.domain.*;
import com.userfront.domain.tennis.*;
import com.userfront.service.MatchTennisService;
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
public class MatchTennisServiceImpl implements MatchTennisService {
	
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
    public MatchTennis saveMatchTennis(MatchTennis matchTennis) {
        return matchTennisDao.save(matchTennis);
    }

    @Override
    public MatchTennis findMatchTennisById(Long id) {
        return matchTennisDao.findById(id);
    }

    @Override
    public void deleteMatchTennisById(Long id) {
        matchTennisDao.deleteById(id);
    }

    @Override
    public List<MatchTennis> findMatchTennisList(Principal principal) {
        String username = principal.getName();
        List<MatchTennis> matchTennisList = matchTennisDao.findAll().stream() 			//convert list to stream
                .filter(billet -> username.equals(billet.getUser().getUsername()))	//filters the line, equals to username
                .collect(Collectors.toList());

        return matchTennisList;
    }

    @Override
    public  MatchTennis findMatchTennisByBilletId(Long billetId){
        if(!billetDao.findById(billetId).getMatchTennises().isEmpty()){

            return  billetDao.findById(billetId).getMatchTennises().get(0);
        }
        return  new MatchTennis();
    }


}
