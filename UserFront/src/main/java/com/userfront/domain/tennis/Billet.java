package com.userfront.domain.tennis;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.userfront.domain.User;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Billet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "billet", cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH}, orphanRemoval = true)
    private List<CategorieBillet> categorieBillets = new ArrayList<>();

    @Temporal(TemporalType.DATE)
    @Column(name = "journee_du")
    private Date journeeDu;

    @Column(name = "nbreplace")
    private String nbreplace;

    @Column(name = "prix_billet", precision = 19, scale = 2)
    private BigDecimal prixBillet;


    @OneToMany(mappedBy = "billet", cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH}, orphanRemoval = true)
    private List<MatchTennis> matchTennises = new ArrayList<>();

    @OneToMany(mappedBy = "billet", cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH}, orphanRemoval = true)
    private List<Emplacement> emplacements = new ArrayList<>();

    @OneToMany(mappedBy = "billet", cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH}, orphanRemoval = true)
    private List<CategoriePlace> categoriePlaces = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "billet", cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH})
    private List<Tournoi> tournois = new ArrayList<>();

    public List<Tournoi> getTournois() {
        return tournois;
    }

    public void setTournois(List<Tournoi> tournois) {
        this.tournois = tournois;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CategoriePlace> getCategoriePlaces() {
        return categoriePlaces;
    }

    public void setCategoriePlaces(List<CategoriePlace> categoriePlaces) {
        this.categoriePlaces = categoriePlaces;
    }

    public List<Emplacement> getEmplacements() {
        return emplacements;
    }

    public void setEmplacements(List<Emplacement> emplacements) {
        this.emplacements = emplacements;
    }

    public List<MatchTennis> getMatchTennises() {
        return matchTennises;
    }

    public void setMatchTennises(List<MatchTennis> matchTennises) {
        this.matchTennises = matchTennises;
    }


    public BigDecimal getPrixBillet() {
        return prixBillet;
    }

    public void setPrixBillet(BigDecimal prixBillet) {
        this.prixBillet = prixBillet;
    }

    public String getNbreplace() {
        return nbreplace;
    }

    public void setNbreplace(String nbreplace) {
        this.nbreplace = nbreplace;
    }

    public Date getJourneeDu() {
        return journeeDu;
    }

    public void setJourneeDu(Date journeeDu) {
        this.journeeDu = journeeDu;
    }

    public List<CategorieBillet> getCategorieBillets() {
        return categorieBillets;
    }

    public void setCategorieBillets(List<CategorieBillet> categorieBillets) {
        this.categorieBillets = categorieBillets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
