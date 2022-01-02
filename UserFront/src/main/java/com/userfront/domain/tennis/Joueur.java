package com.userfront.domain.tennis;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Joueur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long joueurId;
    private String name;
    private String email;
    private String phone;
    private String NumLicence;
    private String description;//Vainqueur/qualifié/demifinaliste/finaliste

    @ManyToMany(cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "joueur_tournois",
            joinColumns = @JoinColumn(name = "joueur_joueurId"),
            inverseJoinColumns = @JoinColumn(name = "tournois_tournoi_id"))
    private List<Tournoi> tournois = new ArrayList<>();

    public List<Tournoi> getTournois() {
        return tournois;
    }

    public void setTournois(List<Tournoi> tournois) {
        this.tournois = tournois;
    }

    public Long getJoueurId() {
        return joueurId;
    }

    public void setJoueurId(Long id) {
        this.joueurId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNumLicence() {
        return NumLicence;
    }

    public void setNumLicence(String numLicence) {
        NumLicence = numLicence;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "joueurId=" + joueurId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", NumLicence='" + NumLicence + '\'' +
                ", description='" + description + '\'' +
                ", tournois=" + tournois +
                '}';
    }
}

