package com.userfront.domain.tennis;

import com.userfront.enumeration.CategorieBilletEnum;

import javax.persistence.*;

@Entity
@Table(name = "categorie_billet")
public class CategorieBillet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "categorie_billet_enum")
    private CategorieBilletEnum categorieBilletEnum;

    @ManyToOne(cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "billet_billet_id")
    private Billet billet;

    public Billet getBillet() {
        return billet;
    }

    public void setBillet(Billet billet) {
        this.billet = billet;
    }

    public CategorieBilletEnum getCategorieBilletEnum() {
        return categorieBilletEnum;
    }

    public void setCategorieBilletEnum(CategorieBilletEnum categorieBilletEnum) {
        this.categorieBilletEnum = categorieBilletEnum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
