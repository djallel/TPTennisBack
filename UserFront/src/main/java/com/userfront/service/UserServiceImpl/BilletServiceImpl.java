package com.userfront.service.UserServiceImpl;

import com.userfront.dao.*;
import com.userfront.domain.*;
import com.userfront.domain.tennis.*;
import com.userfront.service.BilletService;
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
public class BilletServiceImpl implements BilletService {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RecipientDao recipientDao;

    @Autowired
    private BilletDao billetDao;


    public Billet saveBillet(Billet billet) {
        return billetDao.save(billet);
    }


    public Billet findByBilletId(Long billetId) {
        return billetDao.findById( billetId);
    }

    public void deleteByBilletId(Long billetId) {
        billetDao.deleteById(billetId);
    }

    public List<Billet> findBilletList(Principal principal) {
        String username = principal.getName();
        List<Billet> billetList = billetDao.findAll().stream() 			//convert list to stream
                .filter(billet -> username.equals(billet.getUser().getUsername()))	//filters the line, equals to username
                .collect(Collectors.toList());

        return billetList;
    }

}
