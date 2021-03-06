package com.userfront.domain.tennis;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.userfront.domain.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Tournoi {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne(cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "billet_id")
    private Billet billet;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToMany(mappedBy = "tournois")
    private List<Joueur> joueurs = new ArrayList<>();

    @OneToMany(mappedBy = "tournoi", cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH})
    private List<TypeTournoi> typeTournois = new ArrayList<>();

    @OneToMany(mappedBy = "tournoi", cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH}, orphanRemoval = true)
    private List<DateTournoi> dateTournois = new ArrayList<>();

    @Column(name = "date_debut_tournoi")
    private Date date_debut_tournoi;

    @Column(name = "date_fin_tournoi")
    private Date date_fin_tournoi;

    @Column(name = "nom_tournoi")
    private String nom_tournoi;

    @Column(name = "nbr_inscrit")
    private String nbr_inscrit;

    @Column(name = "nbr_tour")
    private String nbr_tour;

    @Column(name = "nbre_joueurs_max")
    private String nbre_joueurs_max;

    public Billet getBillet() {
        return billet;
    }

    public void setBillet(Billet billet) {
        this.billet = billet;
    }

    public String getNbre_joueurs_max() {
        return nbre_joueurs_max;
    }

    public void setNbre_joueurs_max(String nbre_joueurs_max) {
        this.nbre_joueurs_max = nbre_joueurs_max;
    }

    public String getNbr_tour() {
        return nbr_tour;
    }

    public void setNbr_tour(String nbr_tour) {
        this.nbr_tour = nbr_tour;
    }

    public String getNbr_inscrit() {
        return nbr_inscrit;
    }

    public void setNbr_inscrit(String nbr_inscrit) {
        this.nbr_inscrit = nbr_inscrit;
    }

    public String getNom_tournoi() {
        return nom_tournoi;
    }

    public void setNom_tournoi(String nom_tournoi) {
        this.nom_tournoi = nom_tournoi;
    }

    public Date getDate_fin_tournoi() {
        return date_fin_tournoi;
    }

    public void setDate_fin_tournoi(Date date_fin_tournoi) {
        this.date_fin_tournoi = date_fin_tournoi;
    }

    public Date getDate_debut_tournoi() {
        return date_debut_tournoi;
    }

    public void setDate_debut_tournoi(Date date_debut_tournoi) {
        this.date_debut_tournoi = date_debut_tournoi;
    }

    public List<DateTournoi> getDateTournois() {
        return dateTournois;
    }

    public void setDateTournois(List<DateTournoi> dateTournois) {
        this.dateTournois = dateTournois;
    }

    public List<TypeTournoi> getTypeTournois() {
        return typeTournois;
    }

    public void setTypeTournois(List<TypeTournoi> typeTournois) {
        this.typeTournois = typeTournois;
    }

    public List<Joueur> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(List<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Tournoi{" +
                "tournoiId=" + id +
                ", joueurs=" + joueurs +
                ", typeTournois=" + typeTournois +
                ", dateTournois=" + dateTournois +
                ", date_debut_tournoi=" + date_debut_tournoi +
                ", date_fin_tournoi=" + date_fin_tournoi +
                ", nom_tournoi='" + nom_tournoi + '\'' +
                ", nbr_inscrit='" + nbr_inscrit + '\'' +
                ", nbr_tour='" + nbr_tour + '\'' +
                ", nbre_joueurs_max='" + nbre_joueurs_max + '\'' +
                '}';
    }
}

