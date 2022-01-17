package com.userfront.domain.tennis;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.userfront.domain.User;

import javax.persistence.*;

@Entity
@Table(name = "categorie_place")
public class CategoriePlace {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "description")
    /**
     * Loges ( bleu ) Cat 1 Cat 2
     */
    private String description;

    @ManyToOne
    @JoinColumn(name = "billet_id")
    private Billet billet;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Billet getBillet() {
        return billet;
    }

    public void setBillet(Billet billet) {
        this.billet = billet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
