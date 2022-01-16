package com.userfront.service.UserServiceImpl;

import com.userfront.dao.*;
import com.userfront.domain.tennis.CategorieBillet;
import com.userfront.service.CategorieBilletService;
import com.userfront.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategorieBilletServiceImpl implements CategorieBilletService {
	
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
    private CategorieBilletDao categorieBilletDao;

    @Autowired
    private MatchTennisDao matchTennisDao;

    @Autowired
    private JoueurDao joueurDao;

    @Autowired
    private ArbitreDao arbitreDao;


    @Override
    public CategorieBillet saveCategorieBillet(CategorieBillet categorieBillet) {
        return categorieBilletDao.save(categorieBillet);
    }

    @Override
    public CategorieBillet findCategorieBilletById(Long id) {
        return categorieBilletDao.findById(id);
    }

    @Override
    public void deleteCategorieBilletById(Long id) {
        categorieBilletDao.deleteById(id);
    }

    @Override
    public List<CategorieBillet> findCategorieBilletList(Principal principal) {
        String username = principal.getName();
        List<CategorieBillet> categorieBilletList = categorieBilletDao.findAll().stream() 			//convert list to stream
                .filter(billet -> username.equals(billet.getUser().getUsername()))	//filters the line, equals to username
                .collect(Collectors.toList());

        return categorieBilletList;
    }

    @Override
    public CategorieBillet findCategorieBilletByBilletId(Long billetId) {
        return billetDao.findById(billetId).getCategorieBillets().get(0);
    }


}
