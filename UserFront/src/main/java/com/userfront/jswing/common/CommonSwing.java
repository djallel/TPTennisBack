package com.userfront.jswing.common;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.sql.*;

public class CommonSwing {
    Connection con;
    PreparedStatement pst;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public PreparedStatement getPst() {
        return pst;
    }

    public void setPst(PreparedStatement pst) {
        this.pst = pst;
    }

    public CommonSwing() {
    }

    public void table_load_joueur(JTable table1)
    {
        try
        {
            pst = this.getCon().prepareStatement("select * from Tennis.joueur");
            ResultSet rs = pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void table_load_arbitre(JTable table1)
    {
        try
        {
            pst = this.getCon().prepareStatement("select * from Tennis.arbitre");
            ResultSet rs = pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void table_load_tournoi(JTable table1)
    {
        try
        {
            pst = this.getCon().prepareStatement("select * from Tennis.tournoi");
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
            setCon(DriverManager.getConnection("jdbc:mysql://localhost:3306/Tennis","root",""));
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
