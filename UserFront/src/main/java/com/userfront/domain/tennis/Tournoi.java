package com.userfront.domain.tennis;

import javax.persistence.*;

@Entity
public class Tournoi {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tournoiId;
    private String name;
    private String email;
    private String phone;
    private String NumLicence;
    private String description;//Vainqueur/qualifié/demifinaliste/finaliste


    public Long getTournoiId() {
        return tournoiId;
    }

    public void setTournoiId(Long id) {
        this.tournoiId = id;
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
                "id=" + tournoiId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", NumLicence='" + NumLicence + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

