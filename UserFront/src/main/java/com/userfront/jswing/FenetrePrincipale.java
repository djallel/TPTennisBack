package com.userfront.jswing;

import com.toedter.calendar.*;
import com.userfront.jswing.common.CommonSwing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
    private JTextField textField1;
    private JPanel jpanelTournoi;
    private JPanel jPaneldateDebutTournoi;
    private JPanel jPanelDateFinTournoi;
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
        GetDate();
        JDateChooserDateFinTournoi.setDateFormatString("dd/MM/yyyy");
        SetDate(JDateChooserDateFinTournoi);
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
    }

    private void GetDate() {
        SimpleDateFormat sdfmt = new SimpleDateFormat("dd/MM/yyyy");
        String dt=sdfmt.format(JDateChooserDateDebutTournoi.getDate());
        System.out.println(dt);
    }

    private  void SetDate(JDateChooser JDateChooserDateFinTournoi){
        SimpleDateFormat sdfmt = new SimpleDateFormat("dd/MM/yyyy");
        String dt ="01/01/2022";
        try {
            Date date = sdfmt.parse(dt);
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

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
