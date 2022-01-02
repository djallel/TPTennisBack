package com.userfront.domain.tennis;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "billet")
public class Billet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "billetId", nullable = false)
    private Long billetId;

    @OneToMany(mappedBy = "billet", cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH}, orphanRemoval = true)
    private List<CategorieBillet> categorieBillets = new ArrayList<>();

    @Temporal(TemporalType.DATE)
    @Column(name = "journee_du")
    private Date journeeDu;

    @Column(name = "nbre_place")
    private Integer nbre_place;

    @Column(name = "prix_billet", precision = 19, scale = 2)
    private BigDecimal prixBillet;

    @OneToMany(mappedBy = "billet", cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH}, orphanRemoval = true)
    private List<Tournoi> tournois = new ArrayList<>();

    @OneToMany(mappedBy = "billet", cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH}, orphanRemoval = true)
    private List<MatchTennis> matchTennises = new ArrayList<>();

    @OneToMany(mappedBy = "billet", cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH}, orphanRemoval = true)
    private List<Emplacement> emplacements = new ArrayList<>();

    @OneToMany(mappedBy = "billet", cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH}, orphanRemoval = true)
    private List<CategoriePlace> categoriePlaces = new ArrayList<>();

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

    public List<Tournoi> getTournois() {
        return tournois;
    }

    public void setTournois(List<Tournoi> tournois) {
        this.tournois = tournois;
    }

    public BigDecimal getPrixBillet() {
        return prixBillet;
    }

    public void setPrixBillet(BigDecimal prixBillet) {
        this.prixBillet = prixBillet;
    }

    public Integer getNbre_place() {
        return nbre_place;
    }

    public void setNbre_place(Integer nbre_place) {
        this.nbre_place = nbre_place;
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

    public Long getBilletId() {
        return billetId;
    }

    public void setBilletId(Long billetId) {
        this.billetId = billetId;
    }
}
