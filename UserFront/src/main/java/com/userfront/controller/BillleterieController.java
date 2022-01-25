package com.userfront.controller;

import com.userfront.domain.Recipient;
import com.userfront.domain.User;
import com.userfront.domain.tennis.*;
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
    private BilletService billetService;

    @Autowired
    private TournoiService tournoiService;

    @Autowired
    private MatchTennisService matchTennisService;

    @Autowired
    private EmplacementService emplacementService;

    @Autowired
    private CategorieBilletService categorieBilletService;

    @Autowired
    private CategoriePlaceService categoriePlaceService;

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/billeterie", method = RequestMethod.GET)
    public String billet(Model model, Principal principal) {
        List<Billet> billetList = billetService.findBilletList(principal);
        List<Tournoi> tournoiList = tournoiService.findTournoiList(principal);
        List<MatchTennis> matchTennisList = matchTennisService.findMatchTennisList(principal);
        List<Emplacement> emplacementList = emplacementService.findEmplacementList(principal);

        //Nom match
      /*  String nomMatch = billetList.get(0).getMatchTennises().get(0).getNiveau();
        String nomTournoi= billetList.get(0).getTournois().get(0).getNom_tournoi();
        String categorieBillet = billetList.get(0).getCategorieBillets().get(0).getCategorieBilletEnumString();
        String emplacement = billetList.get(0).getEmplacements().get(0).getLibelle();*/


        Billet billet = new Billet();
        Tournoi tournoi = new Tournoi();
        MatchTennis matchTennis = new MatchTennis();
        Emplacement emplacement = new Emplacement();

        model.addAttribute("billetList", billetList);
        model.addAttribute("billet", billet);

        model.addAttribute("tournoiList", tournoiList);
        model.addAttribute("tournoi", tournoi);

        model.addAttribute("matchTennisList", matchTennisList);
        model.addAttribute("matchTennis", matchTennis);

        model.addAttribute("emplacementList", emplacementList);
        model.addAttribute("emplacement", emplacement);

        return "billeterie";
    }

    @RequestMapping(value = "/billeterie/save", method = RequestMethod.POST)
    public String billetPost(@ModelAttribute("recipient") Recipient recipient,
                                @ModelAttribute("categorieBillet") CategorieBillet categorieBillet,
                                @ModelAttribute("journeeDu") String date,
                                @ModelAttribute("location") String location,
                                @ModelAttribute("place") String place,
                                @ModelAttribute("billet") Billet billet,
                                @ModelAttribute("tournoi") Tournoi tournoi,
                                @ModelAttribute("matchTennis") MatchTennis matchTennis,
                                @ModelAttribute("emplacement") Emplacement emplacement,

                                Principal principal) throws ParseException {

        String categorieBilletForm_AManipuler = categorieBillet.getCategorieBilletEnumString();
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date d1 = format1.parse( date );
        billet.setJourneeDu(d1);



        //System.out.println("testtest d1 :" +d1);

        System.out.println("testtest categorieBilletForm_AManipuler :" +categorieBilletForm_AManipuler);
        List<CategorieBillet> categorieBillets = new ArrayList<>();
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
/*      recipient.setUser(user);
        transactionService.saveRecipient(recipient);*/

        billet.setUser(user);

        List<Tournoi> tournoiList = new ArrayList<>();
        Tournoi tournoiObject = new Tournoi();
        tournoiObject.setNom_tournoi(tournoi.getNom_tournoi());
        tournoiObject.setUser(user);
        tournoiList.add(tournoiObject);

        categorieBillet.setBillet(billet);

        billet.setTournois(tournoiList);
        Billet billet1 = billetService.saveBillet(billet);
        tournoiObject.setBillet(billet1);
        tournoiService.saveTournoi(tournoiObject);

        //Ajout match tennis
        List<MatchTennis> matchTennisList = new ArrayList<>();
        MatchTennis matchTennisObject = new MatchTennis();
        matchTennisObject.setNiveau(matchTennis.getNiveau());
        matchTennisObject.setUser(user);
        matchTennisObject.setBillet(billet1);
        matchTennisList.add(matchTennisObject);
        matchTennisService.saveMatchTennis(matchTennisObject);


        //Ajout emplacement
        List<Emplacement> emplacementList = new ArrayList<>();
        Emplacement emplacementObject = new Emplacement();
        emplacementObject.setLibelle(emplacement.getLibelle());
        emplacementObject.setBillet(billet1);
        emplacementObject.setUser(user);
        emplacementList.add(emplacementObject);
        emplacementService.saveEmplacement(emplacementObject);




        return "redirect:/showbilleterie/billeterie";
    }

    @RequestMapping(value = "/billeterie/edit", method = RequestMethod.GET)
    public String billetEdit(
                             @RequestParam(value = "billetId") String billetId,
                             Model model, Principal principal){

        //Recipient recipient = transactionService.findRecipientByName(recipientName);

        List<Billet> billetList = billetService.findBilletList(principal);
        List<Tournoi> tournoiList = tournoiService.findTournoiList(principal);
        List<MatchTennis> matchTennisList = matchTennisService.findMatchTennisList(principal);
        List<Emplacement> emplacementList = emplacementService.findEmplacementList(principal);
        List<CategorieBillet> categorieBilletList = categorieBilletService.findCategorieBilletList(principal);
        List<CategoriePlace> categoriePlaceList = categoriePlaceService.findCategoriePlaceList(principal);

        Billet billet = billetService.findByBilletId(Long.valueOf(billetId));
        Tournoi tournoi = tournoiService.findTournoiByBilletId(Long.valueOf(billetId));
        MatchTennis matchTennis =  matchTennisService.findMatchTennisByBilletId(Long.valueOf(billetId));
        Emplacement emplacement =  emplacementService.findEmplacementByBilletId(Long.valueOf(billetId));
        CategorieBillet categorieBillet =  categorieBilletService.findCategorieBilletByBilletId(Long.valueOf(billetId));
        CategoriePlace categoriePlace =  categoriePlaceService.findCategoriePlaceByBilletId(Long.valueOf(billetId));

        model.addAttribute("billetList", billetList);
        model.addAttribute("billet", billet);

        model.addAttribute("tournoiList", tournoiList);
        model.addAttribute("tournoi", tournoi);

        model.addAttribute("matchTennisList", matchTennisList);
        model.addAttribute("matchTennis", matchTennis);

        model.addAttribute("emplacementList", emplacementList);
        model.addAttribute("emplacement", emplacement);

        model.addAttribute("categorieBilletList", categorieBilletList);
        model.addAttribute("categorieBillet", categorieBillet);

        model.addAttribute("categoriePlaceList", categoriePlaceList);
        model.addAttribute("categoriePlace", categoriePlace);

        return "billeterie";
    }

    @RequestMapping(value = "/billeterie/delete", method = RequestMethod.GET)
    @Transactional
    public String billetDelete(

            @RequestParam(value = "billetId") String billetId,

                               Model model, Principal principal){


        billetService.deleteByBilletId(Long.valueOf(billetId));


        List<Billet> billetList = billetService.findBilletList(principal);

        Billet billet = new Billet();
        Recipient recipient = new Recipient();

        model.addAttribute("billetList", billetList);
        model.addAttribute("billet", billet);



        return "billeterie";
    }

}
