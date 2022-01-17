package com.userfront.jswing;

import com.toedter.calendar.*;
import com.userfront.dao.TournoiDao;
import com.userfront.dao.TypeTournoiDao;
import com.userfront.domain.tennis.Tournoi;
import com.userfront.domain.tennis.TypeTournoi;
import com.userfront.jswing.common.CommonSwing;
import com.userfront.service.TournoiService;
import com.userfront.service.TypeTournoiService;
import com.userfront.service.UserServiceImpl.TournoiServiceImpl;
import com.userfront.service.UserServiceImpl.TypeTournoiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static javafx.application.Application.launch;

public class FenetrePrincipale extends JFrame{
    public JPanel Main;
    public JTabbedPane tabbedPaneJoueur;
    public JTabbedPane tabbedPaneTournoi;
    public JTabbedPane tabbedPaneMatch;
    public JTabbedPane tabbedPaneArbitre;
    public JLabel informationJoueurLabel;
    public JLabel nomJoueurLabel;
    public JLabel emailLabel;
    public JLabel numéroDeLicenceLabel;
    public JTextField textFieldNomJoueur;
    public JTextField textFieldEmail;
    public JTextField textFieldNumLicence;
    public JButton enregistrerButton;
    public JTable tableJoueur;
    public JButton mettreÀJourButton;
    public JButton supprimerButton;
    public JButton rechercheButton;
    public JTextField textFieldSearch;
    public JLabel telephoneLabel;
    public JTextField textFieldTelephone;
    public JTextArea textAreaDescription;
    public JLabel descriptionLabel;
    public JPanel MainJoueur;
    private JTextField txtArbitreNom;
    private JTextField txtArbitreEmail;
    private JTextField txtArbitreTelephone;
    private JTextField txtArbitreNumLicence;
    private JTextArea txtArbitreDescription;
    private JTable tableArbitre;
    private JTextField txtArbitreSearch;
    private JButton enregistrerArbitreButton;
    private JButton mettreAJourArbitreButton;
    private JButton supprimerArbitreButton;
    private JButton rechercheArbitreButton;
    private JTextField txtNomTournoi;
    private JPanel jpanelTournoi;
    private JPanel jPaneldateDebutTournoi;
    private JPanel jPanelDateFinTournoi;
    private JComboBox comboBoxTypeTournoi;
    private JButton enregistrerTournoiButton;
    private JButton mettreAJourTourniButton;
    private JButton supprimerTournoiButton;
    private JButton rechercheTournoiButton;
    private JTextField txtSearchTournoi;
    private JTextField txtNbrInscritTournoi;
    private JComboBox comboBoxNombreDeTourTournoi;
    private JTextField txtNombreDeJoueurTournoi;
    private JTable tableTournoi;
    private JPanel jpanelTypeTournoi;
    public CommonSwing commonSwing = new CommonSwing();
    public PreparedStatement pst;


Calendar cldDebut = Calendar.getInstance();
Calendar cldFin = Calendar.getInstance();
     JDateChooser JDateChooserDateDebutTournoi =new JDateChooser(cldDebut.getTime());
     JDateChooser JDateChooserDateFinTournoi =new JDateChooser(cldFin.getTime());

    public static void main(String[] args) {


        JFrame frame = new JFrame("Application Tennis");
        frame.setContentPane(new FenetrePrincipale().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public FenetrePrincipale() {
        JDateChooserDateDebutTournoi.setDateFormatString("dd/MM/yyyy");
        jPaneldateDebutTournoi.add(JDateChooserDateDebutTournoi);
        getJDateChooserDateDebutTournoi();
        JDateChooserDateFinTournoi.setDateFormatString("dd/MM/yyyy");
        setJDateChooserDateDebutTournoi("01/01/2022");
        jPanelDateFinTournoi.add(JDateChooserDateFinTournoi);
        commonSwing.connect();
        enregistrerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                enregistrerJoueurJDBC();
            }
        });

        rechercheButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                rechercherJoueurJDBC();


            }
        });

        mettreÀJourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                mettreAJourJoueurJDBC();
            }



        });
        supprimerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                supprimerJoueurJDBC();


            }
        });
        enregistrerArbitreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enregistrerArbitreJDBC();
            }
        });
        mettreAJourArbitreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mettreAJourArbitreJDBC();
            }
        });
        supprimerArbitreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                supprimerArbitreJDBC();
            }
        });
        rechercheArbitreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rechercherArbitreJDBC();
            }
        });
        comboBoxTypeTournoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getJcomboBoxTypeTournoi();
                setJcomboBoxTypeTournoi(1);
            }
        });
        mettreAJourTourniButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mettreAJourTournoiJDBC();
            }
        });
        supprimerTournoiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                supprimerTournoiJDBC();
            }
        });
        rechercheTournoiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rechercherTournoiJDBC();
            }
        });
        enregistrerTournoiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enregistrerTournoiJDBC();
            }
        });
    }

    String getJcomboBoxTypeTournoi(){
        comboBoxTypeTournoi.getSelectedItem();
        System.out.println(comboBoxTypeTournoi.getSelectedIndex());
        System.out.println(comboBoxTypeTournoi.getItemAt(comboBoxTypeTournoi.getSelectedIndex()));
        return comboBoxTypeTournoi.getItemAt(comboBoxTypeTournoi.getSelectedIndex()).toString();
    }

    void setJcomboBoxTypeTournoi(Integer index ){
        comboBoxTypeTournoi.setSelectedIndex(index);
        System.out.println(comboBoxTypeTournoi.getItemAt(comboBoxTypeTournoi.getSelectedIndex()));
    }

    public String getJcomboBoxNombreDeTourTournoi(){
        comboBoxNombreDeTourTournoi.getSelectedItem();
        System.out.println(comboBoxNombreDeTourTournoi.getSelectedIndex());
        System.out.println(comboBoxNombreDeTourTournoi.getItemAt(comboBoxNombreDeTourTournoi.getSelectedIndex()));
        return comboBoxNombreDeTourTournoi.getItemAt(comboBoxNombreDeTourTournoi.getSelectedIndex()).toString();
    }

    public void setJcomboBoxNombreDeTourTournoi(Integer index ){
        comboBoxNombreDeTourTournoi.setSelectedIndex(index);
        System.out.println(comboBoxNombreDeTourTournoi.getItemAt(comboBoxNombreDeTourTournoi.getSelectedIndex()));
    }
     public String getJDateChooserDateDebutTournoi() {
        SimpleDateFormat sdfmt = new SimpleDateFormat("dd/MM/yyyy");
        if (JDateChooserDateDebutTournoi==null || JDateChooserDateDebutTournoi.getDate()==null){
            setJDateChooserDateDebutTournoi("01/01/2022"); //date par defaut
            String dt=sdfmt.format(new Date("01/01/2022"));
            System.out.println(dt);
            return dt;
        }
        String dt=sdfmt.format(JDateChooserDateDebutTournoi.getDate());
        System.out.println(dt);
        return dt;
    }

    public void setJDateChooserDateDebutTournoi(String dateDebutTournoi){
        SimpleDateFormat sdfmt = new SimpleDateFormat("dd/MM/yyyy");
        try {
            if(dateDebutTournoi==null){
                dateDebutTournoi="01/01/2022"; //date par defaut
            }
            Date date = sdfmt.parse(dateDebutTournoi);
            JDateChooserDateFinTournoi.setDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getJDateChooserDateFinTournoi() {
        SimpleDateFormat sdfmt = new SimpleDateFormat("dd/MM/yyyy");
        if (JDateChooserDateFinTournoi==null || JDateChooserDateFinTournoi.getDate()==null){
            setJDateChooserDateFinTournoi("01/01/2022"); //date par defaut
            String dt=sdfmt.format(new Date("01/01/2022"));
            System.out.println(dt);
            return dt;
        }
        String dt=sdfmt.format(JDateChooserDateFinTournoi.getDate());
        System.out.println(dt);
        return dt;
    }

    public void setJDateChooserDateFinTournoi(String dateFinTournoi){
        SimpleDateFormat sdfmt = new SimpleDateFormat("dd/MM/yyyy");
        try {
            if(dateFinTournoi==null){
                dateFinTournoi="01/01/2022"; //date par defaut
            }
            Date date = sdfmt.parse(dateFinTournoi);
            JDateChooserDateFinTournoi.setDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }



    /**
     * Joueur
     */
    public void supprimerJoueurJDBC() {
        String joueurId = textFieldSearch.getText();

        try {
            pst = commonSwing.getCon().prepareStatement("delete from onlinebanking.joueur  where id = ?");

            pst.setString(1, joueurId);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record Deleteeeeee!!!!!");
            commonSwing.table_load_joueur(tableJoueur);

            textFieldNumLicence.setText("");
            textAreaDescription.setText("");
            textFieldEmail.setText("");
            textFieldNomJoueur.setText("");
            textFieldTelephone.setText("");
            textFieldNomJoueur.requestFocus();


        }

        catch (SQLException e1)
        {

            e1.printStackTrace();
        }
    }

    public void mettreAJourJoueurJDBC() {
        String joueur_name;
        String joueur_email;
        String joueur_phone ;
        String joueur_numLicence;
        String joueur_description;
        String joueur_id;

        joueur_name=textFieldNomJoueur.getText();
        joueur_email=textFieldEmail.getText();
        joueur_phone=textFieldTelephone.getText();
        joueur_numLicence=textFieldNumLicence.getText();
        joueur_description=textAreaDescription.getText();
        joueur_id=textFieldSearch.getText();


        try {
            pst = commonSwing.getCon().prepareStatement("update onlinebanking.joueur set num_licence = ?,description = ?,email = ?,name = ?,phone = ? where id = ?");
            //num_licence,description,email,name,phone)
            pst.setString(1, joueur_numLicence);
            pst.setString(2, joueur_description);
            pst.setString(3, joueur_email);
            pst.setString(4, joueur_name);
            pst.setString(5, joueur_phone);
            pst.setString(6, joueur_id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record updated!!!!!");
            commonSwing.table_load_joueur(tableJoueur);
            textFieldNumLicence.setText("");
            textAreaDescription.setText("");
            textFieldEmail.setText("");
            textFieldNomJoueur.setText("");
            textFieldTelephone.setText("");
            textFieldNomJoueur.requestFocus();
        }

        catch (SQLException e1)
        {
            e1.printStackTrace();
        }
    }

    public void rechercherJoueurJDBC() {
        try {

            String joueurId = textFieldSearch.getText();

            pst = commonSwing.getCon().prepareStatement("select num_licence,description,email,name,phone from onlinebanking.joueur where id = ?");
            pst.setString(1, joueurId);
            ResultSet rs = pst.executeQuery();

            if(rs.next()==true)
            {
                String num_licence = rs.getString(1);
                String description = rs.getString(2);
                String email = rs.getString(3);
                String name = rs.getString(4);
                String phone = rs.getString(5);

                textFieldNumLicence.setText(num_licence);
                textAreaDescription.setText(description);
                textFieldEmail.setText(email);
                textFieldNomJoueur.setText(name);
                textFieldTelephone.setText(phone);

            }
            else
            {
                textFieldNumLicence.setText("");
                textAreaDescription.setText("");
                textFieldEmail.setText("");
                textFieldNomJoueur.setText("");
                textFieldTelephone.setText("");
                JOptionPane.showMessageDialog(null,"Invalid joueur No");

            }
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    public void enregistrerJoueurJDBC() {
        String joueur_name;
        String joueur_email;
        String joueur_phone ;
        String joueur_numLicence;
        String joueur_description;

        joueur_name=textFieldNomJoueur.getText();
        joueur_email=textFieldEmail.getText();
        joueur_phone=textFieldTelephone.getText();
        joueur_numLicence=textFieldNumLicence.getText();
        joueur_description=textAreaDescription.getText();


        try {
            pst = commonSwing.getCon().prepareStatement("insert into onlinebanking.joueur(num_licence,description,email,name,phone)values(?,?,?,?,?)");
            pst.setString(1, joueur_numLicence);
            pst.setString(2, joueur_description);
            pst.setString(3, joueur_email);
            pst.setString(4, joueur_name);
            pst.setString(5, joueur_phone);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record Addedddd!!!!!");
            commonSwing.table_load_joueur(tableJoueur);
            textFieldNumLicence.setText("");
            textAreaDescription.setText("");
            textFieldEmail.setText("");
            textFieldNomJoueur.setText("");
            textFieldTelephone.setText("");
            textFieldNomJoueur.requestFocus();
        }

        catch (SQLException e1)
        {

            e1.printStackTrace();
        }
    }


    /**
     * Arbitre
     */

    public void supprimerArbitreJDBC() {
        String arbitreId = txtArbitreSearch.getText();

        try {
            pst = commonSwing.getCon().prepareStatement("delete from onlinebanking.arbitre  where id = ?");

            pst.setString(1, arbitreId);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Arbitre supprimé!");
            commonSwing.table_load_arbitre(tableArbitre);

            txtArbitreNumLicence.setText("");
            txtArbitreDescription.setText("");
            txtArbitreEmail.setText("");
            txtArbitreNom.setText("");
            txtArbitreTelephone.setText("");
            txtArbitreNom.requestFocus();


        }

        catch (SQLException e1)
        {

            e1.printStackTrace();
        }
    }

    public void mettreAJourArbitreJDBC() {
        String arbitre_name;
        String arbitre_email;
        String arbitre_phone ;
        String arbitre_numLicence;
        String arbitre_description;
        String arbitre_id;

        arbitre_name=txtArbitreNom.getText();
        arbitre_email=txtArbitreEmail.getText();
        arbitre_phone=txtArbitreTelephone.getText();
        arbitre_numLicence=txtArbitreNumLicence.getText();
        arbitre_description=txtArbitreDescription.getText();
        arbitre_id=txtArbitreSearch.getText();


        try {
            pst = commonSwing.getCon().prepareStatement("update onlinebanking.arbitre set num_licence = ?,description = ?,email = ?,name = ?,phone = ? where id = ?");
            //num_licence,description,email,name,phone)
            pst.setString(1, arbitre_numLicence);
            pst.setString(2, arbitre_description);
            pst.setString(3, arbitre_email);
            pst.setString(4, arbitre_name);
            pst.setString(5, arbitre_phone);
            pst.setString(6, arbitre_id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Arbitre updated!!!!!");
            commonSwing.table_load_arbitre(tableArbitre);
            txtArbitreNumLicence.setText("");
            txtArbitreDescription.setText("");
            txtArbitreEmail.setText("");
            txtArbitreNom.setText("");
            txtArbitreTelephone.setText("");
            txtArbitreNom.requestFocus();
        }

        catch (SQLException e1)
        {
            e1.printStackTrace();
        }
    }

    public void rechercherArbitreJDBC() {
        try {

            String arbitreId = txtArbitreSearch.getText();

            pst = commonSwing.getCon().prepareStatement("select num_licence,description,email,name,phone from onlinebanking.arbitre where id = ?");
            pst.setString(1, arbitreId);
            ResultSet rs = pst.executeQuery();

            if(rs.next()==true)
            {
                String num_licence = rs.getString(1);
                String description = rs.getString(2);
                String email = rs.getString(3);
                String name = rs.getString(4);
                String phone = rs.getString(5);

                txtArbitreNumLicence.setText(num_licence);
                txtArbitreDescription.setText(description);
                txtArbitreEmail.setText(email);
                txtArbitreNom.setText(name);
                txtArbitreTelephone.setText(phone);

            }
            else
            {
                txtArbitreNumLicence.setText("");
                txtArbitreDescription.setText("");
                txtArbitreEmail.setText("");
                txtArbitreNom.setText("");
                txtArbitreTelephone.setText("");
                JOptionPane.showMessageDialog(null,"Invalid arbitre No");

            }
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    public void enregistrerArbitreJDBC() {
        String arbitre_name;
        String arbitre_email;
        String arbitre_phone ;
        String arbitre_numLicence;
        String arbitre_description;

        arbitre_name=txtArbitreNom.getText();
        arbitre_email=txtArbitreEmail.getText();
        arbitre_phone=txtArbitreTelephone.getText();
        arbitre_numLicence=txtArbitreNumLicence.getText();
        arbitre_description=txtArbitreDescription.getText();

        try {
            pst = commonSwing.getCon().prepareStatement("insert into onlinebanking.arbitre(num_licence,description,email,name,phone)values(?,?,?,?,?)");
            pst.setString(1, arbitre_numLicence);
            pst.setString(2, arbitre_description);
            pst.setString(3, arbitre_email);
            pst.setString(4, arbitre_name);
            pst.setString(5, arbitre_phone);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Arbitre ajouté !");
            commonSwing.table_load_arbitre(tableArbitre);
            txtArbitreNumLicence.setText("");
            txtArbitreDescription.setText("");
            txtArbitreEmail.setText("");
            txtArbitreNom.setText("");
            txtArbitreTelephone.setText("");
            txtArbitreNom.requestFocus();
        }

        catch (SQLException e1)
        {

            e1.printStackTrace();
        }
    }

    /**
     * Tournoi
     */

    public void supprimerTournoiJDBC() {
        String tournoiId = txtSearchTournoi.getText();

        try {
            pst = commonSwing.getCon().prepareStatement("delete from onlinebanking.tournoi  where id = ?");

            pst.setString(1, tournoiId);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Tournoi supprimé!");
            commonSwing.table_load_tournoi(tableTournoi);

            txtNomTournoi.setText("");
            comboBoxTypeTournoi.setSelectedIndex(0);
            JDateChooserDateDebutTournoi.setDate(null);
            JDateChooserDateFinTournoi.setDate(null);
            txtNbrInscritTournoi.setText("");
            comboBoxNombreDeTourTournoi.setSelectedIndex(0);
            txtNombreDeJoueurTournoi.setText("");

            txtNomTournoi.requestFocus();


        }

        catch (SQLException e1)
        {

            e1.printStackTrace();
        }
    }

    public void mettreAJourTournoiJDBC() {
        String tournoi_name;
        String tournoi_typeTournoi;
        String tournoi_dateDebutTournoi ;
        String tournoi_dateFinTournoi;
        String tournoi_nbreInscritTournoi;
        String tournoi_nbreDeTourTournoi;
        String tournoi_nbreDeJoueurTournoi;
        String tournoi_id;

        tournoi_name=txtNomTournoi.getText();
        tournoi_typeTournoi=getJcomboBoxTypeTournoi();
        tournoi_dateDebutTournoi=getJDateChooserDateDebutTournoi();
        tournoi_dateFinTournoi=getJDateChooserDateFinTournoi();
        tournoi_nbreInscritTournoi=txtNbrInscritTournoi.getText();
        tournoi_nbreDeTourTournoi=getJcomboBoxNombreDeTourTournoi();
        tournoi_nbreDeJoueurTournoi=txtNombreDeJoueurTournoi.getText();
        tournoi_id= txtSearchTournoi.getText();


        try {
           //pst tournoi
            pst = commonSwing.getCon().prepareStatement("update onlinebanking.tournoi set date_debut_tournoi = ?,date_fin_tournoi = ?,nbr_inscrit = ?,nbr_tour = ?,nbre_joueurs_max = ?,nom_tournoi = ?,user_id =? where id = ?");
            pst.setString(1, tournoi_dateDebutTournoi);
            pst.setString(2, tournoi_dateFinTournoi);
            pst.setString(3, tournoi_nbreInscritTournoi);
            pst.setString(4, tournoi_nbreDeTourTournoi);
            pst.setString(5, tournoi_nbreDeJoueurTournoi);
            pst.setString(6, tournoi_name);
            pst.setString(7, "3");
            pst.setString(8, tournoi_id);
            pst.executeUpdate();

            pst = commonSwing.getCon().prepareStatement("update onlinebanking.type_tournoi set description_messieur = ?,user_id=? where tournoi_id = ?");
            pst.setString(1,tournoi_typeTournoi);
            pst.setString(2,"3");
            pst.setString(3,tournoi_id);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Tournoi et type tournoi mis à jour !");
            commonSwing.table_load_tournoi(tableTournoi);



            txtNomTournoi.setText("");
            setJcomboBoxTypeTournoi(0);
            setJDateChooserDateDebutTournoi(null);
            setJDateChooserDateFinTournoi(null);
            txtNbrInscritTournoi.setText("");
            setJcomboBoxNombreDeTourTournoi(0);
            txtNombreDeJoueurTournoi.setText("");
            txtSearchTournoi.setText("");
            txtNomTournoi.requestFocus();
        }

        catch (SQLException e1)
        {
            e1.printStackTrace();
        }
    }

    public void rechercherTournoiJDBC() {
        try {

            String tournoiId = txtSearchTournoi.getText();

            pst = commonSwing.getCon().prepareStatement("" +
                    "SELECT tournoi.nom_tournoi as 'Nom du tournoi', " +
                    "tournoi.date_debut_tournoi as 'Date de debut',   " +
                    "tournoi.date_fin_tournoi as 'Date de fin',  " +
                    "tournoi.nbr_inscrit as 'Nombre inscrit',     " +
                    "tournoi.nbr_tour as 'nombre de tour' ," +
                    "tournoi.nbre_joueurs_max as 'nombre de joueur max'," +
                    "type_tournoi.description_messieur as 'Type de tournoi' FROM onlinebanking.tournoi    INNER JOIN onlinebanking.type_tournoi ON tournoi.id = type_tournoi.tournoi_id where tournoi.id = ?");
            pst.setString(1, tournoiId);
            ResultSet rs = pst.executeQuery();

            if(rs.next()==true)
            {
                String nom_tournoi = rs.getString(1);
                String date_debut_tournoi = rs.getString(2);
                String date_fin_tournoi = rs.getString(3);
                String nbr_inscrit = rs.getString(4);
                String nbr_tour = rs.getString(5);
                String nbre_joueurs_max = rs.getString(6);
                String description_messieur = rs.getString(7);


                txtNomTournoi.setText(nom_tournoi);
                setJDateChooserDateDebutTournoi(date_debut_tournoi);
                setJDateChooserDateFinTournoi(date_fin_tournoi);
                if(description_messieur.equalsIgnoreCase("Simple messieurs")){

                    setJcomboBoxTypeTournoi(0);
                }
                if(description_messieur.equalsIgnoreCase("Double messieurs")){

                    setJcomboBoxTypeTournoi(1);
                }
                txtNbrInscritTournoi.setText(nbr_inscrit);
                setJcomboBoxNombreDeTourTournoi(Integer.parseInt(nbr_tour)-1);
                txtNombreDeJoueurTournoi.setText(nbre_joueurs_max);
                txtSearchTournoi.setText(tournoiId);
                txtNomTournoi.requestFocus();


            }
            else
            {
                txtNomTournoi.setText("");
                setJcomboBoxTypeTournoi(0);
                setJDateChooserDateDebutTournoi(null);
                setJDateChooserDateFinTournoi(null);
                txtNbrInscritTournoi.setText("");
                setJcomboBoxNombreDeTourTournoi(0);
                txtNombreDeJoueurTournoi.setText("");
                txtSearchTournoi.setText("");
                txtNomTournoi.requestFocus();
                JOptionPane.showMessageDialog(null,"Invalid tournoi No");

            }
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    Date convertStringToDate(String sDate1){

        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void enregistrerTournoiJDBC() {

        String tournoi_name;
        String tournoi_typeTournoi;
        String tournoi_dateDebutTournoi ;
        String tournoi_dateFinTournoi;
        String tournoi_nbreInscritTournoi;
        String tournoi_nbreDeTourTournoi;
        String tournoi_nbreDeJoueurTournoi;
        String tournoi_id;

        tournoi_name=txtNomTournoi.getText();
        tournoi_typeTournoi=getJcomboBoxTypeTournoi();

        tournoi_dateDebutTournoi=getJDateChooserDateDebutTournoi();
        java.sql.Date tournoi_dateDebutTournoi_sql = new java.sql.Date(convertStringToDate(getJDateChooserDateDebutTournoi()).getTime());

        tournoi_dateFinTournoi=getJDateChooserDateFinTournoi();
        java.sql.Date tournoi_dateFinTournoi_sql = new java.sql.Date(convertStringToDate(getJDateChooserDateFinTournoi()).getTime());
        tournoi_nbreInscritTournoi=txtNbrInscritTournoi.getText();
        tournoi_nbreDeTourTournoi=getJcomboBoxNombreDeTourTournoi();
        tournoi_nbreDeJoueurTournoi=txtNombreDeJoueurTournoi.getText();
        tournoi_id= txtSearchTournoi.getText();


        try {
            //insert into tournoi (id, date_debut_tournoi, date_fin_tournoi, nbr_inscrit, nbr_tour, nbre_joueurs_max, nom_tournoi )
            //values ()
            pst = commonSwing.getCon().prepareStatement("insert into onlinebanking.tournoi( date_debut_tournoi, date_fin_tournoi, nbr_inscrit, nbr_tour, nbre_joueurs_max, nom_tournoi,user_id )values(?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            pst.setDate(1, (java.sql.Date) tournoi_dateDebutTournoi_sql);
            pst.setDate(2, (java.sql.Date) tournoi_dateFinTournoi_sql);
            pst.setString(3, tournoi_nbreInscritTournoi);
            pst.setString(4, tournoi_nbreDeTourTournoi);
            pst.setString(5, tournoi_nbreDeJoueurTournoi);
            pst.setString(6, tournoi_name);
            pst.setString(7, "3");
            pst.executeUpdate();

            ResultSet rs = pst.getGeneratedKeys();
            String tournoi_id_generated="";
            if (rs.next()){
                 tournoi_id_generated = rs.getString(1);
            }
            
            pst = commonSwing.getCon().prepareStatement("insert into onlinebanking.type_tournoi(description_messieur, tournoi_id,user_id) values (?,?,?) ",Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, tournoi_typeTournoi);
            pst.setString(2, tournoi_id_generated);
            pst.setString(3, "3");
            pst.executeUpdate();


            JOptionPane.showMessageDialog(null, "Tournoi et Type Tournoi ajouté !");
            commonSwing.table_load_tournoi(tableTournoi);
            txtNomTournoi.setText("");
            setJcomboBoxTypeTournoi(0);
            setJDateChooserDateDebutTournoi(null);
            setJDateChooserDateFinTournoi(null);
            txtNbrInscritTournoi.setText("");
            setJcomboBoxNombreDeTourTournoi(0);
            txtNombreDeJoueurTournoi.setText("");
            txtSearchTournoi.setText("");
            txtNomTournoi.requestFocus();
        }

        catch (Exception e1)
        {

            e1.printStackTrace();
        }
    }


}
