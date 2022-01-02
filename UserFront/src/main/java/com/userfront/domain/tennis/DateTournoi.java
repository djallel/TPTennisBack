package com.userfront.domain.tennis;

import javax.persistence.*;

@Entity
@Table(name = "date_tournoi")
public class DateTournoi {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "description_tour")
    /**
     * 1er tour / 1/2 final / final
     */
    private String description_tour;

    @ManyToOne(cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "tournoi_tournoi_id")
    private Tournoi tournoi;

    public Tournoi getTournoi() {
        return tournoi;
    }

    public void setTournoi(Tournoi tournoi) {
        this.tournoi = tournoi;
    }

    public String getDescription_tour() {
        return description_tour;
    }

    public void setDescription_tour(String description_tour) {
        this.description_tour = description_tour;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DateTournoi{" +
                "id=" + id +
                ", description_tour='" + description_tour + '\'' +
                ", tournoi=" + tournoi +
                '}';
    }
}
