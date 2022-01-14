package com.userfront.jswing;

import com.userfront.jswing.common.CommonSwing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class FenetrePrincipale {
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
    public JTable table1;
    public JButton mettreÀJourButton;
    public JButton supprimerButton;
    public JButton rechercheButton;
    public JTextField textFieldSearch;
    public JLabel telephoneLabel;
    public JTextField textFieldTelephone;
    public JTextArea textAreaDescription;
    public JLabel descriptionLabel;
    public JPanel MainJoueur;
    public CommonSwing commonSwing = new CommonSwing();
    public PreparedStatement pst;


    public static void main(String[] args) {

        JFrame frame = new JFrame("Application Tennis");
        frame.setContentPane(new FenetrePrincipale().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public FenetrePrincipale() {
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
    }

    public void supprimerJoueurJDBC() {
        String joueurId = textFieldSearch.getText();

        try {
            pst = commonSwing.getCon().prepareStatement("delete from onlinebanking.joueur  where id = ?");

            pst.setString(1, joueurId);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record Deleteeeeee!!!!!");
            commonSwing.table_load(table1);

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
            commonSwing.table_load(table1);
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
            commonSwing.table_load(table1);
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


}
