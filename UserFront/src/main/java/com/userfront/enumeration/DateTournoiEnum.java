package com.userfront.enumeration;

public enum DateTournoiEnum {

    TOUR_PREMIER("Premier tour"),
    TOUR_DEMI_FINAL("Demi final"),
    TOUR_FINAL("Final");

    public final String dateTournoi;

    DateTournoiEnum(String dateTournoi) {
        this.dateTournoi = dateTournoi;
    }
}
