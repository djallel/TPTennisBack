package com.userfront.service.UserServiceImpl;

import com.userfront.dao.*;
import com.userfront.domain.tennis.Tournoi;
import com.userfront.domain.tennis.TypeTournoi;
import com.userfront.service.TournoiService;
import com.userfront.service.TypeTournoiService;
import com.userfront.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeTournoiServiceImpl implements TypeTournoiService {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RecipientDao recipientDao;

    @Autowired
    private BilletDao billetDao;

    @Autowired
    private TournoiDao tournoiDao;

    @Autowired
    private TypeTournoiDao typeTournoiDao;

    @Autowired
    private MatchTennisDao matchTennisDao;

    @Autowired
    private JoueurDao joueurDao;

    @Autowired
    private ArbitreDao arbitreDao;


    @Override
    public TypeTournoi saveTypeTournoi(TypeTournoi typeTournoi) {
        return typeTournoiDao.save(typeTournoi);
    }

    @Override
    public TypeTournoi findTypeTournoiById(Long id) {
        return typeTournoiDao.findById(id);
    }

    @Override
    public void deleteTypeTournoiById(Long id) {
        typeTournoiDao.deleteById(id);
    }

    @Override
    public List<TypeTournoi> findTypeTournoiList(Principal principal) {
        String username = principal.getName();
        List<TypeTournoi> typeTournoiList = typeTournoiDao.findAll().stream() 			//convert list to stream
                .filter(billet -> username.equals(billet.getUser().getUsername()))	//filters the line, equals to username
                .collect(Collectors.toList());

        return typeTournoiList;
    }

    @Override
    public TypeTournoi findTypeTournoiByBilletId(Long billetId) {
        if(!billetDao.findById(billetId).getTournois().isEmpty() && !billetDao.findById(billetId).getTournois().get(0).getTypeTournois().isEmpty()){
            return billetDao.findById(billetId).getTournois().get(0).getTypeTournois().get(0);
        }
        return new TypeTournoi();
    }


    @Override
    public TypeTournoi findTypeTournoiByTournoiId(Long tournoiId) {
        if (!tournoiDao.findById(tournoiId).getTypeTournois().isEmpty()) {
            return tournoiDao.findById(tournoiId).getTypeTournois().get(0);
        }
        return new TypeTournoi();
    }

}
