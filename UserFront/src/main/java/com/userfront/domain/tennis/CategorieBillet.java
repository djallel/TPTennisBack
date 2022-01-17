package com.userfront.domain.tennis;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.userfront.domain.User;
import com.userfront.enumeration.CategorieBilletEnum;

import javax.persistence.*;

@Entity
@Table(name = "categorie_billet")
public class CategorieBillet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


    @ManyToOne(cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH})
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
    @Column(name = "categorie_billet_enum_string")
    private String categorieBilletEnumString;

    public String getCategorieBilletEnumString() {
        return categorieBilletEnumString;
    }

    public void setCategorieBilletEnumString(String categorieBilletEnumString) {
        this.categorieBilletEnumString = categorieBilletEnumString;
    }

    public Billet getBillet() {
        return billet;
    }

    public void setBillet(Billet billet) {
        this.billet = billet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
