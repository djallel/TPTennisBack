package com.userfront.controller;

import com.userfront.domain.PrimaryAccount;
import com.userfront.domain.Recipient;
import com.userfront.domain.SavingsAccount;
import com.userfront.domain.User;
import com.userfront.domain.tennis.Billet;
import com.userfront.domain.tennis.CategorieBillet;
import com.userfront.domain.tennis.MatchTennis;
import com.userfront.domain.tennis.Tournoi;
import com.userfront.enumeration.CategorieBilletEnum;
import com.userfront.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/showbilleterie")
public class BillleterieController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private BilletService billetService;

    @Autowired
    private TournoiService tournoiService;

    @Autowired
    private MatchTennisService matchTennisService;

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/billeterie", method = RequestMethod.GET)
    public String billet(Model model, Principal principal) {
        List<Billet> billetList = billetService.findBilletList(principal);
        List<Tournoi> tournoiList = tournoiService.findTournoiList(principal);
        List<MatchTennis> matchTennisList = matchTennisService.findMatchTennisList(principal);

        Billet billet = new Billet();
        Tournoi tournoi = new Tournoi();
        MatchTennis matchTennis = new MatchTennis();

        model.addAttribute("billetList", billetList);
        model.addAttribute("billet", billet);

        model.addAttribute("tournoiList", tournoiList);
        model.addAttribute("tournoi", tournoi);

        model.addAttribute("matchTennisList", matchTennisList);
        model.addAttribute("matchTennis", matchTennis);

        return "billeterie";
    }

    @RequestMapping(value = "/billeterie/save", method = RequestMethod.POST)
    public String billetPost(@ModelAttribute("recipient") Recipient recipient,
                                @ModelAttribute("categorieBilletForm") String categorieBilletForm,
                                @ModelAttribute("journeeDuu") String date,
                                @ModelAttribute("location") String location,
                                @ModelAttribute("place") String place,
                                @ModelAttribute("billet") Billet billet,
                                @ModelAttribute("tournoi") String tournoi,
                                @ModelAttribute("matchTennis") String matchTennis,

                                Principal principal) throws ParseException {

        String categorieBilletForm_AManipuler = categorieBilletForm;
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date d1 = format1.parse( date );
        billet.setJourneeDu(d1);
        System.out.println("testtest d1 :" +d1);

        System.out.println("testtest categorieBilletForm_AManipuler :" +categorieBilletForm_AManipuler);
        List<CategorieBillet> categorieBillets = new ArrayList<>();
        CategorieBillet categorieBillet = new CategorieBillet();
        if(categorieBilletForm_AManipuler.equals(CategorieBilletEnum.BILLET_GRAND_PUBLIC_LICENCIE.toString())){
            categorieBillet.setCategorieBilletEnumString(CategorieBilletEnum.BILLET_GRAND_PUBLIC_LICENCIE.categorieBillet);
        }
        if(categorieBilletForm_AManipuler.equals(CategorieBilletEnum.BILLET_GRAND_PUBLIC_NON_LICENCIE.toString())){
            categorieBillet.setCategorieBilletEnumString(CategorieBilletEnum.BILLET_GRAND_PUBLIC_NON_LICENCIE.categorieBillet);
        }
        if(categorieBilletForm_AManipuler.equals(CategorieBilletEnum.BILLET_BIG_MATCH_LICENCIE.toString())){
            categorieBillet.setCategorieBilletEnumString(CategorieBilletEnum.BILLET_BIG_MATCH_LICENCIE.categorieBillet);
        }
        if(categorieBilletForm_AManipuler.equals(CategorieBilletEnum.BILLET_BIG_MATCH_NON_LICENCIE.toString())){
            categorieBillet.setCategorieBilletEnumString(CategorieBilletEnum.BILLET_BIG_MATCH_NON_LICENCIE.categorieBillet);
        }
        categorieBillets.add(categorieBillet);
        billet.setCategorieBillets(categorieBillets);




        System.out.println("testtest location :" +location);
        System.out.println("testtest place :" +place);
        System.out.println("testtest billet :" +billet);
        System.out.println("testtest tournoi 3i :" +tournoi);
        System.out.println("testtest billet.getNbreplace :" +billet.getNbreplace());
        System.out.println("testtest billet.getPrixBillet :" +billet.getPrixBillet());

        User user = userService.findByUsername(principal.getName());
/*        recipient.setUser(user);
        transactionService.saveRecipient(recipient);*/

        billet.setUser(user);
        categorieBillet.setBillet(billet);
        billetService.saveBillet(billet);



        return "redirect:/showbilleterie/billeterie";
    }

    @RequestMapping(value = "/billeterie/edit", method = RequestMethod.GET)
    public String billetEdit(@RequestParam(value = "recipientName") String recipientName, Model model, Principal principal){

        Recipient recipient = transactionService.findRecipientByName(recipientName);
        List<Recipient> recipientList = transactionService.findRecipientList(principal);

        model.addAttribute("recipientList", recipientList);
        model.addAttribute("recipient", recipient);

        return "billeterie";
    }

    @RequestMapping(value = "/billeterie/delete", method = RequestMethod.GET)
    @Transactional
    public String billetDelete(@RequestParam(value = "recipientName") String recipientName, Model model, Principal principal){

        transactionService.deleteRecipientByName(recipientName);

        List<Recipient> recipientList = transactionService.findRecipientList(principal);

        Recipient recipient = new Recipient();
        model.addAttribute("recipient", recipient);
        model.addAttribute("recipientList", recipientList);


        return "billeterie";
    }

}
