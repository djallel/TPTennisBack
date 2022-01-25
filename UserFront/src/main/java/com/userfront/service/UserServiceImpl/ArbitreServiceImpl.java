package com.userfront.service.UserServiceImpl;

import com.userfront.dao.*;
import com.userfront.domain.*;
import com.userfront.domain.tennis.*;
import com.userfront.service.ArbitreService;
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
public class ArbitreServiceImpl implements ArbitreService {
	
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
    public Arbitre saveArbitre(Arbitre arbtire) {
        return arbitreDao.save(arbtire);
    }

    @Override
    public Arbitre findArbitreById(Long id) {
        return arbitreDao.findById(id);
    }

    @Override
    public void deleteArbitreById(Long id) {
        arbitreDao.deleteById(id);
    }

    @Override
    public List<Arbitre> findArbitreList(Principal principal) {
        String username = principal.getName();
        List<Arbitre> arbitreList = arbitreDao.findAll().stream() 			//convert list to stream
                .filter(arbitre -> username.equals(arbitre.getUser().getUsername()))	//filters the line, equals to username
                .collect(Collectors.toList());

        return arbitreList;
    }

}
