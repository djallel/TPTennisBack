package com.userfront.jswing;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class FenetrePrincipale {
    private JPanel Main;
    private JTabbedPane tabbedPaneJoueur;
    private JTabbedPane tabbedPaneTournoi;
    private JTabbedPane tabbedPaneMatch;
    private JTabbedPane tabbedPaneArbitre;
    private JLabel informationJoueurLabel;
    private JLabel nomJoueurLabel;
    private JLabel emailLabel;
    private JLabel numéroDeLicenceLabel;
    private JTextField textFieldNomJoueur;
    private JTextField textFieldEmail;
    private JTextField textFieldNumLicence;
    private JButton enregistrerButton;
    private JTable table1;
    private JButton mettreÀJourButton;
    private JButton supprimerButton;
    private JButton rechercheButton;
    private JTextField textFieldSearch;
    private JLabel telephoneLabel;
    private JTextField textFieldTelephone;
    private JTextArea textAreaDescription;
    private JLabel descriptionLabel;
    private JPanel MainJoueur;
    Connection con;
    PreparedStatement pst;


    public static void main(String[] args) {
        JFrame frame = new JFrame("Application Tennis");
        frame.setContentPane(new FenetrePrincipale().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public FenetrePrincipale() {
        connect();
        enregistrerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
                   /* INSERT INTO `onlinebanking`.`joueur`
                    (`joueur_id`,
`num_licence`,
`description`,
`email`,
`name`,
`phone`,
`id`,
`user_id`)
                    VALUES
                            (<{joueur_id: }>,
<{num_licence: }>,
<{description: }>,
<{email: }>,
<{name: }>,
<{phone: }>,
<{id: }>,
<{user_id: }>);*/
                    pst = con.prepareStatement("insert into onlinebanking.joueur(num_licence,description,email,name,phone)values(?,?,?,?,?)");
                    pst.setString(1, joueur_numLicence);
                    pst.setString(2, joueur_description);
                    pst.setString(3, joueur_email);
                    pst.setString(4, joueur_name);
                    pst.setString(5, joueur_phone);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record Addedddd!!!!!");
                    table_load();
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
        });
        rechercheButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
/**
 SELECT `joueur`.`joueur_id`,
 `joueur`.`num_licence`,
 `joueur`.`description`,
 `joueur`.`email`,
 `joueur`.`name`,
 `joueur`.`phone`,
 `joueur`.`id`,
 `joueur`.`user_id`
 FROM `onlinebanking`.`joueur`;
 SELECT * FROM onlinebanking.joueur;
 */

                try {

                    String joueurId = textFieldSearch.getText();

                    pst = con.prepareStatement("select num_licence,description,email,name,phone from onlinebanking.joueur where id = ?");
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
        });
        mettreÀJourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


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
                    pst = con.prepareStatement("update onlinebanking.joueur set num_licence = ?,description = ?,email = ?,name = ?,phone = ? where id = ?");
                    //num_licence,description,email,name,phone)
                    pst.setString(1, joueur_numLicence);
                    pst.setString(2, joueur_description);
                    pst.setString(3, joueur_email);
                    pst.setString(4, joueur_name);
                    pst.setString(5, joueur_phone);
                    pst.setString(6, joueur_id);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record updated!!!!!");
                    table_load();
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



        });
        supprimerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String joueurId = textFieldSearch.getText();

                try {
                    pst = con.prepareStatement("delete from onlinebanking.joueur  where id = ?");

                    pst.setString(1, joueurId);

                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record Deleteeeeee!!!!!");
                    table_load();

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
        });
    }

    void table_load()
    {
        try
        {
            pst = con.prepareStatement("select * from onlinebanking.joueur");
            ResultSet rs = pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void connect (){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinebanking","root","");
            System.out.println("Success");
        }catch (ClassNotFoundException ex){
            System.out.println("ClassNotFoundException ici"+ex);
            ex.printStackTrace();
        }catch (SQLException ex){
            System.out.println("SQLException ici"+ex);
            ex.printStackTrace();
        }
    }
}
