package com.userfront.domain.tennis;

import javax.persistence.*;

@Entity
@Table(name = "type_tournoi")
public class TypeTournoi {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "description_messieur")
    /**
     * TypeTournoi = SimpleMessieurs ou DoubleMessieurs
     */
    private String description_messieur;

    @ManyToOne(cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "tournoi_id")
    private Tournoi tournoi;

    public Tournoi getTournoi() {
        return tournoi;
    }

    public void setTournoi(Tournoi tournoi) {
        this.tournoi = tournoi;
    }

    public String getDescription_messieur() {
        return description_messieur;
    }

    public void setDescription_messieur(String description_messieur) {
        this.description_messieur = description_messieur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TypeTournoi{" +
                "id=" + id +
                ", description_messieur='" + description_messieur + '\'' +
                ", tournoi=" + tournoi +
                '}';
    }
}
